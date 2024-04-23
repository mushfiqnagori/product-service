package com.workspace.product.service.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.workspace.product.service.dao.Product;
import com.workspace.product.service.dto.Response;
import com.workspace.product.service.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
    private ProductService productService;

	@GetMapping()
	List<Product> getProducts() {
		System.out.println("getProduct");
		return productService.getAllActiveProductsOrderedByInsertionDate();
	}

	@GetMapping(value = "/search")
	List<Product> getProducts(@RequestParam(required = false) String productName,
			@RequestParam(required = false) Integer minPrice, @RequestParam(required = false) Integer maxPrice,
			@RequestParam(required = false) String minPostedDate,
			@RequestParam(required = false) String maxPostedDate) {
		System.out.println("getProducts by param");
		return productService.findBy(productName, minPrice, maxPrice, minPostedDate, maxPostedDate);
		
	}

	@PostMapping()
	ResponseEntity addProduct(@RequestBody Product product) {
		// add
		System.out.println("addProducs "+product);
		Product product1 = productService.saveProduct(product);
		if(product1.getProductId() != 0)
			return ResponseEntity.created(null).build();
		else
			return (ResponseEntity) ResponseEntity.badRequest();
		
		
	}

	@PutMapping("/{productId}")
	ResponseEntity<Response> updateProduct(@PathVariable(name = "productId") int productId,
			@RequestBody Product product) {
		
		return null;
	}
	
	@DeleteMapping("/{productId}")
	ResponseEntity<Response> deleteProduct(@PathVariable(name = "productId") int productId) {
		System.out.println("Delete productId :"+productId);
		
		return null;
	}
	
	@GetMapping(value = "/approval-queue")
	List<Product> getApprovalQueue() {
		System.out.println("all approval-queue");
		return new ArrayList();
	}
	
	@PutMapping(value = "/approval-queue/{approvalId}/approve")
	List<Product> ppproveProduct(@PathVariable("approvalId") int approvalId) {
		return new ArrayList();
	}
	
	@PutMapping(value = "/approval-queue/{approvalId}/reject")
	List<Product> rejectProduct(@PathVariable("approvalId") int rejectId) {
		return new ArrayList();
	}
}
