package com.fashion.service;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.Min;

import com.fashion.models.dto.OrderDetailDto;
import com.fashion.models.entity.OrderDetail;
import com.fashion.models.entity.OrderDetailIdentity;

public interface OrderDetailService {

	void deleteById(OrderDetailIdentity id);

	

	List<OrderDetail> findAll();

	OrderDetail save(OrderDetailDto dto);

	Optional<OrderDetail> findById(OrderDetailIdentity id);


}
