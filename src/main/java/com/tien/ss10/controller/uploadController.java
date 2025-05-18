package com.tien.ss10.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.tien.ss10.model.File;
import com.tien.ss10.service.FileServie;
import jakarta.servlet.annotation.MultipartConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 30)
@Controller
public class uploadController {

    @Autowired
    private FileServie fileServie;

    @Autowired
    private Cloudinary cloudinary;

    @GetMapping("/file-form")
    public String fileForm(Model model) {
        File file1 = new File();
        model.addAttribute("file1", file1);
        return "uploadForm";
    }

    @PostMapping("/file-save")
    public String fileSave(@ModelAttribute("file1") File file1, Model model) {
        MultipartFile fileImage = file1.getFile();


        // upload len cloudinary
        try {
            Map uploadResult = cloudinary.uploader()
                    .upload(fileImage.getBytes(), ObjectUtils.emptyMap());
            String url = (String) uploadResult.get("url");
            if (url == null || url.isEmpty()) {
                throw new RuntimeException("URL is null or empty");
            }
            // truy url ra ngoai giao dien
            file1.setFilename(url);
            fileServie.save(file1);
            model.addAttribute("url", url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(file1);
//        System.out.println("Publish Date: " + book.getPublishDate());
        model.addAttribute("file1", file1);
        return "file-success";
    }
}
