package com.fashion.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fashion.models.dto.AdminDto;
import com.fashion.models.entity.Admin;
import com.fashion.models.mapper.AdminMapper;
import com.fashion.service.AdminService;

@RestController
public class AdminController {
	@Autowired
	private AdminService adminService;

	@GetMapping("/admin")
	public List<AdminDto> list() {
		List<Admin> list = adminService.findAll();
		if (list.isEmpty()) {
			return new ArrayList<>();
		}
		return AdminMapper.INSTANCE.toDtoList(list);

	}
	
	@GetMapping("/")
	public String Home() {
		return "Hello";
	}
	
}
