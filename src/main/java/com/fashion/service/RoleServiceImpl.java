package com.fashion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fashion.models.dto.RoleDto;
import com.fashion.models.entity.Role;
import com.fashion.models.mapper.RoleMapper;
import com.fashion.repositories.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleRepository repository;

	@Override
	public List<Role> findAll() {
		return repository.findAll();
	}

	@Override
	public Role save(RoleDto dto) {
		Role role = RoleMapper.INSTANCE.toEntity(dto);
		return repository.save(role);
	}

	@Override
	public Optional<Role> findById(Integer id) {
		return repository.findById(id);
	}

	@Override
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}
	

}
