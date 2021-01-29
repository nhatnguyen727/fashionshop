package com.fashion.service;

import java.util.List;
import java.util.Optional;

import com.fashion.models.entity.Size;

public interface SizeService {

	void deleteById(Integer id);

	Optional<Size> findById(Integer id);

	List<Size> findAll();

	<S extends Size> S save(S entity);

}
