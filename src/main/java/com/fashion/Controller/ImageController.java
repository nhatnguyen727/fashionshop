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

import com.fashion.Exception.ImageNotFoundException;
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
	
	@PutMapping("/image/{id}/upd")
	public ResponseEntity<String> update(@PathVariable("id") @Min(1) Integer id, @RequestBody ImageDto dto){
		Image image = service.findById(id).orElseThrow(() -> new ImageNotFoundException("No image with "+ id));
		Image nImage = ImageMapper.INSTANCE.toEntity(dto);
		nImage.setId(image.getId());
		service.save(ImageMapper.INSTANCE.toDto(nImage));
		return ResponseEntity.ok().body("Image with "+ id + " updated!!!!!!");
	}
	
	@GetMapping("/image/{id}/del")
	public ResponseEntity<String> delete(@PathVariable("id") @Min(1) Integer id){
		Image image = service.findById(id).orElseThrow(() -> new ImageNotFoundException("No image with "+ id));
		service.deleteById(image.getId());
		return ResponseEntity.ok().body("Image with "+ id + " delete!!!!!!");

	}
	
}
