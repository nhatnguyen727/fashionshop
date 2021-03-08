package com.fashion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fashion.models.dto.OrderDto;
import com.fashion.models.entity.Order;
import com.fashion.models.mapper.OrderMapper;
import com.fashion.repositories.OrderRepository;
import com.fashion.repositories.ProductRepository;
import com.fashion.repositories.UserRepository;

@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderRepository repository;
	@Autowired
	private UserRepository userrepository;
	@Override
	public Order save(OrderDto dto) {
		Order order = OrderMapper.INSTANCE.toEntity(dto);
		order.setIduser(userrepository.findById(dto.getIduser().getId()).get());
		return repository.save(order);
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
