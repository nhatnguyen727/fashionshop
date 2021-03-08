package com.fashion.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fashion.Exception.SizeNotFoundException;
import com.fashion.models.dto.SizeDto;
import com.fashion.models.entity.Size;
import com.fashion.models.mapper.SizeMapper;
import com.fashion.service.SizeService;

@RestController
public class SizeControllor {
	@Autowired
	SizeService service;
	@CrossOrigin
	@GetMapping("/sizes") 
	public List<SizeDto> list(){ 
		List<Size> list = service.findAll();
		if(list.isEmpty()) {
			return new ArrayList<>();
		}
		return SizeMapper.INSTANCE.toDtoList(list);
	}
	
	@PostMapping("/admin/size")
	public SizeDto insert(@RequestBody SizeDto dto) {
		Size size = service.save(dto);
		return SizeMapper.INSTANCE.toDto(size);
	}
	
	@PutMapping("/admin/size/{id}/upd")
	public ResponseEntity<String> update(@PathVariable("id") @Min(1) Integer id, @RequestBody SizeDto dto){
		Size size = service.findById(id).orElseThrow(() -> new SizeNotFoundException("No size with "+id));
		Size nSize = SizeMapper.INSTANCE.toEntity(dto);
		nSize.setId(size.getId());
		service.save(SizeMapper.INSTANCE.toDto(nSize));
		return ResponseEntity.ok().body("Size with "+ id+ "updated!!!!");
	}
	@GetMapping("/admin/size/{id}/del")
	public ResponseEntity<String> delete(@PathVariable("id") @Min(1) Integer id){
		Size size = service.findById(id).orElseThrow(() -> new SizeNotFoundException("No size with "+id));
		service.deleteById(size.getId());
		return ResponseEntity.ok().body("Size with "+ id+ "deleted!!!!");

	}
}
