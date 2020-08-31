package com.guri.goodsManagement.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class TicketDto {
	private Long id;
	private Date transactionDate;
	private List<ProductDto> products;
	private Double totalPrice;
}
