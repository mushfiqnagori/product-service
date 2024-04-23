package com.workspace.product.service.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.workspace.product.service.dao.Product;
import com.workspace.product.service.dao.ProductApproval;
import com.workspace.product.service.repository.ProductApprovalRepository;
import com.workspace.product.service.repository.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductApprovalRepository ProductApprovalRepository;

	public List<Product> getAllActiveProductsOrderedByInsertionDate() {
		return productRepository.findByStatusOrderByInsertionDate("approved");
	}

	public List<Product> findBy(String productName, Integer minPrice, Integer maxPrice, String minPostedDate,
			String maxPostedDate) {
		return productRepository.findByNameOrPriceGreaterThanAndPriceLessThan(productName, minPrice, maxPrice);
	}

	public Product saveProduct(Product product) {
		if (product.getPrice() > 10000) {
			ProductApproval approval = new ProductApproval();
			approval.setRequestedDate(new Date());
			product.setStatus("pending");
			approval.setProduct(product);
			System.out.println(approval);
			return ProductApprovalRepository.save(approval).getProduct();
		} else {
			product.setStatus("approved");
			System.out.println(product);
			return productRepository.save(product);
		}
	}

	public Product updateProduct(Product product) {
		if (product.getPrice() > 10000) {
			// Check if there is an existing approval for the product
			Optional<ProductApproval> existingApproval = ProductApprovalRepository.findById(product.getProductId());
			System.out.println(existingApproval);
			if (!existingApproval.isPresent()) {
				ProductApproval approval = new ProductApproval();
				approval.setRequestedDate(new Date());
				approval.setProduct(product);
				ProductApprovalRepository.save(approval);
			}
		}
		return productRepository.saveAndFlush(product);
	}

	public void deleteProduct(int productId) {
		productRepository.deleteById(productId);
	}
}
