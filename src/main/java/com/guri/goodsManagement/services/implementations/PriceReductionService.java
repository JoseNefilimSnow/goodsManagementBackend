package com.guri.goodsManagement.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guri.goodsManagement.converters.PriceReductionConverter;
import com.guri.goodsManagement.dto.PriceReductionDto;
import com.guri.goodsManagement.entities.PriceReduction;
import com.guri.goodsManagement.repositories.PriceReductionRepository;
import com.guri.goodsManagement.services.interfaces.IPriceReductionService;

@Service
public class PriceReductionService implements IPriceReductionService{
	@Autowired
	private PriceReductionRepository priceRedRep;
	@Autowired
	private PriceReductionConverter priceConv;
	@Override
	public List<PriceReductionDto> readAll() {
		return priceConv.convertFromEntityListToDtoList(priceRedRep.findAll());
	}

	@Override
	public PriceReductionDto readOne(Long id) {
		return priceConv.convertFromEntityToDto(priceRedRep.findById(id).get());
	}

	@Override
	public PriceReductionDto create(PriceReductionDto priceReduction) {
		priceRedRep.save(priceConv.convertFromDtoToEntity(priceReduction));
		return priceReduction;
	}


	@Override
	public PriceReductionDto update(Long id, PriceReductionDto priceReduction) {
		PriceReduction oldPriceRed = priceRedRep.findById(id).get();
		oldPriceRed.setEndDate(priceReduction.getEndDate());
		oldPriceRed.setReducedPrice(priceReduction.getReducedPrice());
		oldPriceRed.setStartingDate(priceReduction.getStartingDate());
		priceRedRep.save(oldPriceRed);
		return priceConv.convertFromEntityToDto(priceRedRep.findById(id).get());
	}

	@Override
	public void delete(Long id) {
		priceRedRep.deleteById(id);
	}


}
