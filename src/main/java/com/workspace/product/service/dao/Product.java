package com.workspace.product.service.dao;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductID")
    private int productId;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private int price;

    @Column(name = "status")
    private String status;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "insertion_date")
    private Date insertionDate;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getInsertionDate() {
		return insertionDate;
	}

	public void setInsertionDate(Date insertionDate) {
		this.insertionDate = insertionDate;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", price=" + price + ", status=" + status
				+ ", insertionDate=" + insertionDate + "]";
	}

    
}
