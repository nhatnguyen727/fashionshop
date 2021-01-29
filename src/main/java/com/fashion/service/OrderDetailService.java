package com.fashion.service;

import java.util.List;
import java.util.Optional;

import com.fashion.models.entity.OrderDetail;
import com.fashion.models.entity.OrderDetailIdentity;

public interface OrderDetailService {

	void deleteById(OrderDetailIdentity id);

	Optional<OrderDetail> findById(OrderDetailIdentity id);

	List<OrderDetail> findAll();

	<S extends OrderDetail> S save(S entity);

}
