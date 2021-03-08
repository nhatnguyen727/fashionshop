package com.fashion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fashion.models.dto.ImageDto;
import com.fashion.models.entity.Image;
import com.fashion.models.entity.Product;
import com.fashion.models.mapper.ImageMapper;
import com.fashion.repositories.ImageRepository;
import com.fashion.repositories.ProductRepository;

@Service
public class ImageServiceImpl implements ImageService{
	@Autowired
	private ImageRepository repository;
	@Autowired
	private ProductRepository proRepository;
	
	@Override
	public Image save(ImageDto dto) {
		Image image = ImageMapper.INSTANCE.toEntity(dto);
		image.setIdpro(proRepository.findById(dto.getIdpro().getId()).get());
		return repository.save(image);
	}

	@Override
	public List<Image> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<Image> findById(Integer id) {
		return repository.findById(id);
	}
	
	
	@Override
	public List<Image> findAllById(Iterable<Integer> ids) {
		return repository.findAllById(ids);
	}

	@Override
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}

	
	
}
