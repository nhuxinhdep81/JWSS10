package com.tien.ss10.controller;

import com.tien.ss10.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @GetMapping("/login")
    public String login(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "userForm";
    }

    @PostMapping("/user-login")
    public String submitForm(@ModelAttribute("user") User user,
                             Model model) {
        model.addAttribute("user", user);
        return "result";
    }
}
