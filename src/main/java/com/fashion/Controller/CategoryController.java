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

import com.fashion.Exception.CategoryNotFoundException;
import com.fashion.models.dto.CategoryDto;
import com.fashion.models.entity.Category;
import com.fashion.models.mapper.CategoryMapper;
import com.fashion.service.CategoryService;

@RestController
public class CategoryController {
	@Autowired
	CategoryService service;

	@GetMapping("/categories")
	public List<CategoryDto> list() {
		List<Category> list = service.findAll();
		if (list.isEmpty()) {
			return new ArrayList<>();
		}
		return CategoryMapper.INSTANCE.toDtoList(list);
	}

	@PostMapping("/category")
	public CategoryDto insert(@RequestBody CategoryDto dto) {
		Category category = service.save(dto);
		return CategoryMapper.INSTANCE.toDto(category);
	}

	@PutMapping("/categoty/{id}/upd")
	public ResponseEntity<String> update(@PathVariable("id") @Min(1) Integer id, @RequestBody CategoryDto dto) {
		Category category = service.findById(id).orElseThrow(() -> new CategoryNotFoundException());
		Category nCategory = CategoryMapper.INSTANCE.toEntity(dto);
		nCategory.setId(category.getId());
		service.save(CategoryMapper.INSTANCE.toDto(nCategory));
		return ResponseEntity.ok().body("Category with " + id + " updated!!!");
	}

	@GetMapping("/category/{id}/del")
	public ResponseEntity<String> delete(@PathVariable("id") @Min(1) Integer id){
		Category category = service.findById(id).orElseThrow(() -> new CategoryNotFoundException());
		service.deleteById(category.getId());
		return ResponseEntity.ok().body("Category with "+ id + " deleted!!!");
	}
}
