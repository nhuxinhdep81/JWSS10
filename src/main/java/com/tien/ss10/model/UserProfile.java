package com.tien.ss10.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class UserProfile {
    private MultipartFile avatar;
    private String username;
}
