package com.tien.ss10.controller;

import com.tien.ss10.model.Document;
import com.tien.ss10.service.DocumentService;
import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Controller
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @Autowired
    private ServletContext servletContext;

    @GetMapping("/document-form")
    public String documentForm(Model model) {
        Document document = new Document();
        model.addAttribute("document", document);
        return "document-form";
    }

    @PostMapping("/document-save")
    public String documentSave(@ModelAttribute("document") Document document, Model model) {
        MultipartFile file = document.getFile();
        if (file != null && !file.isEmpty()) {
            String fileName = file.getOriginalFilename();
            String uploadDir = servletContext.getRealPath("/uploadsB5");

            File uploadFolder = new File(uploadDir);
            if (!uploadFolder.exists()) {
                uploadFolder.mkdirs();
            }

            try {
                file.transferTo(new File(uploadFolder, fileName));

                String relativePath = "uploadsB5/" + fileName;
                document.setFileUrl(relativePath);

                boolean result = documentService.save(document);
                if (result) {
                    model.addAttribute("document", document);
                    return "document-success";
                }

            } catch (Exception e) {
                e.printStackTrace();
                model.addAttribute("error", "Đã xảy ra lỗi khi upload file.");
            }
        } else {
            model.addAttribute("error", "File không hợp lệ hoặc trống.");
        }

        return "document-form";
    }
}
