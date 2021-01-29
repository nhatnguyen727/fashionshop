package com.fashion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fashion.models.entity.OrderDetail;
import com.fashion.models.entity.OrderDetailIdentity;
import com.fashion.repositories.OrderDetailRepository;

@Service
public class OrderDetailServiceImpl implements OrderDetailService{
	@Autowired
	private OrderDetailRepository repository;

	@Override
	public <S extends OrderDetail> S save(S entity) {
		return repository.save(entity);
	}

	@Override
	public List<OrderDetail> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<OrderDetail> findById(OrderDetailIdentity id) {
		return repository.findById(id);
	}

	@Override
	public void deleteById(OrderDetailIdentity id) {
		repository.deleteById(id);
	}
	
}
