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
    private TextServiceImp textServiceImp;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("alltextlist", textServiceImp.getAllText());
        return "index";
    }

    @GetMapping("/addnew")
    public String addNewText(Model model) {
        Text text = new Text();
        model.addAttribute("text", text);
        return "newtext";
    }

    @PostMapping("/save")
    public String saveText(@ModelAttribute("text") Text text) {
        textServiceImp.save(text);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String updateForm(@PathVariable(value = "id") long id, Model model) {
        Text text = textServiceImp.getById(id);
        model.addAttribute("text", text);
        return "update";
    }

    @GetMapping("/deleteText/{id}")
    public String deleteThroughId(@PathVariable(value = "id") long id) {
        textServiceImp.deleteViaId(id);
        return "redirect:/";

    }
}