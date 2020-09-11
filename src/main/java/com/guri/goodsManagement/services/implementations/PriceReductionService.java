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
public class PriceReductionService implements IPriceReductionService {
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
		System.out.println(priceReduction.toString());
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
	public Boolean checkDates(PriceReductionDto[] priceReductionList) {
		if (priceReductionList.length > 1) {
			int count = 0;
			for (int i = 0; i < priceReductionList.length; i++) {
				count++;
				System.out.println("Entro veces: " + count);
				if (i + 1 == priceReductionList.length) {
					break;
				} else {
					Long aux = priceReductionList[i + 1].getStartingDate().getTime()
							- priceReductionList[i].getEndDate().getTime();
					System.out.println("Numero resultante " + aux);
					if (aux < 0) {
						return false;
					}
				}
			}
			return true;
		} else {
			return true;
		}
	}

	@Override
	public void delete(Long id) {
		priceRedRep.deleteById(id);
	}

}
