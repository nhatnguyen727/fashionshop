package com.fashion.service;

import java.util.List;
import java.util.Optional;

import com.fashion.models.dto.CategoryDto;
import com.fashion.models.entity.Category;

public interface CategoryService {

	void deleteById(Integer id);

	List<Category> findAllById(Iterable<Integer> ids);

	List<Category> findAll();

	Category save(CategoryDto dto);

	Optional<Category> findById(Integer id);


}
