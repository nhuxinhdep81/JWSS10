package com.tien.ss10.controller;

import com.tien.ss10.model.UserProfile;
import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.MultipartConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;


@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 30
)
@Controller
public class ProfileController {

    @Autowired
    private ServletContext servletContext;

    @GetMapping("/profile-form")
    public String profileForm(Model model) {
        UserProfile userProfile = new UserProfile();
        model.addAttribute("userProfile", userProfile);
        return "profile-form";
    }

    @PostMapping("/profile-save")
    public String profileSave(@ModelAttribute("userProfile") UserProfile userProfile,
                              Model model) {
        MultipartFile avatar = userProfile.getAvatar();
        if (avatar != null && !avatar.isEmpty()) {
            String avatarFileName = avatar.getOriginalFilename();
            long avatarFileSize = avatar.getSize();

            String uploadDir = servletContext.getRealPath("/uploadsB4");
            File fileUpload = new File(uploadDir);
            if (!fileUpload.exists()) {
                fileUpload.mkdirs();
            }
            try {
                avatar.transferTo(new File(fileUpload, avatarFileName));
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return "profile-success";
    }
}
