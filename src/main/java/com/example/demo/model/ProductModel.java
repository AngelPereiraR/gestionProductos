package com.example.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class ProductModel {
	private long id;
	
	private String name;
	
	private String description;
	
	private double price;
	
	@JsonBackReference
	private CategoryModel category;
	
	private List<FavoriteProduct> favorite;

	public ProductModel() {
		super();
	}

	
	public ProductModel(long id, String name, String description, double price, CategoryModel category,
			List<FavoriteProduct> favorite) {
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

	public CategoryModel getCategory() {
		return category;
	}

	public void setCategory(CategoryModel category) {
		this.category = category;
	}

	
	
	public List<FavoriteProduct> getFavorite() {
		return favorite;
	}


	public void setFavorite(List<FavoriteProduct> favorite) {
		this.favorite = favorite;
	}


	@Override
	public String toString() {
		return "ProductModel [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", category=" + category + "]";
	}
}
