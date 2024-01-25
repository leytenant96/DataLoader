package com.example.project.poyload.prodact;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AttachmentPayload {
    String fileName;
    String hashId;
    String extension;
    String contentType;
    String uploadPath;
    String link;
    Long fileSize;
}
