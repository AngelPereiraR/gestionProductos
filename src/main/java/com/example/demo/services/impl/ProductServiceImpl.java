package com.example.demo.services.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.model.ProductModel;
import com.example.demo.repository.ProductRepository;
import com.example.demo.services.ProductService;

@Service("productService")
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	@Qualifier("productRepository")
	private ProductRepository productRepository;

	@Override
	public ProductModel addProduct(ProductModel product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductModel> listAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product findProductById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductModel findProductByIdModel(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeProduct(int id) {
		productRepository.deleteById(id);
		return false;
	}

	@Override
	public boolean removeProductsOfCategory(int categoryId) {
		productRepository.deleteAllByCategoryId(categoryId);
		return false;
	}

	@Override
	public Product transform(ProductModel productModel) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(productModel, Product.class);
	}

	@Override
	public ProductModel transform(Product category) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(category, ProductModel.class);
	}

}
