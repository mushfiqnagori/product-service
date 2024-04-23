package com.workspace.product.service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.workspace.product.service.dao.ProductApproval;

@Repository
public interface ProductApprovalRepository extends JpaRepository<ProductApproval, Integer> {

    // Custom method to find approval by product ID
    Optional<ProductApproval> findById(int productId);
}
