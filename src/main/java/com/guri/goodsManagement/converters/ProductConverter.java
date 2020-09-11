package com.guri.goodsManagement.converters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guri.goodsManagement.dto.ProductDto;
import com.guri.goodsManagement.entities.Product;

@Service
public class ProductConverter {
	@Autowired
	private UserConverter userConv;
	@Autowired
	private PriceReductionConverter priceRedConv;
	@Autowired
	private SupplierConverter supplierConv;

	public ProductDto convertFromEntityToDto(Product product) {
		ProductDto productDto = new ProductDto();
		productDto.setId(product.getId());
		productDto.setCode(product.getCode());
		productDto.setDescription(product.getDescription());
		productDto.setCreationDate(product.getCreationDate());
		productDto.setPrice(product.getPrice());
		productDto.setPriceReductions(priceRedConv.convertFromEntityListToDtoList(product.getPriceReductions()));
		productDto.setState(product.getState());
		productDto.setCreator(userConv.convertFromEntityToDto(product.getCreator()));
		productDto.setSuppliers(supplierConv.convertFromEntityListToDtoList(product.getSuppliers()));
		return productDto;
	}

	public Product convertFromDtoToEntity(ProductDto productDto) {
		Product product = new Product();
		product.setId(productDto.getId());
		product.setId(productDto.getId());
		product.setCode(productDto.getCode());
		product.setDescription(productDto.getDescription());
		product.setCreationDate(productDto.getCreationDate());
		product.setPrice(productDto.getPrice());
		product.setPriceReductions(priceRedConv.convertFromDtoListToEntityList(productDto.getPriceReductions()));
		product.setState(productDto.getState());
		product.setCreator(userConv.convertFromDtoToEntity(productDto.getCreator()));
		product.setSuppliers(supplierConv.convertFromDtoListToEntityList(productDto.getSuppliers()));
		return product;
	}

	public List<ProductDto> convertFromEntityListToDtoList(List<Product> productList) {
		List<ProductDto> productDtoList = new ArrayList<ProductDto>();
		for (Product product : productList) {
			productDtoList.add(convertFromEntityToDto(product));
		}
		return productDtoList;
	}

	public List<Product> convertFromDtoListToEntityList(List<ProductDto> productDtoList) {
		List<Product> productList = new ArrayList<Product>();
		for (ProductDto productDto : productDtoList) {
			productList.add(convertFromDtoToEntity(productDto));
		}
		return productList;
	}
}
