package com.workspace.product.service.dao;
import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "Product_Approvals")
public class ProductApproval {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "requested_date")
    private Date requestedDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "approval_date")
    private Date approvalDate;
    
    
    @ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "ProductID")
    private Product product;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getRequestedDate() {
		return requestedDate;
	}

	public void setRequestedDate(Date requestedDate) {
		this.requestedDate = requestedDate;
	}

	public Date getApprovalDate() {
		return approvalDate;
	}

	public void setApprovalDate(Date approvalDate) {
		this.approvalDate = approvalDate;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ProductApproval(int id, Date requestedDate, Date approvalDate, Product product) {
		super();
		this.id = id;
		this.requestedDate = requestedDate;
		this.approvalDate = approvalDate;
		this.product = product;
	}

	public ProductApproval() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ProductApproval [id=" + id + ", requestedDate=" + requestedDate + ", approvalDate=" + approvalDate
				+ ", product=" + product + "]";
	}

    
}
