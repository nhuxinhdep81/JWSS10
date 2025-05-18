package com.tien.ss10.model;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data

public class Book {

//    private int id;
    private String title;
    private String ISBN;
    private double price;
    private MultipartFile fileImage;
//    private Date publishDate;
}
