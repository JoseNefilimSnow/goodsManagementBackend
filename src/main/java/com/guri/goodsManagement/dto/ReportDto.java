package com.guri.goodsManagement.dto;

import java.util.List;

import com.guri.goodsManagement.enums.EnumReportType;

import lombok.Data;

@Data
public class ReportDto {
	private Long id;
	private EnumReportType type;
	private String reason;
	private UserDto creator;
	private List<ProductDto> product;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public EnumReportType getType() {
		return type;
	}
	public void setType(EnumReportType type) {
		this.type = type;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public UserDto getCreator() {
		return creator;
	}
	public void setCreator(UserDto creator) {
		this.creator = creator;
	}
	public List<ProductDto> getProducts() {
		return product;
	}
	public void setProducts(List<ProductDto> product) {
		this.product = product;
	}
	
	
}
