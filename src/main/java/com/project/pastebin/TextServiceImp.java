package com.project.pastebin;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TextServiceImp implements TextService {

    @Autowired
    private TextRepository textRepo;

    @Override
    public List<Text> getAllText() {
        return textRepo.findAll();
    }

    @Override
    public void save(Text text) {
        textRepo.save(text);
    }

    @Override
    public Text getById(Long id) {
        Optional<Text> optional = textRepo.findById(id);
        Text text = null;
        if (optional.isPresent())
            text = optional.get();
        else
            throw new RuntimeException(
                    "Text not found for id : " + id);
        return text;
    }

    @Override
    public void deleteViaId(long id) {
        textRepo.deleteById(id);
    }
}
