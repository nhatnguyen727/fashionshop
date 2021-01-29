package com.fashion.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fashion.models.dto.ImageDto;
import com.fashion.models.entity.Image;
import com.fashion.models.mapper.ImageMapper;
import com.fashion.service.ImageService;

@RestController
public class ImageController {
	@Autowired
	ImageService service;
	
	@GetMapping("/images")
	public List<ImageDto> list(){
		List<Image> list = service.findAll();
		if(list.isEmpty()) {
			return new ArrayList<>();
		}
		return ImageMapper.INSTANCE.toDtoList(list);
	}
	@PostMapping("/image")
	public ImageDto insert(@RequestBody ImageDto dto) {
		Image image = service.save(dto);
		return ImageMapper.INSTANCE.toDto(image);
	}
}
