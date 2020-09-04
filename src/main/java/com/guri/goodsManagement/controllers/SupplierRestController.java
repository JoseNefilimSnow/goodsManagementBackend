package com.guri.goodsManagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.guri.goodsManagement.dto.SupplierDto;
import com.guri.goodsManagement.services.interfaces.ISupplierService;

@RestController
public class SupplierRestController {
	@Autowired
	private ISupplierService supplierService;

	@GetMapping("/supplier")
	public List<SupplierDto> readAll() {
		return supplierService.readAll();
	}

	@GetMapping("/supplier/{id}")
	public SupplierDto readOne(@PathVariable Long id) {
		return supplierService.readOne(id);
	}

	@PostMapping("/supplier")
	public SupplierDto create(@RequestBody SupplierDto supplier) {
		return supplierService.create(supplier);
	}

	@PutMapping("/supplier/{id}")
	public SupplierDto update(@PathVariable Long id,@RequestBody SupplierDto supplier) {
		return supplierService.update(id,supplier);
	}

	@DeleteMapping("/supplier/{id}")
	public void delete(@PathVariable Long id) {
		supplierService.delete(id);
	}
}
