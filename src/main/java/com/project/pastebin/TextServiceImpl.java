package com.project.pastebin;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TextServiceImpl implements TextService {

    @Autowired private TextRepository textRepo;

    @Override
    public List<Text> getAllText() {
        return (List<Text>) textRepo.findAll();
    }

    @Override
    public void save(Text text) {
        textRepo.save(text);
    }

    @Override
    public Text getById(Integer id) {
        Optional<Text> optional = textRepo.findById(id);
        Text text = null;
        if (optional.isPresent()) {
            text = optional.get();
        } else {
            throw new RuntimeException("Text with id " + id + " not found");
        }
        return text;
    }

    @Override
    public void deleteViaId(Integer id) {
        textRepo.deleteById(id);
    }
}
