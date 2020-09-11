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

import com.guri.goodsManagement.dto.ReportDto;
import com.guri.goodsManagement.services.interfaces.IReportService;

@RestController
public class ReportRestController {
	@Autowired
	private IReportService reportService;

	@GetMapping("/report")
	public List<ReportDto> readAll() {
		return reportService.readAll();
	}

	@GetMapping("/report/{id}")
	public ReportDto readOne(@PathVariable Long id) {
		return reportService.readOne(id);
	}

	@PostMapping("/report")
	public ReportDto create(@RequestBody ReportDto report) {
		System.out.println(report);
		return reportService.create(report);
	}

	@PutMapping("/report/{id}")
	public ReportDto update(@PathVariable Long id,@RequestBody ReportDto report) {
		return reportService.update(id,report);
	}

	@DeleteMapping("/report/{id}")
	public void delete(@PathVariable Long id) {
		reportService.delete(id);
	}
}
