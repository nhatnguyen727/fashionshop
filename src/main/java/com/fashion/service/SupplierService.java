package com.fashion.service;

import java.util.List;
import java.util.Optional;

import com.fashion.models.dto.SupplierDto;
import com.fashion.models.entity.Supplier;

public interface SupplierService {

	void deleteById(Integer id);

	Optional<Supplier> findById(Integer id);

	List<Supplier> findAll();

	Supplier save(SupplierDto dto);


}
