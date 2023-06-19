package com.alunoonline.api.service;


import com.alunoonline.api.model.ContentClasses;
import com.alunoonline.api.repository.ContentClassesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class ContentClassesService {

    @Autowired
    ContentClassesRepository contentClassesRepository;

    public void saveData(ContentClasses content_classes) {
        contentClassesRepository.save(content_classes);
    }

    public ContentClasses findById(String id) {
        return contentClassesRepository.findById(id).orElse(null);
    }

}
