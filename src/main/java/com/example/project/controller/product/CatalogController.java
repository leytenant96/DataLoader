package com.example.project.controller.product;

import com.example.project.module.Result;
import com.example.project.poyload.prodact.CatalogPayload;
import com.example.project.service.product.imp.CatalogServiceImplement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth/catalog")
@RequiredArgsConstructor
public class CatalogController {
    private final CatalogServiceImplement catalogService;

    @PostMapping("/")
    public ResponseEntity saveCatalog(@RequestBody CatalogPayload catalogPayload) {
        Result result = catalogService.saveCatalog(catalogPayload);

        return ResponseEntity.status(result.isStatus() ? 200 : 403).body(result);
    }

    @GetMapping("/")
    public ResponseEntity getAllCatalog() {
        Result result = catalogService.getCatalog();

        return ResponseEntity.status(result.isStatus() ? 200 : 403).body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity getCatalog(@PathVariable Long id) {
        Result result = catalogService.getCatalog(id);

        return ResponseEntity.status(result.isStatus() ? 200 : 403).body(result);
    }
}

