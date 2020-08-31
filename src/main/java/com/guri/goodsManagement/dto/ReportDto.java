package com.guri.goodsManagement.dto;

import com.guri.goodsManagement.enums.EnumReportType;

import lombok.Data;

@Data
public class ReportDto {
	private Long id;
	private EnumReportType type;
	private String reason;
}
