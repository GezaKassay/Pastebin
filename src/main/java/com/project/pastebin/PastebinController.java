package com.project.pastebin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PastebinController {

    @Autowired
    private TextServiceImpl textServiceImpl;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("allTextList", textServiceImpl.getAllText());
        return "index";
    }

    @PostMapping("/save")
    public String saveText(@ModelAttribute("text") Text text) {
        textServiceImpl.save(text);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String updateForm(@PathVariable(value = "id") Integer id, Model model) {
        Text text = textServiceImpl.getById(id);
        model.addAttribute("text", text);
        return "update";
    }

    @GetMapping("/deleteText/{id}")
    public String deleteThroughId(@PathVariable(value = "id") Integer id) {
        textServiceImpl.deleteViaId(id);
        return "redirect:/";

    }
}
