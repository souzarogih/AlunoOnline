package com.alunoonline.api.controller;

import com.alunoonline.api.model.Student;
import com.alunoonline.api.model.Teacher;
import com.alunoonline.api.service.StudentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController()
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> create(@RequestBody Student student) {
        log.warn("StudentController.create | Cadastrando novo aluno.");
        Student createdStudent = studentService.create(student);
        return ResponseEntity.status(201).body(createdStudent);
    }

    @GetMapping("/list-all")
    @ResponseStatus(HttpStatus.OK)
    public List<Student> lis() {
        log.warn("StudentController.lis | Listando todos os alunos cadastrados na base de dados .");
        return studentService.listAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Student> findById(@PathVariable Long id) {
        log.warn("StudentController.findById | Obtendo os dados de um aluno cadastrado na base de dados através do ID.");
        Student student = studentService.findById(id);
        return ResponseEntity.ok(student);
    }

    @GetMapping("/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Student> findByName(@PathVariable String name) {
        log.warn("StudentController.findByName | Obtendo os dados de um aluno cadastrado na base de dados através do nome.");
        Student student = studentService.findByName(name);
        return ResponseEntity.ok(student);
    }

    @GetMapping("/email/{email}")
//    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Student> findByEmail(@PathVariable String email) {
        log.warn("StudentController.findByEmail | Obtendo os dados de um aluno cadastrado na base de dados através do e-mail.");
        Student student = studentService.findByEmail(email);
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        log.warn("StudentController.findByEmail | Removendo os dados de um aluno da base de dados.");
        studentService.deleteById(id);
    }
}
