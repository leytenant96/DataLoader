package com.example.project.controller.product;

import com.example.project.entity.prodact.Attachment;
import com.example.project.module.Result;
import com.example.project.service.product.imp.AttachmentServiceImplement;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.FileUrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.MalformedURLException;
import java.net.URLEncoder;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth/attachment")
public class AttachmentController {
    private final AttachmentServiceImplement attachmentService;

    @PostMapping("/save")
    public ResponseEntity<?> saveFile(@RequestParam("file") MultipartFile multipartFile) {
        Result result = attachmentService.saveAttachment(multipartFile);
        return ResponseEntity.status(result.isStatus() ? 200 : 403).body(result);
    }

    @GetMapping("/{hashId}")
    public ResponseEntity<?> preview(@PathVariable String hashId) {
        Attachment attachment = attachmentService.findHashId(hashId);

        try {
            return ResponseEntity.ok()
                    .header(HttpHeaders.EXPIRES, "inline; fileName=" + URLEncoder.encode(attachment.getFileName()))
                    .contentType(MediaType.parseMediaType(attachment.getContentType()))
                    .body(new FileUrlResource(String.format("%s/%s.%s",
                            attachment.getUploadPath(),
                            attachment.getHashId(),
                            attachment.getExtension())));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

}
