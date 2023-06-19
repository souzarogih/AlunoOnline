package com.alunoonline.api.controller;

import com.alunoonline.api.model.Student;
import com.alunoonline.api.model.Teacher;
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

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Student> findById(@PathVariable Long id) {
        Student student = studentService.findById(id);
        return ResponseEntity.ok(student);
    }

    @GetMapping("/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Student> findByName(@PathVariable String name) {
        Student student = studentService.findByName(name);
        return ResponseEntity.ok(student);
    }

    @GetMapping("/email/{email}")
//    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Student> findByEmail(@PathVariable String email) {
        Student student = studentService.findByEmail(email);
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        studentService.deleteById(id);
    }
}
