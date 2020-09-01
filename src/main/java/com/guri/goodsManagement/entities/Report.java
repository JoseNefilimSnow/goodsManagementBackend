package com.guri.goodsManagement.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.guri.goodsManagement.enums.EnumReportType;

import lombok.Data;

@Entity
@Data
@Table(name = "Reports")
public class Report {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "reportId")
	private Long id;
	@Column
	private EnumReportType type;
	@Column
	private String reason;
	@ManyToOne
	private User creator;
	@OneToMany
	private List<Product> products;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public EnumReportType getType() {
		return type;
	}
	public void setType(EnumReportType type) {
		this.type = type;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public User getCreator() {
		return creator;
	}
	public void setCreator(User creator) {
		this.creator = creator;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
}
