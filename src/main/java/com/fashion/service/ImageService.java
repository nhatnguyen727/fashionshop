package com.fashion.service;

import java.util.List;
import java.util.Optional;

import com.fashion.models.dto.ImageDto;
import com.fashion.models.entity.Image;
import com.fashion.models.entity.Product;

public interface ImageService {

	void deleteById(Integer id);

	Optional<Image> findById(Integer id);

	List<Image> findAll();

	Image save(ImageDto dto);

	List<Image> findAllById(Iterable<Integer> ids);





}
