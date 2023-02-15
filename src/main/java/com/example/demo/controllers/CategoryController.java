package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Category;
import com.example.demo.model.CategoryModel;
import com.example.demo.model.ProductModel;
import com.example.demo.services.CategoryService;

@RestController
@RequestMapping("/api")
public class CategoryController {
	@Autowired
	@Qualifier("categoryService")
	private CategoryService categoryService;
	
	@PostMapping("/categories/{id}")
	public ResponseEntity<?> insertCategory(@PathVariable int id, @RequestBody CategoryModel category)
	{
		
		category.setId(id);
		categoryService.addCategory(category);
		return ResponseEntity.status(HttpStatus.CREATED).body(category);
		
	}
	
	@DeleteMapping("/categories/{id}")
	public ResponseEntity<?> deleteCategory(@PathVariable int id) {
		boolean existe = true;
		existe = categoryService.removeProductsAndCategory(id);
		if(existe==false) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping("/categories/{id}")
	public ResponseEntity<?> updateProductById(@PathVariable int id, @RequestBody CategoryModel product)
	{
		
		return ResponseEntity.ok(categoryService.updateCategory(product));
		
	}
	
	@GetMapping("/categories/{id}")
	public ResponseEntity<?> getProductById(@PathVariable int id){
		
		CategoryModel category= categoryService.findCategoryByIdModel(id);
		if(category==null) {
			return ResponseEntity.noContent().build();
		}else {
			return	ResponseEntity.ok(category);
		}
	}
		
}
