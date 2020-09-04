package com.guri.goodsManagement.services.interfaces;

import java.util.List;

import com.guri.goodsManagement.dto.ProductDto;

public interface IProductService {

	List<ProductDto> readAll();

	ProductDto readOne(Long id);

	ProductDto create(ProductDto product);

	ProductDto update(Long id, ProductDto product);

	void delete(Long id);

}
