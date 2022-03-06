package com.exemple.firstback.Repository;

import com.exemple.firstback.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
