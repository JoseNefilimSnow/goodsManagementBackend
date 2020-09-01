package com.guri.goodsManagement.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "PriceReductions")
public class PriceReduction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "priceReductionId")
	private Long id;
	@Column
	private Double reducedPrice;
	@Column
	private Date startingDate;
	@Column
	private Date endDate;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getReducedPrice() {
		return reducedPrice;
	}
	public void setReducedPrice(Double reducedPrice) {
		this.reducedPrice = reducedPrice;
	}
	public Date getStartingDate() {
		return startingDate;
	}
	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
