package com.project.pastebin.controller;

import com.project.pastebin.TextServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private TextServiceImp textServiceImp;

    @GetMapping("/pastebin/home")
    public String viewHomePage(Model model) {
        model.addAttribute("alltextlist", textServiceImp.getAllText());
        return "index";
    }
}
