package com.example.project.service.product;

import com.example.project.entity.prodact.Attachment;
import com.example.project.module.Result;
import org.springframework.web.multipart.MultipartFile;

public interface AttachmentService {
    Result saveAttachment(MultipartFile multipartFile);

    Attachment findHashId(String hashId);

    boolean deleteAttachmentHashId(String hashId);
}
