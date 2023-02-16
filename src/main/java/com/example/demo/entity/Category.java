package com.example.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {
	@Id
	@GeneratedValue
	private long id;
	
	private String name;
	
	private String description;
	
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	private List<Product> categoryId;

	public Category() {
		super();
	}

	public Category(long id, String name, String description, List<Product> categoryId) {
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

	public List<Product> getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(List<Product> categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", description=" + description + ", categoryId=" + categoryId
				+ "]";
	}
}
