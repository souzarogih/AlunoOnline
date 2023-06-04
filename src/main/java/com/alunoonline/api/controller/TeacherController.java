package com.alunoonline.api.controller;

import com.alunoonline.api.model.Student;
import com.alunoonline.api.model.Teacher;
import com.alunoonline.api.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Teacher> create(@RequestBody Teacher teacher) {
        Teacher createTeacher = teacherService.create(teacher);
        return ResponseEntity.status(201).body(createTeacher);
    }

    @GetMapping("/list-all")
    @ResponseStatus(HttpStatus.OK)
    public List<Teacher> listAll() {
        return teacherService.listAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Teacher> findById(@PathVariable Long id) {
        Teacher teacher = teacherService.findById(id);
        return ResponseEntity.ok(teacher);
    }

    @GetMapping("/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Teacher> findByName(@PathVariable String name) {
        Teacher teacher = teacherService.findByName(name);
        return ResponseEntity.ok(teacher);
    }

    @GetMapping("/email/{email}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Teacher> findByEmail(@PathVariable String email) {
        Teacher teacher = teacherService.findByEmail(email);
        return ResponseEntity.ok(teacher);
    }
}
