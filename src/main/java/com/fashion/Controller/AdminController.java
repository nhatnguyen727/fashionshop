package com.fashion.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fashion.Exception.AdminNotFoundException;
import com.fashion.models.dto.AdminDto;
import com.fashion.models.entity.Admin;
import com.fashion.models.mapper.AdminMapper;
import com.fashion.service.AdminService;

@RestController
public class AdminController {
	@Autowired
	private AdminService adminService;

	@CrossOrigin
	@GetMapping("/admins")
	public List<AdminDto> list() {
		List<Admin> list = adminService.findAll();
		if (list.isEmpty()) {
			return new ArrayList<>();
		}
		return AdminMapper.INSTANCE.toDtoList(list);

	}

	@CrossOrigin
	@PostMapping("/admin")
	public AdminDto insert(@RequestBody AdminDto adminDto) {
		Admin admin = adminService.save(adminDto);
		return AdminMapper.INSTANCE.toDto(admin);
	}

	@CrossOrigin
	@PutMapping("/admin/{id}/upd")
	public ResponseEntity<String> update(@PathVariable("id") @Min(1) Integer id, @RequestBody AdminDto adminDto) {
		Admin admin = adminService.findById(id).orElseThrow(() -> new AdminNotFoundException());
		Admin newadmin = AdminMapper.INSTANCE.toEntity(adminDto);
		newadmin.setId(admin.getId());
		adminService.save(AdminMapper.INSTANCE.toDto(newadmin));
		return ResponseEntity.ok().body("Admin with " + id + " updated!!!");
	}

	@CrossOrigin
	@GetMapping("/admin/{id}/del")
	public ResponseEntity<String> delete(@PathVariable(name = "id") int id) {
		Admin admin = adminService.findById(id).orElseThrow(() -> new AdminNotFoundException());
		adminService.deleteById(admin.getId());
		return ResponseEntity.ok().body("Admin with " + id + " deleted!!!");

	}

}
