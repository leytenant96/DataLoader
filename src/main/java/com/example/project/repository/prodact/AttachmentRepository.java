package com.example.project.repository.prodact;

import com.example.project.entity.prodact.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachmentRepository extends JpaRepository<Attachment, Long> {
    Attachment findByHashId(String hashId);
}
