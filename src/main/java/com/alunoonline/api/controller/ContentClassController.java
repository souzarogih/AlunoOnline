package com.alunoonline.api.controller;

import com.alunoonline.api.model.ContentClass;
import com.alunoonline.api.service.ContentClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/content-class")
public class ContentClassController {

    @Autowired
    ContentClassService contentClassService;

    @PostMapping
    public void saveData(@RequestBody ContentClass content_class) {
        contentClassService.saveData(content_class);
    }

    @GetMapping("/{id}")
    public ContentClass findById(@PathVariable String id) {
        return contentClassService.findById(id);
    }

    @GetMapping("/list-all")
    public Iterable<ContentClass> getAllContenteClass() {
        return contentClassService.listContenteClass();
    }
}
