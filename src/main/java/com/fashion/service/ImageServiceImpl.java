package com.fashion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fashion.models.entity.Image;
import com.fashion.repositories.ImageRepository;

@Service
public class ImageServiceImpl implements ImageService{
	@Autowired
	private ImageRepository repository;

	@Override
	public <S extends Image> S save(S entity) {
		return repository.save(entity);
	}

	@Override
	public List<Image> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<Image> findById(Integer id) {
		return repository.findById(id);
	}

	@Override
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}
	
}
