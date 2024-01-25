package com.example.project.service.product;

import com.example.project.module.Result;
import com.example.project.poyload.prodact.CatalogPayload;

public interface CatalogService {
    Result saveCatalog(CatalogPayload catalogPayload);

    Result getCatalog(Long id);

    Result getCatalog();
}
