package com.cart.productmanagement.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cart.productmanagement.model.Product;
import com.cart.productmanagement.model.ProductCategory;
import com.cart.productmanagement.model.ProductType;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	List<Product> findByProductCategory(ProductCategory productCategory);
	
	List<Product> findByProductType(ProductType productType);
	
	Product findByProductName(String productName);
	
	
}
