package com.example.project.poyload.prodact;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductPayload {
    String name;
    String discreption;
    double price;
    String hashId;

    Long categoryId;
}
