package com.example.project.controller.product;

import com.example.project.module.Result;
import com.example.project.poyload.prodact.CategoryPayload;
import com.example.project.poyload.prodact.ProductPayload;
import com.example.project.service.product.imp.CategoryServiceImplement;
import com.example.project.service.product.imp.ProductServiceImplement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth/product")
public class ProductController {
    private final ProductServiceImplement productService;

    @PostMapping("/")
    public ResponseEntity saveProduct(@RequestBody ProductPayload productPayload) {
        Result result = productService.saveProduct(productPayload);

        return ResponseEntity.status(result.isStatus() ? 200 : 403).body(result);
    }

    @GetMapping("/")
    public ResponseEntity getAllProduct() {
        Result result = productService.getProduct();

        return ResponseEntity.status(result.isStatus() ? 200 : 403).body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity getProduct(@PathVariable Long id) {
        Result result = productService.getProduct(id);

        return ResponseEntity.status(result.isStatus() ? 200 : 403).body(result);
    }
}
