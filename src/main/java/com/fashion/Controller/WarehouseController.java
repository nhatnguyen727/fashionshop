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

import com.fashion.Exception.WarehouseNotFoundException;
import com.fashion.models.dto.WarehouseDto;
import com.fashion.models.entity.Warehouse;
import com.fashion.models.mapper.WarehouseMapper;
import com.fashion.service.WarehouseService;

@RestController
public class WarehouseController {
	@Autowired
	WarehouseService service;

	@GetMapping("/warehouses")
	public List<WarehouseDto> list() {
		List<Warehouse> list = service.findAll();
		if (list.isEmpty()) {
			return new ArrayList<>();
		}
		return WarehouseMapper.INSTANCE.toDtoList(list);
	}

	@PostMapping("/warehouse")
	public WarehouseDto insert(@RequestBody WarehouseDto dto) {
		Warehouse warehouse = service.save(dto);
		return WarehouseMapper.INSTANCE.toDto(warehouse);

	}

	@PutMapping("/warehouse/{id}/upd")
	public ResponseEntity<String> update(@PathVariable("id") @Min(1) Integer id, @RequestBody WarehouseDto dto) {
		Warehouse warehouse = service.findById(id).orElseThrow(() -> new WarehouseNotFoundException());
		Warehouse nwarehouse = WarehouseMapper.INSTANCE.toEntity(dto);
		nwarehouse.setId(warehouse.getId());
		service.save(WarehouseMapper.INSTANCE.toDto(nwarehouse));
		return ResponseEntity.ok().body("Warehouse with " + id + " upasted!!!");

	}

	@GetMapping("/warehouse/{id}/del")
	public ResponseEntity<String> delete(@PathVariable("id") @Min(1) Integer id) {
		Warehouse warehouse = service.findById(id).orElseThrow(() -> new WarehouseNotFoundException());
		service.deleteById(warehouse.getId());
		return ResponseEntity.ok().body("Warehouse with " + id + " deleted!!!");
	}
}