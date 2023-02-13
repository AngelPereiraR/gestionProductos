package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.services.CategoryService;

@Controller("categoryController")
public class CategoryController {
	@Autowired
	@Qualifier("categoryService")
	private CategoryService categoryService;
	
	@DeleteMapping("/api/categories/{id}")
	public ResponseEntity<?> deleteCategory(@PathVariable int id) {
		boolean existe = true;
		existe = categoryService.removeProductsAndCategory(id);
		if(existe==false) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
