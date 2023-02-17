package com.example.demo.controllers;

import java.util.List;

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

import com.example.demo.model.ProductModel;
import com.example.demo.services.CategoryService;
import com.example.demo.services.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {
	@Autowired
	@Qualifier("productService")
	private ProductService productService;
	
	@Autowired
	@Qualifier("categoryService")
	private CategoryService categoryService;
	
	@DeleteMapping("/admin/products/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable int id) {
		boolean existe = true;
		existe = productService.removeProduct(id);
		if(existe==false) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/admin/categories/{id}/products")
	public ResponseEntity<?> deleteAllProducts(@PathVariable int id) {
		boolean existe = true;
		existe = productService.removeProductsOfCategory(id);
		if(existe==false) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/admin/categories/{id}/product")
	public ResponseEntity<?> insertProduct(@PathVariable int id, @RequestBody ProductModel product)
	{
		productService.addProduct(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(product);
		
	}
	
	@GetMapping("/user/categories/{id}/products")
	public ResponseEntity<?> getProductsByCategory(@PathVariable int id){
		
		List<ProductModel> products= productService.listProductByCategory(id);
		if(products.isEmpty()) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(products);
		}
	
		
	}
	
	@GetMapping("/user/products/favorite")
	public ResponseEntity<?> getProductsFavorite(){
		
		List<ProductModel> products= productService.listProductByFavorite(true);
		if(products.isEmpty()) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(products);
		}
	
		
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<?> getProductById(@PathVariable int id){
		
		ProductModel product= productService.findProductByIdModel(id);
		if(product==null) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(product);
		}
	
		
	}
	
	
	@PutMapping("/admin/products/{id}")
	public ResponseEntity<?> updateProductById(@PathVariable int id, @RequestBody ProductModel product)
	{
		
		return ResponseEntity.ok(productService.updateProduct(product));
		
	}
	
}
