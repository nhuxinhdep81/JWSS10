package com.tien.ss10.controller;

import com.tien.ss10.model.Account;
import com.tien.ss10.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/account-form")
    public String showForm(Model model) {
        Account account = new Account();
        model.addAttribute("account", account);
        return "registerForm";
    }

    @PostMapping("/account-save")
    public String saveAccount(@ModelAttribute("account") Account account, Model model) {
        boolean result = accountService.save(account);
        System.out.println(result);
        if (result) {
            model.addAttribute("account", account);
            return "resultb3";
        }else {
            return "redirect:/account-form";
        }
    }
}
