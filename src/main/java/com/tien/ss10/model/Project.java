package com.tien.ss10.model;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Project {
    private int id;
    private String name;
    private String description;
    private List<MultipartFile> documents;
}
