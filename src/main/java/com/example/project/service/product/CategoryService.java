package com.example.project.service.product;

import com.example.project.module.Result;
import com.example.project.poyload.prodact.CategoryPayload;

public interface CategoryService {
    Result saveCategory(CategoryPayload categoryPayload);

    Result getCategory();

    Result getCategory(Long id);
}
