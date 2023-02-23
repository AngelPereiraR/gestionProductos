package com.example.demo.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Category;
import com.example.demo.entity.Favorite;
import com.example.demo.entity.Product;
import com.example.demo.model.CategoryModel;
import com.example.demo.model.FavoriteProduct;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.services.CategoryService;
import com.example.demo.services.FavoriteService;

@Service("favoriteService")
public class FavoriteServiceImpl implements FavoriteService {
	
	
	@Autowired
	@Qualifier("productRepository")
	private ProductRepository productRepository;


	@Override
	public Favorite transform(FavoriteProduct favorite) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(favorite, Favorite.class);
	}

	@Override
	public FavoriteProduct transform(Favorite favorite) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(favorite, FavoriteProduct.class);
	}

}
