package com.exemple.firstback;

import com.exemple.firstback.Entity.Product;
import com.exemple.firstback.Repository.ProductRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class FirstBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstBackApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ProductRepository productRepository) {
		return args -> {
			productRepository.save(new Product(null,"Produit 1",500));
			productRepository.save(new Product(null,"Produit 2",1500));
			productRepository.save(new Product(null,"Produit 3",800));
			productRepository.findAll().forEach(p->{
				System.out.println(p.getName());
			});
		};
	}

}
