package com.guri.goodsManagement.dto;

import java.util.Date;
import java.util.List;

import com.guri.goodsManagement.enums.EnumProductState;

import lombok.Data;

@Data
public class ProductDto {
	private Long id;
	private String code;
	private String description;
	private Date creationDate;
	private Double  price;
	private List<PriceReductionDto> priceReduction;
	private EnumProductState state;
	private UserDto creator;
	private List<SupplierDto> suppliers;
	
}
