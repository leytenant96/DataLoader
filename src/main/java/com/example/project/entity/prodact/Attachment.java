package com.example.project.entity.prodact;

import com.example.project.entity.AbstractHelper;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Attachment extends AbstractHelper {
    String hashId;
    String fileName;
    String uploadPath;
    String extension;
    String contentType;
    String link;
    Long fileSize;
}
