package com.ctse.microservices.product.repository;

import com.ctse.microservices.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // Custom query methods here if needed
}

