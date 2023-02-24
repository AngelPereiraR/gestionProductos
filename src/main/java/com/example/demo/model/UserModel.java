package com.example.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

public class UserModel {

private long id;
	
	private String username;
	
	private String password;
	
	private String role;
	
	@JsonManagedReference
	private List<FavoriteProduct> favorite;
	
	private boolean enabled;
	
	private String token;

	public UserModel() {
		super();
	}

	
	
	public UserModel(long id, String username, String password, String role, List<FavoriteProduct> favorite,
			boolean enabled, String token) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.favorite = favorite;
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
	
	

	public List<FavoriteProduct> getFavorite() {
		return favorite;
	}



	public void setFavorite(List<FavoriteProduct> favorite) {
		this.favorite = favorite;
	}



	@Override
	public String toString() {
		return "UserModel [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role
				+ ", enabled=" + enabled + ", token=" + token + "]";
	}
}
