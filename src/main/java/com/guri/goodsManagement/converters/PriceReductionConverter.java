package com.guri.goodsManagement.converters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.guri.goodsManagement.dto.PriceReductionDto;
import com.guri.goodsManagement.entities.PriceReduction;

@Service
public class PriceReductionConverter {

	public PriceReductionDto convertFromEntityToDto(PriceReduction priceRed) {
		PriceReductionDto priceRedDto = new PriceReductionDto();
		priceRedDto.setId(priceRed.getId());
		priceRedDto.setReducedPrice(priceRed.getReducedPrice());
		priceRedDto.setStartingDate(priceRed.getStartingDate());
		priceRedDto.setEndDate(priceRed.getEndDate());
		return priceRedDto;
	}

	public PriceReduction convertFromDtoToEntity(PriceReductionDto priceRedDto) {
		PriceReduction priceRed = new PriceReduction();
		priceRed.setId(priceRedDto.getId());
		priceRed.setReducedPrice(priceRedDto.getReducedPrice());
		priceRed.setStartingDate(priceRedDto.getStartingDate());
		priceRed.setEndDate(priceRedDto.getEndDate());
		return priceRed;
	}

	public List<PriceReductionDto> convertFromEntityListToDtoList(List<PriceReduction> priceRedList) {
		List<PriceReductionDto> priceRedDtoList = new ArrayList<PriceReductionDto>();
		for (PriceReduction priceRed : priceRedList) {
			priceRedDtoList.add(convertFromEntityToDto(priceRed));
		}
		return priceRedDtoList;
	}

	public List<PriceReduction> convertFromDtoListToEntityList(List<PriceReductionDto> priceRedDtoList) {
		List<PriceReduction> priceRedList = new ArrayList<PriceReduction>();
		for (PriceReductionDto priceRedDto : priceRedDtoList) {
			priceRedList.add(convertFromDtoToEntity(priceRedDto));
		}
		return priceRedList;
	}
}
