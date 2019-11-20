package com.example.productsapp;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="SubProduct")
public class SubProducts {
	
	@Id
	@GeneratedValue
	private int id;	
	

    @ManyToOne
    @JoinColumn(name = "products_name", nullable = false)
    @JsonIgnore
	private Products productName;
	
	@Column
	private String subName;
	
	private String mainProductName;

	public String getMainProductName() {
		return mainProductName;
	}

	public void setMainProductName(String mainProductName) {
		this.mainProductName = mainProductName;
	}

	@Column
	private double subCost;
	
	@Column
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate subFromDate;

	@Column
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate subThruDate;

	public SubProducts() {
		//default constructor
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Products getProductName() {
		return productName;
	}

	public void setProductName(Products productName) {
		this.productName = productName;
	}

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

	public double getSubCost() {
		return subCost;
	}

	public void setSubCost(double subCost) {
		this.subCost = subCost;
	}

	public LocalDate getSubFromDate() {
		return subFromDate;
	}

	public void setSubFromDate(LocalDate subFromDate) {
		this.subFromDate = subFromDate;
	}

	public LocalDate getSubThruDate() {
		return subThruDate;
	}

	public void setSubThruDate(LocalDate subThruDate) {
		this.subThruDate = subThruDate;
	}
	
}
