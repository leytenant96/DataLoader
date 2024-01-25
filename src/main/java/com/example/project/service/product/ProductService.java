package com.example.project.service.product;

import com.example.project.module.Result;
import com.example.project.poyload.prodact.ProductPayload;

public interface ProductService {
    Result saveProduct(ProductPayload productPayload);
    Result getProduct();

}
