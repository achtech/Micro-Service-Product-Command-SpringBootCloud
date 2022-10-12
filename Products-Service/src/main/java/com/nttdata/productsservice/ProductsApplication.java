package com.nttdata.productsservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.nttdata.productsservice.entities.Product;
import com.nttdata.productsservice.enums.Category;
import com.nttdata.productsservice.repositories.ProductRepository;

@SpringBootApplication
public class ProductsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductsApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ProductRepository productRepository,
			RepositoryRestConfiguration configuration) {
		return args -> {
			configuration.exposeIdsFor(Product.class);
			for (int i = 0; i < 10; i++) {
				Product product = Product.builder()
						.category(i%2==0 ? Category.KNITTING : i%2==1 ? 
								Category.SHIRT : Category.TROUSERS )
						.id("P00"+i)
						.qte(i*10)
						.label("Product "+i)
						.price(Double.valueOf(i*100+100))
						.build();
				
				productRepository.save(product);
			}
		};
	}
	
}
