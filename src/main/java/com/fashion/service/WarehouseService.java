package com.fashion.service;

import java.util.List;
import java.util.Optional;

import com.fashion.models.dto.WarehouseDto;
import com.fashion.models.entity.Warehouse;

public interface WarehouseService {

	void deleteById(Integer id);

	Optional<Warehouse> findById(Integer id);

	List<Warehouse> findAll();

	Warehouse save(WarehouseDto dto);
	
}
