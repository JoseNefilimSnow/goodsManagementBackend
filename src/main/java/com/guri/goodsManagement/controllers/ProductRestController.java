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

import com.guri.goodsManagement.dto.ProductDto;
import com.guri.goodsManagement.services.interfaces.IProductService;

@RestController
public class ProductRestController {
	@Autowired
	private IProductService productService;
	
	@GetMapping("/product")
	public List<ProductDto> readAll(){
		return productService.readAll();
	}
	
	@GetMapping("/product/{id}")
	public ProductDto readOne(@PathVariable Long id ) {
		return productService.readOne(id);
	}
	@PostMapping("/product")
	public ProductDto create(@RequestBody ProductDto product) {
		return productService.create(product);
	}
	@PutMapping("/product/{id}")
	public ProductDto update(@PathVariable Long id ) {
		return productService.update(id);
	}
	@DeleteMapping("/product/{id}")
	public ProductDto delete(@PathVariable Long id ) {
		return productService.delete(id);
	}
}
