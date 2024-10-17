package com.project.pastebin.Controller;

import com.project.pastebin.TextEntity;
import com.project.pastebin.TextServiceImp;
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

    @GetMapping("/Pastebin/add-new")
    public String addNewText(Model model) {
        TextEntity text = new TextEntity();
        model.addAttribute("text", text);
        return "newtext";
    }

    @PostMapping("/Pastebin/save")
    public String saveText(@ModelAttribute("text") TextEntity text) {
        textServiceImp.save(text);
        return "redirect:/Home";
    }

    @GetMapping("/Pastebin/{id}")
    public String updateForm(@PathVariable(value = "id") long id, Model model) {
        TextEntity text = textServiceImp.getById(id);
        model.addAttribute("text", text);
        return "update";
    }

    @GetMapping("/Pastebin/{id}/delete")
    public String deleteThroughId(@PathVariable(value = "id") long id) {
        textServiceImp.deleteViaId(id);
        return "redirect:/Home";

    }
}