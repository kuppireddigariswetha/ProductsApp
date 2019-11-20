package com.example.ProductsApp;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

@Entity
@Table(name="product")
public class Products {

	@Id
	@GeneratedValue
	private int id;
	
	@NotNull
	@Column
	private String name;
	
	@Column
	private double cost;
	
	@Column
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate fromDate;
	
	@Column
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate thruDate;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public LocalDate getFromDate() {
		return fromDate;
	}

	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}

	public LocalDate getThruDate() {
		return thruDate;
	}

	public void setThruDate(LocalDate thruDate) {
		this.thruDate = thruDate;
	}

	public Products(){
		
	}
	
}
