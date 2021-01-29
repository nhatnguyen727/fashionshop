package com.fashion.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fashion.Exception.SupplierNotFoundException;
import com.fashion.models.dto.SupplierDto;
import com.fashion.models.entity.Supplier;
import com.fashion.models.mapper.SupplierMapper;
import com.fashion.service.SupplierService;

@RestController
public class SupplierController {
	@Autowired
	SupplierService service;
	
	@GetMapping("suppliers")
	public List<SupplierDto> list(){
		List<Supplier> list = service.findAll();
		if(list.isEmpty()) {
			return new ArrayList<>();
		}
		return SupplierMapper.INSTANCE.toDtoList(list);
	}
	
	@PostMapping("/supplier")
	public SupplierDto insert(@RequestBody SupplierDto dto) {
		Supplier supplier = service.save(dto);
		return SupplierMapper.INSTANCE.toDto(supplier);
	}
	
	@PutMapping("/supplier/{id}/upd")
	public ResponseEntity<String> update(@PathVariable("id") @Min(1) Integer id, @RequestBody SupplierDto dto){
		Supplier supplier = service.findById(id).orElseThrow(() -> new SupplierNotFoundException("No supplier with " + id ));
		Supplier nSupplier = SupplierMapper.INSTANCE.toEntity(dto);
		nSupplier.setId(dto.getId());
		service.save(SupplierMapper.INSTANCE.toDto(nSupplier));
		return ResponseEntity.ok().body("Supplier with "+ id+ " updated");
	}
	
	@GetMapping("/supplier/{id}/del")
	public ResponseEntity<String> delete(@PathVariable("id") @Min(1) Integer id){
		Supplier supplier = service.findById(id).orElseThrow(() -> new SupplierNotFoundException("No supplier with " + id ));
		service.deleteById(id);
		return ResponseEntity.ok().body("Supplier with "+ id+ " deleted");
	}
}
