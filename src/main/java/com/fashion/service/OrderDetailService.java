package com.fashion.service;

import java.util.List;

import com.fashion.models.dto.OrderDetailDto;
import com.fashion.models.entity.OrderDetail;

public interface OrderDetailService {

	List<OrderDetail> findAll();

	OrderDetail save(OrderDetailDto dto);

	List<Object> listMonthlyReport();

	List<Object> listWeeklReport();



}
