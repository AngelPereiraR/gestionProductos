package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.Category;
import com.example.demo.entity.Favorite;
import com.example.demo.model.CategoryModel;
import com.example.demo.model.FavoriteProduct;

public interface FavoriteService {

	public abstract Favorite transform(FavoriteProduct favoriteModel);
	public abstract FavoriteProduct transform(Favorite favorite);
	
}
