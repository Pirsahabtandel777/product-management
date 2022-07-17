package com.cart.productmanagement.service;

import java.util.List;
import java.util.Optional;import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cart.productmanagement.model.Product;
import com.cart.productmanagement.model.ProductCategory;
import com.cart.productmanagement.model.ProductType;
import com.cart.productmanagement.repo.ProductCategoryRepository;
import com.cart.productmanagement.repo.ProductRepository;
import com.cart.productmanagement.repo.ProductTypeRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductCategoryRepository productCategoryRepository;

	@Autowired
	private ProductTypeRepository productTypeRepository;

	public List<Product> fetchAllProducts() {
		return productRepository.findAll();
	}

	public Product saveProduct(Product product) {

		return productRepository.save(product);
	}

	public Product fetchProductByID(Integer productId) {

		Optional<Product> findById = productRepository.findById(productId);

		if (findById.isPresent()) {
			return findById.get();
		}

		return null;
	}

	public Product updateProduct(Integer productId, Product product) throws Exception {
		Optional<Product> findById = productRepository.findById(productId);

		if (findById.isEmpty()) {
			throw new Exception("Product does not exist");
		}

		product.setProductId(productId);

		return productRepository.save(product);
	}

	public void deleteProduct(Integer productId) {

		Product product = new Product();
		product.setProductId(productId);
		productRepository.delete(product);
	}

	public List<Product> fetchProductsByCategory(Integer categoryId) {
		Optional<ProductCategory> findById = productCategoryRepository.findById(categoryId);

		if (findById.isPresent()) {
			return findById.get().getProducts();
		}

		return null;

	}

	public List<Product> fetchProductsByType(Integer typeId) {
		Optional<ProductType> findById = productTypeRepository.findById(typeId);

		if (findById.isPresent()) {
			return findById.get().getProducts();
		}

		return null;

	}

	public ProductType saveProductType(ProductType productType) {

		return productTypeRepository.save(productType);
	}

	public ProductCategory saveProductCategory(ProductCategory productCategory) {

		return productCategoryRepository.save(productCategory);
	}

	public List<ProductType> fetchProductType() {

		return productTypeRepository.findAll();
	}

	public List<ProductCategory> fetchProductCategory() {

		return productCategoryRepository.findAll();
	}

	public List<Product> fetchProductsByTypeId(Integer productTypeId) {

		ProductType productType = new ProductType();
		productType.setProductTypeId(productTypeId);
		return productRepository.findByProductType(productType);
	}

	public List<Product> fetchProductsByCategoryId(Integer productCategoryId) {

		ProductCategory productCategory = new ProductCategory();
		productCategory.setProductCategoryId(productCategoryId);

		return productRepository.findByProductCategory(productCategory);
	}

	public Product fetchProductByName(String productName) {

		return productRepository.findByProductName(productName);
	}


	public List<Product> fetchProductByPriceRange(double min, double max) {

		List<Product> products = productRepository.findAll();
		List<Product> filteredProducts = products.stream().filter(p-> {
			return p.getPrice()>=min && p.getPrice()<=max;
		}).toList();
		
		
		return filteredProducts;
	}

}
