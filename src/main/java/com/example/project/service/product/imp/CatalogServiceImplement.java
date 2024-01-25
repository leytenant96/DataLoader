package com.example.project.service.product.imp;

import com.example.project.entity.prodact.Catalog;
import com.example.project.module.Result;
import com.example.project.poyload.prodact.CatalogPayload;
import com.example.project.repository.prodact.CatalogRepository;
import com.example.project.service.product.CatalogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CatalogServiceImplement implements CatalogService {
    private final CatalogRepository catalogRepository;
    private final Result result;

    @Override
    public Result saveCatalog(CatalogPayload catalogPayload) {
        try {
            Catalog catalog = new Catalog();
            catalog.setName(catalogPayload.getName());
            catalogRepository.save(catalog);
            return result.success(catalog);
        } catch (Exception e) {
//            log.error(e.getMessage());
            return result.failed(e.getMessage());
        }
    }

    @Override
    public Result getCatalog() {
        try {
            return result.success(catalogRepository.findAll());
        } catch (Exception e) {
            return result.failed(e.getMessage());
        }
    }

    @Override
    public Result getCatalog(Long id) {
        try {
            return result.success(catalogRepository.findById(id));
        } catch (Exception e) {
            return result.failed(e.getMessage());
        }
    }

    public Catalog findCatalogId(Long id) {
        return catalogRepository.findById(id).orElse(null);
    }
}
