package com.example.project.entity.prodact;

import com.example.project.entity.AbstractHelper;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@SuperBuilder
public class Product extends AbstractHelper {
    String name;
    String discreption;
    double price;
    String hashId;

    @ManyToOne
    Category categoryId;
}
