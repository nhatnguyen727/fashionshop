package com.fashion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fashion.models.entity.Rating;
import com.fashion.repositories.RatingRepository;

@Service
public class RatingServiceImpl implements RatingService{
	@Autowired
	private RatingRepository repository;

	@Override
	public <S extends Rating> S save(S entity) {
		return repository.save(entity);
	}

	@Override
	public List<Rating> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<Rating> findById(Integer id) {
		return repository.findById(id);
	}

	@Override
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}
	
}
