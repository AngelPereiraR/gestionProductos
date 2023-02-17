package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class ProductModel {
	private long id;
	
	private String name;
	
	private String description;
	
	private boolean favorite;
	
	private double price;
	
	@JsonBackReference
	private CategoryModel category;

	public ProductModel() {
		super();
	}

	public ProductModel(long id, String name, String description, double price, CategoryModel category,boolean favorite) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.category = category;
		this.favorite = favorite;
	}

	public boolean isFavorite() {
		return favorite;
	}

	public void setFavorite(boolean favorite) {
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

	public CategoryModel getCategory() {
		return category;
	}

	public void setCategory(CategoryModel category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "ProductModel [id=" + id + ", name=" + name + ", description=" + description + ", favorite=" + favorite
				+ ", price=" + price + ", category=" + category + "]";
	}
}
