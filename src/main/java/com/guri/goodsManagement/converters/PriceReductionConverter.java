package com.guri.goodsManagement.converters;

import com.guri.goodsManagement.dto.PriceReductionDto;
import com.guri.goodsManagement.entities.PriceReduction;

public class PriceReductionConverter {
	public PriceReductionDto convertFromEntityToDto(PriceReduction priceRed) {
		PriceReductionDto priceRedDto = new PriceReductionDto();
		priceRedDto.setId(priceRed.getId());
		return priceRedDto;
	}
}
