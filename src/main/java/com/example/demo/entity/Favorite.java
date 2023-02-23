package com.example.demo.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Favorite {
	@Id
	@GeneratedValue
	private long id;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "productId")
	private Product product;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;

	public Favorite() {
		super();
	}

	public Favorite(long id, Product product, User user) {
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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Favorite [id=" + id + ", product=" + product + ", user=" + user + "]";
	}
	
	
}
