package com.fashion.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fashion.models.dto.SizeDto;
import com.fashion.models.entity.Size;
import com.fashion.models.mapper.SizeMapper;
import com.fashion.service.SizeService;

@RestController
public class SizeControllor {
	@Autowired
	SizeService service;

	@GetMapping("/Sizes") 
	public List<SizeDto> list(){ 
		List<Size> list = service.findAll();
		if(list.isEmpty()) {
			return new ArrayList<>();
		}
		return SizeMapper.INSTANCE.toDtoList(list);
	}
	

}
