package com.project.pastebin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PastebinController {

    @Autowired
    private TextRepository textRepository;

    @PostMapping("/add")
    public String addText(@RequestParam String readText) {
        Text text = new Text();
        text.setTextInput(readText);
        textRepository.save(text);
        return "Added new text!";
    }

    @GetMapping("/list")
    public Iterable<Text> getText() {
        return textRepository.findAll();
    }

    @GetMapping("/find/{id}")
    public Text findTextById(@PathVariable Integer id) {
        return textRepository.findTextById(id);
    }
}