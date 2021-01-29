package com.fashion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fashion.models.entity.Size;
import com.fashion.repositories.SizeRepository;

@Service
public class SizeServiceImpl implements SizeService{
	@Autowired
	private SizeRepository repository;

	@Override
	public <S extends Size> S save(S entity) {
		return repository.save(entity);
	}

	@Override
	public List<Size> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<Size> findById(Integer id) {
		return repository.findById(id);
	}

	@Override
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}
	
}
