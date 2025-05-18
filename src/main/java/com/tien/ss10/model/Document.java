package com.tien.ss10.model;

import lombok.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Document {
    private String title;
    private String description;
    private MultipartFile file;
    private String fileUrl;

}
