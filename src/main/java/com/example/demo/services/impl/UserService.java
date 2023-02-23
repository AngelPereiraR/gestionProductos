package com.example.demo.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.model.CategoryModel;
import com.example.demo.model.ProductModel;
import com.example.demo.model.UserModel;
import com.example.demo.repository.UserRepository;

@Service("userService")
public class UserService implements UserDetailsService {

	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.example.demo.entity.User usuario = userRepository.findByUsername(username);

		UserBuilder builder = null;
		if (usuario != null) {
			builder = User.withUsername(username);
			builder.disabled(false);
			builder.password(usuario.getPassword());
			builder.authorities(new SimpleGrantedAuthority(usuario.getRole()));
		} else {
			throw new UsernameNotFoundException("Usuario no encontrado");
		}
		return builder.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public com.example.demo.entity.User registrar(com.example.demo.entity.User user) {
		com.example.demo.entity.User usuario=new com.example.demo.entity.User();
		usuario.setUsername(user.getUsername());
		usuario.setPassword(passwordEncoder().encode(user.getPassword()));
		usuario.setEnabled(true);
		usuario.setRole("ROLE_USER");

		return userRepository.save(usuario);
	}

	public com.example.demo.entity.User findUser(String username) {
		return userRepository.findByUsername(username);
	}
	
	public com.example.demo.entity.User transform(UserModel userModel) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(userModel, com.example.demo.entity.User.class);
	}
	

	
	public UserModel transform(com.example.demo.entity.User user) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(user, UserModel.class);
	}
	public com.example.demo.entity.User updateUser(UserModel user) {
		// TODO Auto-generated method stub
		return userRepository.save(transform(user));
	}
}
