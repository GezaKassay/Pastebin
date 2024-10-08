package com.project.pastebin;

import java.util.List;

public interface TextService {
    List<Text> getAllText();
    void save(Text text);
    Text getById(Integer id);
    void deleteViaId(Integer id);
}
