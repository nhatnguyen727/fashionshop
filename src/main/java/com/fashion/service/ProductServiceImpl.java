package com.fashion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fashion.models.dto.ProductDto;
import com.fashion.models.entity.Category;
import com.fashion.models.entity.Product;
import com.fashion.models.mapper.ProductMapper;
import com.fashion.repositories.CategoryRepository;
import com.fashion.repositories.DiscountRepository;
import com.fashion.repositories.ProductRepository;
import com.fashion.repositories.SupperlierRepository;
import com.fashion.repositories.WarehouseRepository;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductRepository repository;
	@Autowired
	private CategoryRepository cateRepository;
	@Autowired
	private DiscountRepository disRepository;
	@Autowired
	private SupperlierRepository supRepository;
	@Autowired 
	private WarehouseRepository wareRepository;
	
	@Override
	public Product save(ProductDto dto) {
		Product product = ProductMapper.INSTANCE.toEntity(dto);
		product.setIdcate(cateRepository.findById(dto.getIdcate().getId()).get());
		product.setIddis(disRepository.findById(dto.getIddis().getId()).get());
		product.setIdsup(supRepository.findById(dto.getIdsup().getId()).get());
		product.setIdware(wareRepository.findById(dto.getIdware().getId()).get());
		return repository.save(product);
	}

	@Override
	public List<Product> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<Product> findById(Integer id) {
		return repository.findById(id);
	}

	@Override
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}
	
}
