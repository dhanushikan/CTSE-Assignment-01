package com.ctse.microservices.product;



import com.ctse.microservices.product.model.Product;
import com.ctse.microservices.product.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
@RequiredArgsConstructor
public class ProductServiceApplication {

	private final DataSource dataSource;

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner run(ProductRepository repo) {
		return args -> {
			Product p = new Product();
			p.setName("Test Product");
			p.setDescription("This is a test product");
			p.setCategoryId("12345");
			p.setPrice(25.0);

			repo.save(p);
		};
	}
}

