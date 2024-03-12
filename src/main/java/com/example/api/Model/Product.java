package com.example.api.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "produse")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long id;
	@Column(name = "numarFactura")
	public int numarFactura;
	@Column(name = "data")
	public String data;
	@Column(name = "name")
	public String name;
	@Column(name = "cantitate")
	public double cantitate;
	
	
	public Product(){
		
	}
	
	public Product(long id,  int numarFactura , String data, String name, double cantitate) {
		super();
		this.id = id;
		this.numarFactura = numarFactura;
		this.data = data;
		this.name = name;
		this.cantitate= cantitate;
		
	}
	
	public int getNumarFactura() {
		return numarFactura;
	}

	public void setNumarFactura(int numarFactura) {
		this.numarFactura = numarFactura;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getCantitate() {
		return cantitate;
	}


	public void setCantitate(double cantitate) {
		this.cantitate = cantitate;
	}


	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	
	
	
	

}
