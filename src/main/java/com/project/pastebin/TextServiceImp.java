package com.project.pastebin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TextServiceImp implements TextService {

    @Autowired
    private TextRepository textRepo;

    @Override
    public List<TextEntity> getAllText() {
        return textRepo.findAll();
    }

    @Override
    public void save(TextEntity text) {
        textRepo.save(text);
    }

    @Override
    public TextEntity getById(Long id) {
        Optional<TextEntity> optional = textRepo.findById(id);
        TextEntity text = null;
        if (optional.isPresent()) {
            text = optional.get();
        } else {
            throw new RuntimeException("Text not found for id : " + id);
        }
        return text;
    }

    @Override
    public void deleteViaId(long id) {
        textRepo.deleteById(id);
    }
}
