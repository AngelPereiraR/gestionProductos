package com.example.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Product {
	@Id
	@GeneratedValue
	private long id;
	
	private String name;
	
	private String description;
	
	private double price;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "categoryId")
	private Category category;
	
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
	@JsonIgnore
	private List<Favorite> favorite;
	
	public Product() {
		super();
	}

	
	
	public Product(long id, String name, String description, double price, Category category, List<Favorite> favorite) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.category = category;
		this.favorite = favorite;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	

	public List<Favorite> getFavorite() {
		return favorite;
	}



	public void setFavorite(List<Favorite> favorite) {
		this.favorite = favorite;
	}



	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", category=" + category + "]";
	}
}
