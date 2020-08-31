package com.guri.goodsManagement.services.interfaces;

import java.util.List;

import com.guri.goodsManagement.dto.PriceReductionDto;

public interface IPriceReductionService {

	List<PriceReductionDto> readAll();

	PriceReductionDto readOne(Long id);

	PriceReductionDto create(PriceReductionDto priceReduction);

	PriceReductionDto update(Long id);

	PriceReductionDto delete(Long id);

}
