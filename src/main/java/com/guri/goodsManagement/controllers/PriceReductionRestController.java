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

import com.guri.goodsManagement.dto.PriceReductionDto;
import com.guri.goodsManagement.services.interfaces.IPriceReductionService;

@RestController
public class PriceReductionRestController {
	@Autowired
	private IPriceReductionService priceRedService;

	@GetMapping("/priceReduction")
	public List<PriceReductionDto> readAll() {
		return priceRedService.readAll();
	}

	@GetMapping("/priceReduction/{id}")
	public PriceReductionDto readOne(@PathVariable Long id) {
		return priceRedService.readOne(id);
	}

	@PostMapping("/priceReduction")
	public PriceReductionDto create(@RequestBody PriceReductionDto priceReduction) {
		System.out.println(priceReduction.toString());
		return priceRedService.create(priceReduction);
	}
	
	@PostMapping("/checkDates")
	public Boolean checkDates(@RequestBody PriceReductionDto[] priceReductions) {
		return priceRedService.checkDates(priceReductions);
	}

	@PutMapping("/priceReduction/{id}")
	public PriceReductionDto update(@PathVariable Long id, @RequestBody PriceReductionDto priceReduction) {
		return priceRedService.update(id, priceReduction);
	}

	@DeleteMapping("/priceReduction/{id}")
	public void delete(@PathVariable Long id) {
		priceRedService.delete(id);
	}
}
