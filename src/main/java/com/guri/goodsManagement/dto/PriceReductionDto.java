package com.guri.goodsManagement.dto;

import java.util.Date;

import lombok.Data;

@Data
public class PriceReductionDto {
	private Long id;
	private Double reducedPrice;
	private Date startingDate;
	private Date endDate;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getReducedPrice() {
		return reducedPrice;
	}
	public void setReducedPrice(Double reducedPrice) {
		this.reducedPrice = reducedPrice;
	}
	public Date getStartingDate() {
		return startingDate;
	}
	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "PriceReductionDto [id=" + id + ", reducedPrice=" + reducedPrice + ", startingDate=" + startingDate
				+ ", endDate=" + endDate + "]";
	}
	
}
