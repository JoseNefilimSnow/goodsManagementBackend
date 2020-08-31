package com.guri.goodsManagement.services.interfaces;

import java.util.List;

import com.guri.goodsManagement.dto.SupplierDto;

public interface ISupplierService {

	List<SupplierDto> readAll();

	SupplierDto readOne(Long id);

	SupplierDto create(SupplierDto supplier);

	SupplierDto update(Long id);

	SupplierDto delete(Long id);

}
