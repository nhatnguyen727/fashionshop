package com.fashion.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.fashion.service.SupplierService;

@RestController
public class SupplierController {
	@Autowired
	SupplierService service;
	
}
