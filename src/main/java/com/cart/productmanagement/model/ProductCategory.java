package com.cart.productmanagement.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class ProductCategory {

	@Id
	@SequenceGenerator(sequenceName = "productcategorysequence",
	allocationSize = 1,
	name = "productcategorysequence")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
	generator = "productcategorysequence")
	private Integer productCategoryId;
	private String productCategory;

	@JsonIgnore
	@OneToMany(mappedBy = "productCategory")
	private List<Product> products;

	public ProductCategory() {
		super();
	}

	public ProductCategory(Integer productCategoryId, String productCategory, List<Product> products) {
		super();
		this.productCategoryId = productCategoryId;
		this.productCategory = productCategory;
		this.products = products;
	}

	public Integer getProductCategoryId() {
		return productCategoryId;
	}

	public void setProductCategoryId(Integer productCategoryId) {
		this.productCategoryId = productCategoryId;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "ProductCategory [productCategoryId=" + productCategoryId + ", productCategory=" + productCategory
				+ ", products=" + products + "]";
	}

}
