package com.guri.goodsManagement.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guri.goodsManagement.converters.ProductConverter;
import com.guri.goodsManagement.converters.ReportConverter;
import com.guri.goodsManagement.dto.ReportDto;
import com.guri.goodsManagement.entities.Report;
import com.guri.goodsManagement.repositories.ReportRepository;
import com.guri.goodsManagement.repositories.UserRepository;
import com.guri.goodsManagement.services.interfaces.IReportService;

@Service
public class ReportService implements IReportService{
	@Autowired
	private ReportConverter reportConv;
	@Autowired
	private ReportRepository reportRep;
	@Autowired
	private ProductConverter productConv;
	@Autowired
	private UserRepository userRep;
	
	@Override
	public List<ReportDto> readAll() {
		return reportConv.convertFromEntityListToDtoList(reportRep.findAll());
	}

	@Override
	public ReportDto readOne(Long id) {
		return reportConv.convertFromEntityToDto(reportRep.findById(id).get());
	}

	@Override
	public ReportDto create(ReportDto report) {
		reportRep.save(reportConv.convertFromDtoToEntity(report));
		return report;
	}


	@Override
	public ReportDto update(Long id, ReportDto report) {
		Report oldReport = reportRep.findById(id).get();
		oldReport.setProductCode(report.getProductCode());
		oldReport.setCreator(userRep.findByUsername(report.getCreator().getUsername()));
		oldReport.setReason(report.getReason());
		reportRep.save(oldReport);
		return report;
	}

	@Override
	public void delete(Long id) {
		reportRep.deleteById(id);
	}


}
