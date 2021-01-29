package com.fashion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fashion.models.dto.AdminDto;
import com.fashion.models.entity.Admin;
import com.fashion.models.mapper.AdminMapper;
import com.fashion.repositories.AdminRepository;
import com.fashion.repositories.RoleRepository;
@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private RoleRepository rolerepository;
	@Override
	public List<Admin> findAll() {
		return adminRepository.findAll();
	}
	
	@Override
	public Admin save(AdminDto adminDto) {
		Admin admin = AdminMapper.INSTANCE.toEntity(adminDto);
		//admin.setIdrole(rolerepository.findById(adminDto.getIdrole().getId()).get());
		admin.setIdrole(rolerepository.findById((int)adminDto.getIdrole().getId()).get());
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
	
	
	
	
}
