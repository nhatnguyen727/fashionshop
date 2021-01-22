package com.fashion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fashion.models.entity.Roles;
import com.fashion.repositories.RoleRepository;
@Service
public class RoleServiceImpl implements RoleService{
	@Autowired
	private RoleRepository repository;

	@Override
	public List<Roles> findAll() {
		return repository.findAll();
	}
	
}
