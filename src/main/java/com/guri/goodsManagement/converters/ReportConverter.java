package com.guri.goodsManagement.converters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guri.goodsManagement.dto.ReportDto;
import com.guri.goodsManagement.entities.Report;

@Service
public class ReportConverter {

	@Autowired
	private ProductConverter productConv;
	@Autowired
	private UserConverter userConv;

	public ReportDto convertFromEntityToDto(Report report) {
		ReportDto reportDto = new ReportDto();
		reportDto.setId(report.getId());
		reportDto.setCreator(userConv.convertFromEntityToDto(report.getCreator()));
		reportDto.setReason(report.getReason());
		reportDto.setProductCode(report.getProductCode());
		return reportDto;
	}

	public Report convertFromDtoToEntity(ReportDto reportDto) {
		Report report = new Report();
		report.setId(reportDto.getId());
		report.setCreator(userConv.convertFromDtoToEntity(reportDto.getCreator()));
		report.setReason(reportDto.getReason());
		report.setProductCode(reportDto.getProductCode());
		return report;
	}

	public List<ReportDto> convertFromEntityListToDtoList(List<Report> reportList) {
		List<ReportDto> reportDtoList = new ArrayList<ReportDto>();
		for (Report report : reportList) {
			reportDtoList.add(convertFromEntityToDto(report));
		}
		return reportDtoList;
	}

	public List<Report> convertFromDtoListToEntityList(List<ReportDto> reportDtoList) {
		List<Report> reportList = new ArrayList<Report>();
		for (ReportDto reportDto : reportDtoList) {
			reportList.add(convertFromDtoToEntity(reportDto));
		}
		return reportList;
	}

}
