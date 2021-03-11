package com.fashion.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fashion.Exception.OrderNotFoundException;
import com.fashion.models.dto.OrderDto;
import com.fashion.models.entity.Order;
import com.fashion.models.mapper.OrderMapper;
import com.fashion.service.OrderService;

@RestController
public class OrderController {
	@Autowired
	private OrderService orderService;

	@CrossOrigin
	@GetMapping("/orders")
	public List<OrderDto> list() {
		List<Order> list = orderService.findAll();
		if (list.isEmpty()) {
			return new ArrayList<>();
		}
		return OrderMapper.INSTANCE.toDtoList(list);
	}

	@CrossOrigin
	@PostMapping("/order")
	public OrderDto insert(@RequestBody OrderDto dto) {
		Order order = orderService.save(dto);
		return OrderMapper.INSTANCE.toDto(order);
	}

	@CrossOrigin
	@PutMapping("/order/{id}/upd")
	public ResponseEntity<String> update(@PathVariable("id") @Min(1) Integer id, @RequestBody OrderDto dto) {
		Order order = orderService.findById(id).orElseThrow(() -> new OrderNotFoundException("No order with " + id));
		Order nOrder = OrderMapper.INSTANCE.toEntity(dto);
		nOrder.setId(order.getId());
		orderService.save(OrderMapper.INSTANCE.toDto(nOrder));
		return ResponseEntity.ok().body("Order with " + id + " updated!!!!");
	}

	@CrossOrigin
	@GetMapping("/order/{id}/del")
	public ResponseEntity<String> delete(@PathVariable("id") @Min(1) Integer id) {
		Order order = orderService.findById(id).orElseThrow(() -> new OrderNotFoundException("No order with " + id));
		orderService.deleteById(order.getId());
		return ResponseEntity.ok().body("Order with " + id + " deleted!!!!");

	}

}
