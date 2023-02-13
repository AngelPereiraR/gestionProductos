package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.services.ProductService;

public class ProductController {
	@Autowired
	@Qualifier("productService")
	private ProductService productService;
	
	@DeleteMapping("/api/products/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable int id) {
		boolean existe = true;
		existe = productService.removeProduct(id);
		if(existe==false) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/api/categories/{id}/products")
	public ResponseEntity<?> deleteAllProducts(@PathVariable int id) {
		boolean existe = true;
		existe = productService.removeProductsOfCategory(id);
		if(existe==false) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
