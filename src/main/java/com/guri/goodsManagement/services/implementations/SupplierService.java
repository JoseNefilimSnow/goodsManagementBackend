package com.guri.goodsManagement.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guri.goodsManagement.converters.SupplierConverter;
import com.guri.goodsManagement.dto.SupplierDto;
import com.guri.goodsManagement.entities.Supplier;
import com.guri.goodsManagement.repositories.SupplierRepository;
import com.guri.goodsManagement.services.interfaces.ISupplierService;

@Service
public class SupplierService implements ISupplierService {
	@Autowired
	private SupplierConverter supplierConv;
	@Autowired
	private SupplierRepository supplierRep;

	@Override
	public List<SupplierDto> readAll() {
		return supplierConv.convertFromEntityListToDtoList(supplierRep.findAll());
	}

	@Override
	public SupplierDto readOne(Long id) {
		return supplierConv.convertFromEntityToDto(supplierRep.findById(id).get());
	}

	@Override
	public SupplierDto create(SupplierDto supplier) {
		supplierRep.save(supplierConv.convertFromDtoToEntity(supplier));
		return supplier;
	}

	@Override
	public SupplierDto update(Long id, SupplierDto supplier) {
		Supplier oldSupplier = supplierRep.findById(id).get();
		oldSupplier.setName(supplier.getName());
		oldSupplier.setCountry(supplier.getCountry());
		supplierRep.save(oldSupplier);
		return supplierConv.convertFromEntityToDto(supplierRep.findById(id).get());
	}

	@Override
	public void delete(Long id) {
		supplierRep.deleteById(id);
	}

}
