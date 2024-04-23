package com.workspace.product.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.workspace.product.service.dao.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    
	List<Product> findByStatusOrderByInsertionDate(String status);
	
	
	List<Product> findByName(String productName);
	List<Product> findByPriceLessThan(double maxPrice);
	List<Product> findByPriceGreaterThanEqual(double minPrice);
	List<Product> findByPriceBetween(double minPrice, double maxPrice);
	List<Product> findByNameContainingIgnoreCase(String productName);
    @Override
    <S extends Product> S save(S entity);

    @Override
    <S extends Product> S saveAndFlush(S entity);

    @Override
    void delete(Product entity);


//	List<Product> findBy(String productName, Integer minPrice, Integer maxPrice, String minPostedDate, String maxPostedDate);

    
	List<Product> findByNameOrPriceGreaterThanAndPriceLessThan(String productName, Integer minPrice, Integer maxPrice);
}
