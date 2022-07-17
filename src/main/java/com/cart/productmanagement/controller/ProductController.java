package com.cart.productmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cart.productmanagement.model.Product;
import com.cart.productmanagement.model.ProductCategory;
import com.cart.productmanagement.model.ProductType;
import com.cart.productmanagement.service.ProductService;

@RequestMapping("/products")
@RestController
public class ProductController {

	
	@Autowired 
	private ProductService productService;
	
	@GetMapping("")
	public List<Product> fetchAllProducts() {
		 List<Product> allProducts = productService.fetchAllProducts();
		 System.out.println("All: "+allProducts.size());
		 return allProducts;
	}
	
	@PostMapping("")
	public Product saveProduct(@RequestBody Product product) {
		
		return productService.saveProduct(product);
	}
	
	@GetMapping("/{id}")
	public Product fetchProductByID(@PathVariable("id") Integer productId) {
		
		return productService.fetchProductByID(productId);
	}
	
	@GetMapping("/by-name/{name}")
	public Product fetchProductByName(@PathVariable("name") String productName) {
		
		return productService.fetchProductByName(productName);
	}
	
	@GetMapping("/by-price-range")
	public List<Product> fetchProductByPriceRange(@RequestParam("min") double min, @RequestParam("max") double max) {
		
		return productService.fetchProductByPriceRange(min, max);
	}
	
	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable("id") Integer productId,
			@RequestBody Product product) throws Exception {
		
		return productService.updateProduct(productId, product);
	}
	
	@DeleteMapping("/{id}")
	public String deleteProduct(@PathVariable("id") Integer productId) {
		
		productService.deleteProduct(productId);
		 return "Product deleted Successfully!!";
	}
	
	@PostMapping("/types")
	public ProductType saveProductType(@RequestBody ProductType productType) {
		
		return productService.saveProductType(productType);
	}
	
	@PostMapping("/categories")
	public ProductCategory saveProductCategory(@RequestBody ProductCategory productCategory) {
		
		return productService.saveProductCategory(productCategory);
	}
	
	@GetMapping("/types")
	public List<ProductType> fetchProductType() {
		
		return productService.fetchProductType();
	}
	
	@GetMapping("/categories")
	public List<ProductCategory> fetchProductCategory() {
		
		return productService.fetchProductCategory();
	}
	
	@GetMapping("/by-type/{id}")
	public List<Product> fetchProductsByTypeId(@PathVariable("id") Integer productTypeId) {
		
		return productService.fetchProductsByTypeId(productTypeId);
		
	}
	
	@GetMapping("/by-category/{id}")
	public List<Product> fetchProductCategoryById(@PathVariable("id") Integer productCategoryId) {
		
		return productService.fetchProductsByCategoryId(productCategoryId);
	}
}
