package com.fashion.service;

import java.util.List;
import java.util.Optional;

import com.fashion.models.entity.Color;

public interface ColorService {

	void deleteById(Integer id);

	Optional<Color> findById(Integer id);

	List<Color> findAll();

	<S extends Color> S save(S entity);

}
