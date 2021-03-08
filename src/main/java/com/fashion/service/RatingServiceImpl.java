package com.fashion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fashion.models.dto.RatingDto;
import com.fashion.models.entity.Rating;
import com.fashion.models.mapper.RatingMapper;
import com.fashion.repositories.ProductRepository;
import com.fashion.repositories.RatingRepository;
import com.fashion.repositories.UserRepository;

@Service
public class RatingServiceImpl implements RatingService{
	@Autowired
	private RatingRepository repository;
	@Autowired
	private UserRepository userrepository;
	@Autowired
	private ProductRepository proRepository;
	
	@Override
	public Rating save(RatingDto dto) {
		Rating rating = RatingMapper.INSTANCE.toEntity(dto);
		rating.setIdpro(proRepository.findById(dto.getIdpro().getId()).get());
		rating.setIduser(userrepository.findById(dto.getIduser().getId()).get());
		return repository.save(rating);
	}

	@Override
	public List<Rating> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<Rating> findById(Integer id) {
		return repository.findById(id);
	}

	@Override
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}
	
}
