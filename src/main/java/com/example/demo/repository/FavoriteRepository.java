package com.example.demo.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.demo.entity.Favorite;

@Repository("favoriteRepository")
public interface FavoriteRepository extends JpaRepository <Favorite, Serializable>{
	public abstract List<Favorite> findAllByUser(com.example.demo.entity.User user);
}
