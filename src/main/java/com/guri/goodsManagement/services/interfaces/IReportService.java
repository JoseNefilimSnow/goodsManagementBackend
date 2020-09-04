package com.guri.goodsManagement.services.interfaces;

import java.util.List;

import com.guri.goodsManagement.dto.ReportDto;

public interface IReportService {

	List<ReportDto> readAll();

	ReportDto readOne(Long id);

	ReportDto create(ReportDto report);

	ReportDto update(Long id, ReportDto report);

	void delete(Long id);

}
