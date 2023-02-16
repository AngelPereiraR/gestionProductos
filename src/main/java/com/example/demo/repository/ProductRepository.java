package com.example.demo.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Product;

@Repository("productRepository")
public interface ProductRepository extends JpaRepository <Product, Serializable>{
	public abstract Product findById(int id);
	public abstract void deleteAllByCategoryId(int categoryId);
	public abstract List<Product> findByCategoryId(int categoryId);
	public abstract List<Product> findByCategoryFavorite(boolean favorite);
}
