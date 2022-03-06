package com.exemple.secondback;

import com.exemple.secondback.Entity.Supplier;
import com.exemple.secondback.Repository.SupplierRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.stream.Stream;


@SpringBootApplication
public class SecondBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecondBackApplication.class, args);
	}


	@Bean
	CommandLineRunner start(SupplierRepository supplierRepository, RepositoryRestConfiguration restConfiguration) {
		return args -> {
			restConfiguration.exposeIdsFor(Supplier.class);


			Stream.of("IBM", "Sumsung", "Apple").forEach(name -> {
				supplierRepository.save(new Supplier(null, name, "contact@"+name+".com"));
			});

			supplierRepository.findAll().forEach(supplier -> {
				System.out.println(supplier.getName());
			});

		};

	}

}
