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

import com.fashion.Exception.DiscountNotFoundException;
import com.fashion.models.dto.DiscountDto;
import com.fashion.models.entity.Discount;
import com.fashion.models.mapper.DiscountMapper;
import com.fashion.service.DiscountService;

@RestController
public class DiscountController {
	@Autowired
	DiscountService service;
	
	@GetMapping("/discounts")
	public List<DiscountDto> list(){
		List<Discount> list = service.findAll();
		if (list.isEmpty()) {
			return new ArrayList<>();
		}
		return DiscountMapper.INSTANCE.toDtoList(list);
	}
	
	@PostMapping("/discount")
	public DiscountDto insert(@RequestBody DiscountDto dto) {
		Discount discount = service.save(dto);
		return DiscountMapper.INSTANCE.toDto(discount);
	}
	
	@PutMapping("/discount/{id}/upd")
	public ResponseEntity<String> update(@PathVariable("id") @Min(1) Integer id, @RequestBody DiscountDto dto){
		Discount discount = service.findById(id).orElseThrow(() -> new DiscountNotFoundException());
		Discount ndiscount = DiscountMapper.INSTANCE.toEntity(dto);
		ndiscount.setId(discount.getId());
		service.save(DiscountMapper.INSTANCE.toDto(ndiscount));
		return ResponseEntity.ok().body("Discount with "+ id+ " updated!!");
	}
	
	@GetMapping("/discount/{id}/del")
	public ResponseEntity<String> delete(@PathVariable("id") @Min(1) Integer id){
		Discount discount = service.findById(id).orElseThrow(() -> new DiscountNotFoundException());
		service.deleteById(discount.getId());
		return ResponseEntity.ok().body("Discount with "+ id+ " deleted!!");
	}
}
