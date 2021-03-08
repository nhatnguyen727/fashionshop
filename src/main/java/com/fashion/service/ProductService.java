package com.fashion.service;

import java.util.List;
import java.util.Optional;

import com.fashion.models.dto.ProductDto;
import com.fashion.models.entity.Product;

public interface ProductService {

	void deleteById(Integer id);

	Optional<Product> findById(Integer id);

	List<Product> findAll();

	Product save(ProductDto dto);
//
//	List<Product> findByName(String name);


}
