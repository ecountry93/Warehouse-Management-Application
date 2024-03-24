package com.example.api.Model;


import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long id;
	
	
	@NotNull(message= "this field cannot be null")
	@Min(1)
	@Column(name = "billNumber")
	public Integer billNumber;
	
	@NotNull(message= "this field cannot be null")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "date")
	public Date date;
	

	@NotNull (message= "this field cannot be null")
	@Size(min=2, max=50)
	@Column(name = "name")
	public String name;
	
	
	@NotNull(message= "this field cannot be null")
	@Min(1)
	@Column(name = "quantity")
	public Double quantity;
	
	
	public Product(){
	}

	public Product(long id,  Integer billNumber , Date date, String name, Double quantity) {
		this.id = id;
		this.billNumber = billNumber;
		this.date = date;
		this.name = name;
		this.quantity= quantity;
	}
	
	public Integer getBillNumber() {
		return billNumber;
	}

	public void setBillNumber(Integer billNumber) {
		this.billNumber = billNumber;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Double getQuantity() {
		return quantity;
	}


	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	
	
	
	

}
