package com.example.project.service.product.imp;

import com.example.project.entity.prodact.Category;
import com.example.project.module.Result;
import com.example.project.poyload.prodact.CategoryPayload;
import com.example.project.repository.prodact.CategoryRepository;
import com.example.project.service.product.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryServiceImplement implements CategoryService {
    private final CatalogServiceImplement catalogServiceImplement;
    private final CategoryRepository categoryRepository;
    private final Result result;

    @Override
    public Result saveCategory(CategoryPayload categoryPayload) {
        try {
            Category category = new Category();
            category.setName(categoryPayload.getName());
            category.setCatalogId(catalogServiceImplement.findCatalogId(categoryPayload.getCatalogId()));
            categoryRepository.save(category);
            return result.success(category);
        } catch (Exception e) {
            return result.failed("Category can not save " + e.getMessage());
        }
    }

    @Override
    public Result getCategory() {
        try {
            return result.success(categoryRepository.findAll());
        } catch (Exception e) {
            return result.failed(e.getMessage());
        }
    }
    @Override
    public Result getCategory(Long id) {
        try {
            return result.success(categoryRepository.findById(id));
        } catch (Exception e) {
            return result.failed(e.getMessage());
        }
    }

    public Category findById(Long categoryId) {
        return categoryRepository.findById(categoryId).orElse(null);
    }
}
