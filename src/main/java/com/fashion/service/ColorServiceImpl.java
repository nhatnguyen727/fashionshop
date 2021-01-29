package com.fashion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fashion.models.entity.Color;
import com.fashion.repositories.ColorRepository;

@Service
public class ColorServiceImpl implements ColorService{
	@Autowired
	private ColorRepository repository;

	@Override
	public <S extends Color> S save(S entity) {
		return repository.save(entity);
	}

	@Override
	public List<Color> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<Color> findById(Integer id) {
		return repository.findById(id);
	}

	@Override
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}
	
}
