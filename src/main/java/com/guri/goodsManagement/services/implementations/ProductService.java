package com.guri.goodsManagement.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guri.goodsManagement.converters.PriceReductionConverter;
import com.guri.goodsManagement.converters.ProductConverter;
import com.guri.goodsManagement.converters.SupplierConverter;
import com.guri.goodsManagement.dto.ProductDto;
import com.guri.goodsManagement.entities.Product;
import com.guri.goodsManagement.enums.EnumProductState;
import com.guri.goodsManagement.repositories.ProductRepository;
import com.guri.goodsManagement.repositories.UserRepository;
import com.guri.goodsManagement.services.interfaces.IProductService;

@Service
public class ProductService implements IProductService{
	@Autowired
	private ProductConverter productConv;
	@Autowired
	private ProductRepository productRep;
	@Autowired
	private UserRepository userRep;
	@Autowired
	private SupplierConverter supplierConv;
	@Autowired
	private PriceReductionConverter prConv;
	
	@Override
	public List<ProductDto> readAll() {
		return productConv.convertFromEntityListToDtoList(productRep.findAll());
	}

	@Override
	public ProductDto readOne(Long id) {
		return productConv.convertFromEntityToDto(productRep.findById(id).get());
	}

	@Override
	public ProductDto create(ProductDto product) {
		productRep.save(productConv.convertFromDtoToEntity(product));
		return product;
	}

	@Override
	public ProductDto update(Long id, ProductDto product) {
		Product oldProduct = productRep.findById(id).get();
		oldProduct.setCode(product.getCode());
		oldProduct.setCreationDate(product.getCreationDate());
		oldProduct.setCreator(userRep.findByUsername(product.getCreator().getUsername()));
		oldProduct.setDescription(product.getDescription());
		oldProduct.setPrice(product.getPrice());
		oldProduct.setState(product.getState());
		oldProduct.setPriceReductions(prConv.convertFromDtoListToEntityList(product.getPriceReductions()));
		oldProduct.setSuppliers(supplierConv.convertFromDtoListToEntityList(product.getSuppliers()));
		productRep.save(oldProduct);
		return productConv.convertFromEntityToDto(productRep.findById(id).get());
	}
	
	@Override
	public void deactivate(Long id) {
		Product product = productRep.findById(id).get();
		product.setState(EnumProductState.DISCOUNTED);
	}
	@Override
	public void delete(Long id) {
		productRep.deleteById(id);
	}


}
