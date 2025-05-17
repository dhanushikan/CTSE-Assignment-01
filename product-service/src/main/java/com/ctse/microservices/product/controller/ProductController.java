package com.ctse.microservices.product.controller;

import com.ctse.microservices.product.dto.ProductRequest;
import com.ctse.microservices.product.dto.ProductResponse;
import com.ctse.microservices.product.model.Product;
import com.ctse.microservices.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/test")
    public String test() {
        return "Product Service is working successfully!";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse createProduct(@RequestBody ProductRequest productRequest) {
        return productService.createProduct(productRequest);
        //To create a product
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
        //To test02 CI/CD pipeline
        //To test03 CI/CD pipeline

    }


}
