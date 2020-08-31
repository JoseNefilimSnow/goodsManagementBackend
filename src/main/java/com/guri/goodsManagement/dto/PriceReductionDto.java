package com.guri.goodsManagement.dto;

import java.util.Date;

import lombok.Data;

@Data
public class PriceReductionDto {
	private Long id;
	private Double reducedPrice;
	private Date startingDate;
	private Date endDate;
}
