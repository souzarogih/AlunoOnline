package com.alunoonline.api.service;


import com.alunoonline.api.model.ContentClass;
import com.alunoonline.api.repository.ContentClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContentClassService {

    @Autowired
    ContentClassRepository contentClassRepository;

    public void saveData(ContentClass content_class) {
        contentClassRepository.save(content_class);
    }

    public ContentClass findById(String id) {
        return contentClassRepository.findById(id).orElse(null);
    }

}
