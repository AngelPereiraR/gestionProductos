package com.example.demo.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

public class CategoryModel {
	private long id;
	
	private String name;
	
	private String description;
	
	private List<ProductModel> categoryId;

	public CategoryModel() {
		super();
	}

	public CategoryModel(long id, String name, String description, List<ProductModel> categoryId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.categoryId = categoryId;
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

	public List<ProductModel> getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(List<ProductModel> categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", description=" + description + ", categoryId=" + categoryId
				+ "]";
	}
}
