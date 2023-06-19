package com.alunoonline.api.controller;

import com.alunoonline.api.model.ContentClass;
import com.alunoonline.api.service.ContentClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContentClassController {

    @Autowired
    ContentClassService contentClassService;

    @PostMapping("/content-class")
    public void saveData(@RequestBody ContentClass content_class) {
        contentClassService.saveData(content_class);
    }
}
