package com.fashion.service;

import java.util.List;
import java.util.Optional;

import com.fashion.models.entity.Image;

public interface ImageService {

	void deleteById(Integer id);

	Optional<Image> findById(Integer id);

	List<Image> findAll();

	<S extends Image> S save(S entity);

}
