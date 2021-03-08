package com.fashion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fashion.models.dto.SupplierDto;
import com.fashion.models.entity.Supplier;
import com.fashion.models.mapper.SupplierMapper;
import com.fashion.repositories.SupperlierRepository;

@Service
public class SupplierServiceImpl implements SupplierService{
	@Autowired
	private SupperlierRepository repository;
		
	@Override
	public Supplier save(SupplierDto dto) {
		Supplier supplier = SupplierMapper.INSTANCE.toEntity(dto);
		return repository.save(supplier);
	}

	@Override
	public List<Supplier> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<Supplier> findById(Integer id) {
		return repository.findById(id);
	}

	@Override
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}
	
}
