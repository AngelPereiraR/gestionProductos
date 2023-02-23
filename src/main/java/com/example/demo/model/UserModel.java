package com.example.demo.model;

import java.util.List;

import com.example.demo.entity.Product;

public class UserModel {

private long id;
	
	private String username;
	
	private String password;
	
	private String role;
	
	private List<Product> favorites;
	
	private boolean enabled;
	
	private String token;

	public UserModel() {
		super();
	}

	

	public UserModel(long id, String username, String password, String role, List<Product> favorites, boolean enabled,
			String token) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.favorites = favorites;
		this.enabled = enabled;
		this.token = token;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getToken() {
		return token;
	}
	
	

	public List<Product> getFavorites() {
		return favorites;
	}



	public void setFavorites(List<Product> favorites) {
		this.favorites = favorites;
	}



	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public void setToken(String token) {
		this.token = token;
	}



	@Override
	public String toString() {
		return "UserModel [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role
				+ ", favorites=" + favorites + ", enabled=" + enabled + ", token=" + token + "]";
	}

	
}
