package com.fashion.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fashion.service.AdminService;
import com.fashion.service.UserService;

@RestController
public class Login {
	@Autowired
	AdminService adminService;
	@Autowired
	UserService userService;
//	@Autowired
//	PasswordEncoder encoder;

	@CrossOrigin
	@GetMapping("/admin-login/{username}/{pass}")
	public Object login(@PathVariable("username") String username, @PathVariable("pass") String pass) {
		Object aObject = adminService.findByUsername(username, pass);
		Object bObject = userService.findByUser(username,pass);
		if (aObject == null) {
			
			return bObject;
		}

		return aObject;
	}

}
