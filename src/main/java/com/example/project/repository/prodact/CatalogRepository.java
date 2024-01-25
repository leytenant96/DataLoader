package com.example.project.repository.prodact;

import com.example.project.entity.prodact.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogRepository extends JpaRepository<Catalog, Long> {
}
