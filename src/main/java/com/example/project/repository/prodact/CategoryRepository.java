package com.example.project.repository.prodact;

import com.example.project.entity.prodact.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
