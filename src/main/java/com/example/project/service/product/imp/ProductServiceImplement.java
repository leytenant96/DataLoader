package com.example.project.service.product.imp;

import com.example.project.entity.prodact.Product;
import com.example.project.module.Result;
import com.example.project.poyload.prodact.ProductPayload;
import com.example.project.repository.prodact.ProductRepository;
import com.example.project.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImplement implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryServiceImplement categoryService;
    private final AttachmentServiceImplement attachment;
    private final Result result;

    @Override
    public Result saveProduct(ProductPayload productPayload) {
        try {
            Product product = new Product();
            product.setName(productPayload.getName());
            product.setDiscreption(productPayload.getDiscreption());
            product.setPrice(productPayload.getPrice());
            product.setCategoryId(categoryService.findById(productPayload.getCategoryId()));
            product.setHashId(String.valueOf(attachment.findHashId(productPayload.getHashId())));
            productRepository.save(product);
            return result.success(product);
        } catch (Exception e) {
            return result.failed(e.getMessage());
        }
    }

    @Override
    public Result getProduct() {
        return result.success(productRepository.findAll());
    }

    public Result getProduct(Long id) {
        return result.success(productRepository.findById(id));
    }
}
