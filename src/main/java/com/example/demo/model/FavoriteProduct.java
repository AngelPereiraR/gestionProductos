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

	private Product product;
	
	private User user;
}
