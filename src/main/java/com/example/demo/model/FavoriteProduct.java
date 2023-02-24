package com.example.demo.model;

import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class FavoriteProduct {
	private long id;
	
	@JsonBackReference
	private ProductModel product;
	
	@JsonBackReference
	private UserModel user;
	
	public FavoriteProduct() {
		super();
	}

	public FavoriteProduct(long id, ProductModel product, UserModel user) {
		super();
		this.id = id;
		this.product = product;
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ProductModel getProduct() {
		return product;
	}

	public void setProduct(ProductModel product) {
		this.product = product;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Favorite [id=" + id + ", product=" + product + ", user=" + user + "]";
	}
	
	
}
