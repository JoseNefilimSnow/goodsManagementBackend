package com.guri.goodsManagement.converters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.guri.goodsManagement.dto.SupplierDto;

import com.guri.goodsManagement.entities.Supplier;

@Service
public class SupplierConverter {

	public SupplierDto convertFromEntityToDto(Supplier supplier) {
		SupplierDto supplierDto = new SupplierDto();
		supplierDto.setId(supplier.getId());
		supplierDto.setName(supplier.getName());
		supplierDto.setCountry(supplier.getCountry());
		return supplierDto;
	}

	public Supplier convertFromDtoToEntity(SupplierDto supplierDto) {
		Supplier supplier = new Supplier();
		supplier.setId(supplierDto.getId());
		supplier.setName(supplierDto.getName());
		supplier.setCountry(supplierDto.getCountry());
		return supplier;
	}

	public List<SupplierDto> convertFromEntityListToDtoList(List<Supplier> suppliers) {
		List<SupplierDto> supplierDtoList = new ArrayList<SupplierDto>();
		for (Supplier supplier : suppliers) {
			supplierDtoList.add(convertFromEntityToDto(supplier));
		}
		return supplierDtoList;
	}

	public List<Supplier> convertFromDtoListToEntityList(List<SupplierDto> suppliers) {
		List<Supplier> supplierList = new ArrayList<Supplier>();
		for (SupplierDto supplier : suppliers) {
			supplierList.add(convertFromDtoToEntity(supplier));
		}
		return supplierList;
	}

}
