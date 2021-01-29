package com.fashion.service;

import java.util.List;
import java.util.Optional;

import com.fashion.models.dto.DiscountDto;
import com.fashion.models.entity.Discount;

public interface DiscountService {

	void deleteById(Integer id);

	Optional<Discount> findById(Integer id);

	List<Discount> findAll();

	Discount save(DiscountDto dto);


}
