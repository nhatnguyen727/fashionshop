package com.fashion.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fashion.Exception.OrderNotFoundException;
import com.fashion.models.dto.OrderDetailDto;
import com.fashion.models.entity.Image;
import com.fashion.models.entity.OrderDetail;
import com.fashion.models.entity.OrderDetailIdentity;
import com.fashion.models.entity.Product;
import com.fashion.models.mapper.OrderDetailMapper;
import com.fashion.service.OrderDetailService;
import com.fashion.service.ProductService;

@RestController
public class OrderDetailController {
	@Autowired
	private OrderDetailService service;
	@Autowired
	private ProductService proservice;
	@GetMapping("/orderdetails")
	public List<OrderDetailDto> list(){
		List<OrderDetail> list= service.findAll();
		List<Product> listProducts = proservice.findAll();
		
		listProducts.stream().map(Product::getId).forEach(n->System.out.println(n.toString()));
		listProducts.stream().map(Product::getId).forEach(n->{
			list.forEach(p->{
				if(n==p.getId()) {
					System.out.println("Product id"+n+ "OrderDetail name :" + p.getId());
										
				}
			});
			});
		
		if (list.isEmpty()) {
			return new ArrayList<>();
		}
		return OrderDetailMapper.INSTANCE.toDtoList(list);
	}
	
	@PostMapping("/orderdetail")
	public OrderDetailDto insert(@RequestBody OrderDetailDto dto) {
		OrderDetail detail = service.save(dto);
		return OrderDetailMapper.INSTANCE.toDto(detail);
	}
//	@PutMapping("/orderdetail/{id}/upd")
//	public ResponseEntity<String> update(@PathVariable("id") @Min(1) OrderDetailIdentity id,@RequestBody OrderDetailDto dto){
//		OrderDetailIdentity detail = service.findById(id).orElseThrow(()-> new OrderNotFoundException(""));
//		OrderDetail nDetail = OrderDetailMapper.INSTANCE.toEntity(dto);
//		
//		return null;
//		
//	}
	
}
