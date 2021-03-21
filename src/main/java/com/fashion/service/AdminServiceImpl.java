package com.fashion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fashion.models.dto.AdminDto;
import com.fashion.models.entity.Admin;
import com.fashion.models.mapper.AdminMapper;
import com.fashion.repositories.AdminRepository;
import com.fashion.repositories.RoleRepository;
@Service
public class AdminServiceImpl implements AdminService {
	
	AdminRepository adminRepository;
	PasswordEncoder passEncoder;
	@Autowired
	public void AdminService(AdminRepository adminRepository) {
		this.adminRepository = adminRepository;
		this.passEncoder = new BCryptPasswordEncoder();
	}
	@Override
	public List<Admin> findAll() {
		return adminRepository.findAll();
	}
	
	@Override
	public Admin save(AdminDto adminDto) {
			
		Admin admin = AdminMapper.INSTANCE.toEntity(adminDto);
		admin.setName(adminDto.getName());
		admin.setPassword(passEncoder.encode(adminDto.getPassword()));
		return adminRepository.save(admin);
	}

	@Override
	public Optional<Admin> findById(Integer id) {
		return adminRepository.findById(id);
	}

	@Override
	public void deleteById(Integer id) {
		adminRepository.deleteById(id);
	}
	@Override
	public Object findByUsername(String username, String pass) {
		
		return adminRepository.findByUsername(username, pass);
	}
	
	
	
	
	
}
