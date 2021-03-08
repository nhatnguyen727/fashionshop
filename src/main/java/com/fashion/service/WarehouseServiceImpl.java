package com.fashion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fashion.models.dto.WarehouseDto;
import com.fashion.models.entity.Warehouse;
import com.fashion.models.mapper.WarehouseMapper;
import com.fashion.repositories.WarehouseRepository;

@Service
public class WarehouseServiceImpl implements WarehouseService{
	@Autowired
	private WarehouseRepository repository;

	@Override
	public Warehouse save(WarehouseDto dto) {
		Warehouse warehouse= WarehouseMapper.INSTANCE.toEntity(dto);
		return repository.save(warehouse);
	}
	@Override
	public List<Warehouse> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<Warehouse> findById(Integer id) {
		return repository.findById(id);
	}

	@Override
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}
	
}
