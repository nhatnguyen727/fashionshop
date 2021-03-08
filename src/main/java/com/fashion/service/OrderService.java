package com.fashion.service;

import java.util.List;
import java.util.Optional;

import com.fashion.models.dto.OrderDto;
import com.fashion.models.entity.Order;

public interface OrderService {

	void deleteById(Integer id);

	Optional<Order> findById(Integer id);

	List<Order> findAll();

	Order save(OrderDto dto);


}
