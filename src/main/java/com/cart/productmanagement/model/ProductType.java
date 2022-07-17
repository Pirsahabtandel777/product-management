package com.cart.productmanagement.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class ProductType {

	@Id
	@SequenceGenerator(sequenceName = "producttypesequence",
	allocationSize = 1,
	name = "producttypesequence")
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "producttypesequence")
	private Integer productTypeId;
	private String productType;

	@JsonIgnore
	@OneToMany(mappedBy = "productType")
	private List<Product> products;

	public ProductType() {
		super();
	}

	public ProductType(Integer productTypeId, String productType, List<Product> products) {
		super();
		this.productTypeId = productTypeId;
		this.productType = productType;
		this.products = products;
	}

	public Integer getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(Integer productTypeId) {
		this.productTypeId = productTypeId;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "ProductType [productTypeId=" + productTypeId + ", productType=" + productType + ", products=" + products
				+ "]";
	}

}
