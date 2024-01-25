package com.example.project.poyload.prodact;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryPayload {
    String name;
    Long catalogId;
}
