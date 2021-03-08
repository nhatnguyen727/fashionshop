package com.fashion.service;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fashion.models.dto.OrderDetailDto;
import com.fashion.models.entity.OrderDetail;
import com.fashion.models.mapper.OrderDetailMapper;
import com.fashion.repositories.OrderDetailRepository;
import com.fashion.repositories.OrderRepository;
import com.fashion.repositories.ProductRepository;

@Service
public class OrderDetailServiceImpl implements OrderDetailService{
	@Autowired
	private OrderDetailRepository repository;
	@Autowired
	private ProductRepository proRepository;
	@Autowired
	private OrderRepository ordRepository;
	@Override
	public OrderDetail save(OrderDetailDto dto) {
		
		OrderDetail detail = OrderDetailMapper.INSTANCE.toEntity(dto);
		detail.setIdpro(proRepository.findById(dto.getIdpro().getId()).get());
		detail.setIdord(ordRepository.findById(dto.getIdord().getId()).get());
		
		return repository.save(detail);
	}

	@Override
	public List<OrderDetail> findAll() {
		return repository.findAll();
	}

	public Optional<OrderDetail> findById(Integer id) {
		return repository.findById(id);
	}

	public void deleteById(Integer id) {
		repository.deleteById(id);
	}
	
	

	
	
	
}
