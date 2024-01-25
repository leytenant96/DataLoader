package com.example.project.service.product.imp;

import com.example.project.entity.prodact.Attachment;
import com.example.project.module.Result;
import com.example.project.repository.prodact.AttachmentRepository;
import com.example.project.service.product.AttachmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.time.LocalDate;
import java.util.UUID;

@RequiredArgsConstructor
@Service
@Slf4j
public class AttachmentServiceImplement implements AttachmentService {
    private final AttachmentRepository attachmentRepository;
    private final Result result;

    @Value("${upload.folder}")
    private String uploadFolder;

    @Override
    public Result saveAttachment(MultipartFile multipartFile) {
        try {
            Attachment attachment = new Attachment();

            attachment.setContentType(multipartFile.getContentType());
            attachment.setFileName(multipartFile.getOriginalFilename().toLowerCase());
            attachment.setFileSize(multipartFile.getSize() / (8 * 1024));
            attachment.setHashId(UUID.randomUUID().toString());
            attachment.setExtension(getExtension(multipartFile).toLowerCase());

            LocalDate date = LocalDate.now();

            String uploadPath = String.format("%s %d %d %d %s",
                    uploadFolder,
                    date.getYear(),
                    date.getMonthValue(),
                    date.getDayOfMonth(),
                    attachment.getExtension()
            );
            File file = new File(uploadPath);

            if (!file.exists()) {
                file.mkdir();
            }

            attachment.setUploadPath(uploadPath);
            attachment.setLink(String.format("%s %s %s",
                    file.getAbsolutePath(),         // download/2022/10/28/jpg
                    attachment.getHashId(),         //hashId
                    attachment.getExtension()       //jpg
            ));
            attachmentRepository.save(attachment);
            return result.success(attachment);
        } catch (Exception e) {
            return result.failed(e.getMessage());
        }
    }

    private String getExtension(MultipartFile multipartFile) {
        String filename = multipartFile.getOriginalFilename();                   // sdfszvzxFccxs.jpg
        return filename.substring(filename.lastIndexOf(".") + 1);  // jpg
    }

    @Override
    public Attachment findHashId(String hashId) {
        return attachmentRepository.findByHashId(hashId);
    }

    @Override
    public boolean deleteAttachmentHashId(String hashId) {
        try {
            Attachment attachment = findHashId(hashId);

            File file = new File(attachment.getLink());
            System.out.println("DELETE " + file.delete());

            attachmentRepository.deleteById(attachment.getId());
            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return false;
    }
}
