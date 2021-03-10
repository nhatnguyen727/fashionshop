package com.fashion.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.fashion.Exception.ProductNotFoundException;
import com.fashion.models.dto.ProductDto;
import com.fashion.models.entity.Image;
import com.fashion.models.entity.Product;
import com.fashion.models.mapper.ProductMapper;
import com.fashion.service.ImageService;
import com.fashion.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	ProductService service;
	
	@Autowired
	ImageService imgservice;
	@CrossOrigin
	@GetMapping("/products")
	public List<ProductDto> list(){
		List<Product> listProducts = service.findAll();
		List<Image> listImages = imgservice.findAll();
		
		listImages.stream().map(Image::getId).forEach(n->{
			listProducts.forEach(p->{
				if(n==p.getId()) {
					
					
					
				}
			});
			});
	//		forEach(image->
	//				  {
	//					  listProducts.forEach(product->{
	//						  product.getId()==image.g
	//					  });
	//				  });
			
		
		if(listProducts.isEmpty()) {
			return new ArrayList<>();
		}
		return ProductMapper.INSTANCE.toDtoList(listProducts);
	}
	@PostMapping("/admin/product")
	public ProductDto insert(@RequestBody ProductDto dto) {
		Product product = service.save(dto);
		return ProductMapper.INSTANCE.toDto(product);
	}
	
	@PutMapping("/admin/product/{id}/upd")
	public ResponseEntity<String> update(@PathVariable("id") @Min(1) Integer id, @RequestBody ProductDto dto){
		Product product = service.findById(id).orElseThrow(()-> new ProductNotFoundException("No Product with "+id));
		Product nProduct = ProductMapper.INSTANCE.toEntity(dto);
		nProduct.setId(product.getId());
		service.save(ProductMapper.INSTANCE.toDto(nProduct));
		return ResponseEntity.ok().body("Product with " + id+ " updated!!!");
	
	}
	
	@GetMapping("/admin/product/{id}/del")
	public ResponseEntity<String> delete(@PathVariable("id") @Min(1) Integer id){
		Product pro = service.findById(id).orElseThrow(()-> new ProductNotFoundException("No Product with "+id));
		service.deleteById(id);
		return ResponseEntity.ok().body("Product with " + id+ " deleted!!!");
	}
	
}
