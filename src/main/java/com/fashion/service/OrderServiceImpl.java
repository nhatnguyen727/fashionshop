package com.fashion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fashion.models.entity.Order;
import com.fashion.repositories.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderRepository repository;

	@Override
	public <S extends Order> S save(S entity) {
		return repository.save(entity);
	}

	@Override
	public List<Order> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<Order> findById(Integer id) {
		return repository.findById(id);
	}

	@Override
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}
	
}
