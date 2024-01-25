package com.example.project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
@MappedSuperclass
public abstract class AbstractHelper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
//    boolean deleteValue;

    @CreationTimestamp
    Date createDate;
    @UpdateTimestamp
    Date updateDate;
}
