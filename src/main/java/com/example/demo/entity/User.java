package com.example.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class User {

	@Id
	@GeneratedValue
	private long id;
	
	@Column(name="username", unique=true, nullable=false)
	private String username;
	
	@Column(name="password", nullable=false)
	private String password;
	
	@JsonManagedReference
	@OneToMany( mappedBy = "product")
	private List<Favorite> favorite;
	
	private String role;
	
	private boolean enabled;
	
	private String token;

	public User() {
		super();
	}



	public User(long id, String username, String password, List<Favorite> favorite, String role, boolean enabled,
			String token) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.favorite = favorite;
		this.role = role;
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

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
	
	public List<Favorite> getFavorite() {
		return favorite;
	}



	public void setFavorite(List<Favorite> favorite) {
		this.favorite = favorite;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role
				+ ", enabled=" + enabled + ", token=" + token + "]";
	}
	
	

}
