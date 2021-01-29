package com.fashion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fashion.models.dto.DiscountDto;
import com.fashion.models.entity.Discount;
import com.fashion.models.mapper.DiscountMapper;
import com.fashion.repositories.DiscountRepository;

@Service
public class DiscountServiceImpl implements DiscountService {
	@Autowired
	private DiscountRepository repository;

	@Override
	public Discount save(DiscountDto dto) {
		Discount discount = DiscountMapper.INSTANCE.toEntity(dto);
		return repository.save(discount);
	}

	@Override
	public List<Discount> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<Discount> findById(Integer id) {
		return repository.findById(id);
	}

	@Override
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}

}
