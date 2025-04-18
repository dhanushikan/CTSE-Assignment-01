package com.ctse.microservices.product.service;

import com.ctse.microservices.product.dto.ProductRequest;
import com.ctse.microservices.product.dto.ProductResponse;
import com.ctse.microservices.product.model.Product;
import com.ctse.microservices.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;

    public ProductResponse createProduct(ProductRequest productRequest) {
       Product product = Product.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .categoryId(productRequest.categoryId())
                .price(productRequest.price())
                .build();
        productRepository.save(product);
        log.info("Product created successfully");
        return new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getCategoryId(), product.getPrice());
        // Logic to create a product
        // This is just a placeholder for the actual implementation
        // You would typically convert ProductRequest to Product entity and save it to the repository
    }

    public List<ProductResponse> getAllProducts() {
    return productRepository.findAll()
            .stream()
            .map(product -> new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getCategoryId(), product.getPrice()))
            .toList();
        // Logic to retrieve all products
        // This is just a placeholder for the actual implementation
        // You would typically fetch the products from the repository and return them
    }

    public long getProductCount() {
        return productRepository.count();
    }
}
