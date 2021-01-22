package com.fashion.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fashion.models.dto.RoleDto;
import com.fashion.models.entity.Roles;
import com.fashion.models.mapper.RoleMapper;
import com.fashion.service.RoleService;

@RestController
public class RoleController {
	@Autowired
	private RoleService roleService;
	@GetMapping("/role")
	public List<RoleDto>  list() {
		List<Roles> list = roleService.findAll();
		if(list.isEmpty()) {
			return new ArrayList<>();
		}
		return RoleMapper.INSTANCE.toDtoList(list);
		
	}
}
