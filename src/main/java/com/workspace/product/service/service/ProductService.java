package com.workspace.product.service.service;

import java.util.List;

import com.workspace.product.service.dao.Product;

public interface ProductService {
	public List<Product> getAllActiveProductsOrderedByInsertionDate();

	public List<Product> findBy(String productName, Integer minPrice, Integer maxPrice,
			String minPostedDate, String maxPostedDate);

	public Product saveProduct(Product product);

	public Product updateProduct(Product product);

	public void deleteProduct(int productId);
}