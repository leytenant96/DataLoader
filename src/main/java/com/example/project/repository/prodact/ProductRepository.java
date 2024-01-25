package com.example.project.repository.prodact;

import com.example.project.entity.prodact.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
