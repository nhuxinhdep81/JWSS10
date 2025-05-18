package com.tien.ss10.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.tien.ss10.model.Book;
import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.MultipartConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 30
)@Controller
public class BookController {

    @Autowired
    private ServletContext serletContext;

    @Autowired
    private Cloudinary cloudinary;

    @GetMapping("book-form")
    public String showForm(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "book-form";
    }

    @PostMapping("book-save")
    public String saveBook(@ModelAttribute("book") Book book,
                           Model model) {
        MultipartFile fileImage = book.getFileImage();
//        if (fileImage != null && !fileImage.isEmpty()) {
//            String fileName = fileImage.getOriginalFilename();
//            long fileSize = fileImage.getSize();
//
//            String uploadDir = serletContext.getRealPath("/uploads");
//            File fileUpload = new File(uploadDir);
//            if (!fileUpload.exists()) {
//                fileUpload.mkdirs();
//            }
//            try {
//                fileImage.transferTo(new File(fileUpload, fileName));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

        // upload len cloudinary
        try {
            Map uploadResult = cloudinary.uploader()
                    .upload(fileImage.getBytes(), ObjectUtils.emptyMap());
            String url = (String) uploadResult.get("url");
            if (url == null || url.isEmpty()) {
                throw new RuntimeException("URL is null or empty");
            }
            // truy url ra ngoai giao dien
            model.addAttribute("url", url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(book);
//        System.out.println("Publish Date: " + book.getPublishDate());
        model.addAttribute("book", book);
        return "book-success";
    }


}
