package com.cart.productmanagement.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Product {

	@Id
	@SequenceGenerator(sequenceName = "productsequence",
	allocationSize = 1,
	name = "productsequence")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
	generator = "productsequence")
	private Integer productId;
	private String productName;
	
	@ManyToOne
    @JoinColumn(name = "productTypeId")
	private ProductType productType;
	
	@ManyToOne
    @JoinColumn(name="productCategoryId")
	private ProductCategory productCategory;

	private double price;

	public Product() {
		super();
	}

	public Product(Integer productId, String productName, ProductType productType, ProductCategory productCategory,
			double price) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productType = productType;
		this.productCategory = productCategory;
		this.price = price;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public ProductCategory getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

//	@Override
//	public String toString() {
//		return "Product [productId=" + productId + ", productName=" + productName + ", productType=" + productType
//				+ ", productCategory=" + productCategory + ", price=" + price + "]";
//	}

}
