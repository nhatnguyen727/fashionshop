package com.fashion.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fashion.Exception.RoleNotFoundException;
import com.fashion.models.dto.RoleDto;
import com.fashion.models.entity.Role;
import com.fashion.models.mapper.RoleMapper;
import com.fashion.service.RoleService;

@RestController
public class RoleController {
	@Autowired
	RoleService roleService;

	@CrossOrigin
	@GetMapping("/admin/roles")
	public List<RoleDto> list() {
		List<Role> list = roleService.findAll();
		if (list.isEmpty()) {
			return new ArrayList<>();
		}
		return RoleMapper.INSTANCE.toDtoList(list);

	}

	@CrossOrigin
	@PostMapping("/admin/role")
	public RoleDto insert(@RequestBody RoleDto roleDto) {
		Role role = roleService.save(roleDto);
		return RoleMapper.INSTANCE.toDto(role);

	}

	@CrossOrigin
	@PutMapping("/admin/role/{id}/upd")
	public ResponseEntity<String> update(@PathVariable("id") @Min(1) int id, @RequestBody RoleDto roleDto) {
		Role role = roleService.findById(id).orElseThrow(() -> new RoleNotFoundException("No Role with " + id));

		Role newroles = RoleMapper.INSTANCE.toEntity(roleDto);
		newroles.setId(role.getId());

		roleService.save(RoleMapper.INSTANCE.toDto(newroles));
		return ResponseEntity.ok().body("Role with " + id + " updated!!!!!");
	}

	@CrossOrigin
	@DeleteMapping("/admin/role/{id}/del")
	public ResponseEntity<String> delete(@PathVariable(name = "id") @Min(1) Integer id) {
		Role role = roleService.findById(id).orElseThrow(() -> new RoleNotFoundException("No Role with " + id));
		roleService.deleteById(role.getId());
		return ResponseEntity.ok().body("Role with " + id + " deleted!!!!!");
	}

}
