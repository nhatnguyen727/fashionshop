package com.fashion.service;

import java.util.List;
import java.util.Optional;

import com.fashion.models.dto.RoleDto;
import com.fashion.models.entity.Role;

public interface RoleService {

	List<Role> findAll();

	
	Role save(RoleDto dto);

	void deleteById(Integer id);

	Optional<Role> findById(Integer id);


	

	
	
}
