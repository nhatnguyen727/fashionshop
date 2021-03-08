package com.fashion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fashion.models.dto.CategoryDto;
import com.fashion.models.entity.Category;
import com.fashion.models.mapper.CategoryMapper;
import com.fashion.repositories.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired 
	private CategoryRepository repository;

	@Override
	public Category save(CategoryDto dto) {
		Category category = CategoryMapper.INSTANCE.toEntity(dto);
		return repository.save(category);
	}

	@Override
	public List<Category> findAll() {
		return repository.findAll();
	}

	@Override
	public List<Category> findAllById(Iterable<Integer> ids) {
		return repository.findAllById(ids);
	}

	@Override
	public Optional<Category> findById(Integer id) {
		return repository.findById(id);
	}

	@Override
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}
	
}
