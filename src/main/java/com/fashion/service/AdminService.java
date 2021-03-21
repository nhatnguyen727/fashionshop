package com.fashion.service;

import java.util.List;
import java.util.Optional;

import com.fashion.models.dto.AdminDto;
import com.fashion.models.entity.Admin;

public interface AdminService {

	List<Admin> findAll();

	Admin save(AdminDto adminDto);

	void deleteById(Integer id);

	Optional<Admin> findById(Integer id);


	Object findByUsername(String username, String pass);

	
	
}
