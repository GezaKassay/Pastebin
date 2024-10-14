package com.project.pastebin;

import org.springframework.data.repository.CrudRepository;

public interface TextRepository extends CrudRepository<Text, Integer>{Text findTextById(Integer id);}
