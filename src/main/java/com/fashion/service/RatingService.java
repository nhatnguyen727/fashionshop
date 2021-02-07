package com.fashion.service;

import java.util.List;
import java.util.Optional;

import com.fashion.models.dto.RatingDto;
import com.fashion.models.entity.Rating;

public interface RatingService {

	void deleteById(Integer id);

	Optional<Rating> findById(Integer id);

	List<Rating> findAll();

	Rating save(RatingDto dto);


}
