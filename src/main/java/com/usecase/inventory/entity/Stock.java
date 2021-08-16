package com.usecase.inventory.entity;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;



@Entity
public class Stock {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long stockNumber;
	
	@Size(min=2,max=32,message="Fill in the correct name")
	@NotNull(message="Mandatory field")
	@Column(unique=true)
	private String stockName;
	
	@NotNull(message="Mandatory field")
	private Double purchasingPrice;
	
	@NotNull(message="Mandatory field")
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern= "yyyy-MM-dd")
	private LocalDate purchaseDate;
	
	@NotNull(message="Mandatory field")
	private Long quantity;
	
	public Long getStockNumber() {
		return stockNumber;
	}
	public void setStockNumber(Long stockNumber) {
		this.stockNumber = stockNumber;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public Double getPurchasingPrice() {
		return purchasingPrice;
	}
	public void setPurchasingPrice(Double purchasingPrice) {
		this.purchasingPrice = purchasingPrice;
	}
	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Stock [StockNumber=" + stockNumber + ", stockName=" + stockName + ", purchasingPrice=" + purchasingPrice
				+ ", purchaseDate=" + purchaseDate + ", quantity=" + quantity + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((stockNumber == null) ? 0 : stockNumber.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stock other = (Stock) obj;
		if (stockNumber == null) {
			if (other.stockNumber != null)
				return false;
		} else if (!stockNumber.equals(other.stockNumber))
			return false;
		return true;
	}
	
	
	

}
