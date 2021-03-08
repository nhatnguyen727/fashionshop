package com.fashion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fashion.models.dto.SizeDto;
import com.fashion.models.entity.Size;
import com.fashion.models.mapper.SizeMapper;
import com.fashion.repositories.ProductRepository;
import com.fashion.repositories.SizeRepository;

@Service
public class SizeServiceImpl implements SizeService{
	@Autowired
	private SizeRepository repository;
	@Autowired
	private ProductRepository proRepository;
	@Override
	public Size save(SizeDto dto) {
		Size size = SizeMapper.INSTANCE.toEntity(dto);
		size.setIdpro(proRepository.findById(dto.getIdpro().getId()).get());
		return repository.save(size);
	}

	@Override
	public List<Size> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<Size> findById(Integer id) {
		return repository.findById(id);
	}

	@Override
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}
	
}
