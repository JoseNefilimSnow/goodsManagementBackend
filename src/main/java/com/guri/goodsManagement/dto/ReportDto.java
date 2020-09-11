package com.guri.goodsManagement.dto;

import java.util.List;

import lombok.Data;

@Data
public class ReportDto {
	private Long id;
	private String reason;
	private UserDto creator;
	private String productCode;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	
	
	
	
}
