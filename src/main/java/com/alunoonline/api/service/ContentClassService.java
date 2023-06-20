package com.alunoonline.api.service;


import com.alunoonline.api.model.ContentClass;
import com.alunoonline.api.repository.ContentClassRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class ContentClassService {

    @Autowired
    ContentClassRepository contentClassRepository;

    public void saveData(ContentClass content_class) {
        log.warn("ContentClassService.saveData | Criando conteúdo no Redis.");
        contentClassRepository.save(content_class);
    }

    public ContentClass findById(String id) {
        log.warn("ContentClassService.findById |  Obtendo um conteúdo do Redis pelo id {} .", id);
        return contentClassRepository.findById(id).orElse(null);
    }

    public Iterable<ContentClass> listContenteClass() {
        log.warn("ContentClassService.listContenteClass |  Listando todo conteúdo do Redis.");
        return contentClassRepository.findAll();
    }

}
