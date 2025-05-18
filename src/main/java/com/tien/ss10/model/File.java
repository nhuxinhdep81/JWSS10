package com.tien.ss10.model;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class File {
    private MultipartFile file;
    private String description;
    private String filename;
}
