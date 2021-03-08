package com.fashion.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fashion.models.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
//	List<Product> findByName(String nameproduct);
//	boolean existsByUsername(String nameproduct);
}
