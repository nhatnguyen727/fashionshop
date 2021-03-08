package com.fashion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fashion.models.dto.ColorDto;
import com.fashion.models.entity.Color;
import com.fashion.models.mapper.ColorMapper;
import com.fashion.repositories.ColorRepository;
import com.fashion.repositories.ProductRepository;

@Service
public class ColorServiceImpl implements ColorService{
	@Autowired
	private ColorRepository repository;
	@Autowired
	private ProductRepository proRepository;
	
	@Override
	public Color save(ColorDto dto) {
		Color color = ColorMapper.INSTANCE.toEntity(dto);
		color.setIdpro(proRepository.findById(dto.getIdpro().getId()).get());
		return repository.save(color);
	}

	@Override
	public List<Color> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<Color> findById(Integer id) {
		return repository.findById(id);
	}

	@Override
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}
	
}
