package com.project.pastebin.controller;

import com.project.pastebin.TextEntity;
import com.project.pastebin.TextServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PastebinController {

    @Autowired
    private TextServiceImp textServiceImp;

    @GetMapping("/pastebin/add-new")
    public String addNewText(Model model) {
        TextEntity text = new TextEntity();
        model.addAttribute("text", text);
        return "newtext";
    }

    @PostMapping("/pastebin/save")
    public String saveText(@ModelAttribute("text") TextEntity text) {
        textServiceImp.save(text);
        return "redirect:/home";
    }

    @GetMapping("/pastebin/{id}")
    public String updateForm(@PathVariable(value = "id") long id, Model model) {
        TextEntity text = textServiceImp.getById(id);
        model.addAttribute("text", text);
        return "update";
    }

    @PostMapping("/pastebin/{id}/delete")
    public String deleteThroughId(@PathVariable(value = "id") long id) {
        textServiceImp.deleteViaId(id);
        return "redirect:/home";

    }
}