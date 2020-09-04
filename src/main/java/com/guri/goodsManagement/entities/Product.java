package com.guri.goodsManagement.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.guri.goodsManagement.enums.EnumProductState;

import lombok.Data;

@Entity
@Data
@Table(name = "Products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "productId")
	private Long id;
	@Column
	private String code;
	@Column
	private String description;
	@Column
	private Date creationDate;
	@Column
	private Double price;
	@OneToMany
	private List<PriceReduction> priceReductions;
	@Column
	private EnumProductState state;
	@ManyToOne
	private User creator;
	@ManyToMany
	private List<Supplier> suppliers;
	
	
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
	public List<PriceReduction> getPriceReductions() {
		return priceReductions;
	}
	public void setPriceReductions(List<PriceReduction> priceReductions) {
		this.priceReductions = priceReductions;
	}
	public EnumProductState getState() {
		return state;
	}
	public void setState(EnumProductState state) {
		this.state = state;
	}
	public User getCreator() {
		return creator;
	}
	public void setCreator(User creator) {
		this.creator = creator;
	}
	public List<Supplier> getSuppliers() {
		return suppliers;
	}
	public void setSuppliers(List<Supplier> suppliers) {
		this.suppliers = suppliers;
	}
	
	
}
