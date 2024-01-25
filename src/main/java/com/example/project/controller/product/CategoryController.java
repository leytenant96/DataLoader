package com.example.project.controller.product;

import com.example.project.module.Result;
import com.example.project.poyload.prodact.CatalogPayload;
import com.example.project.poyload.prodact.CategoryPayload;
import com.example.project.service.product.imp.CategoryServiceImplement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth/category")
public class CategoryController {
    private final CategoryServiceImplement categoryService;

    @PostMapping("/")
    public ResponseEntity saveCategory(@RequestBody CategoryPayload categoryPayload) {
        Result result = categoryService.saveCategory(categoryPayload);

        return ResponseEntity.status(result.isStatus() ? 200 : 403).body(result);
    }

    @GetMapping("/")
    public ResponseEntity getAllCategory() {
        Result result = categoryService.getCategory();

        return ResponseEntity.status(result.isStatus() ? 200 : 403).body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity getCategory(@PathVariable Long id) {
        Result result = categoryService.getCategory(id);

        return ResponseEntity.status(result.isStatus() ? 200 : 403).body(result);
    }
}
