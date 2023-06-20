package com.alunoonline.api.controller;

import com.alunoonline.api.model.ContentClass;
import com.alunoonline.api.service.ContentClassService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping("/content-class")
public class ContentClassController {

    @Autowired
    ContentClassService contentClassService;

    @PostMapping
    public void saveData(@RequestBody ContentClass content_class) {
        log.warn("ContentClassController.saveData | Cadastrando um conteúdo.");
        contentClassService.saveData(content_class);
    }

    @GetMapping("/{id}")
    public ContentClass findById(@PathVariable String id) {
        log.warn("ContentClassController.findById | Localizando um conteúdo pelo id {} .", id);
        return contentClassService.findById(id);
    }

    @GetMapping("/list-all")
    public Iterable<ContentClass> getAllContenteClass() {
        log.warn("ContentClassController.getAllContenteClass | Listando todo conteúdo.");
        return contentClassService.listContenteClass();
    }
}
