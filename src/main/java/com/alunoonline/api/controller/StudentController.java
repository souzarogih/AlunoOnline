package com.alunoonline.api.controller;

import com.alunoonline.api.model.Student;
import com.alunoonline.api.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> create(@RequestBody Student student) {
        Student createdStudent = studentService.create(student);

        return ResponseEntity.status(201).body(createdStudent);
    }

    @GetMapping("/list-all")
    @ResponseStatus(HttpStatus.OK)
    public List<Student> lis() {
        return studentService.listAll();
    }
}
