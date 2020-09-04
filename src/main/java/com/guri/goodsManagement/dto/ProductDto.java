package com.guri.goodsManagement.dto;

import java.util.Date;
import java.util.List;

import com.guri.goodsManagement.enums.EnumProductState;

import lombok.Data;

@Data
public class ProductDto {
	private Long id;
	private String code;
	private String description;
	private Date creationDate;
	private Double  price;
	private List<PriceReductionDto> priceReductions;
	private EnumProductState state;
	private UserDto creator;
	private List<SupplierDto> suppliers;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public List<PriceReductionDto> getPriceReductions() {
		return priceReductions;
	}
	public void setPriceReductions(List<PriceReductionDto> priceReductions) {
		this.priceReductions = priceReductions;
	}
	public EnumProductState getState() {
		return state;
	}
	public void setState(EnumProductState state) {
		this.state = state;
	}
	public UserDto getCreator() {
		return creator;
	}
	public void setCreator(UserDto creator) {
		this.creator = creator;
	}
	public List<SupplierDto> getSuppliers() {
		return suppliers;
	}
	public void setSuppliers(List<SupplierDto> suppliers) {
		this.suppliers = suppliers;
	}
	
	
	
}
