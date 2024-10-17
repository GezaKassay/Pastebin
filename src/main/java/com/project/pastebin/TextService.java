package com.project.pastebin;

import java.util.List;

public interface TextService {
    List<TextEntity> getAllText();
    void save(TextEntity text);
    TextEntity getById(Long id);
    void deleteViaId(long id);
}
