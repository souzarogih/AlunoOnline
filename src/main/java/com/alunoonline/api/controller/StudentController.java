package com.alunoonline.api.controller;

import com.alunoonline.api.model.Student;
import com.alunoonline.api.model.dtos.StudentDTO;
import com.alunoonline.api.model.dtos.StudentNameCourseDto;
import com.alunoonline.api.service.StudentService;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

    @Autowired
    ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<StudentDTO> create(@RequestBody @Valid StudentDTO studentDTO) {
        log.warn("StudentController.create | Cadastrando novo aluno.");
        StudentDTO createdStudent = studentService.create(studentDTO);
        return ResponseEntity.status(201).body(createdStudent);
    }

    @GetMapping(value = "/list-all")
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

    @GetMapping("/nome/{nome}/email/{email}")
    public ResponseEntity<Student> buscarPorNomeAndEmail(@PathVariable("nome") String nome,
                                                       @PathVariable("email") String email) {
        return ResponseEntity.ok(studentService.findByNomeAndEmail(nome, email));
    }

    @GetMapping("/email/find/{email}")
    public ResponseEntity<List<Student>> buscarPorContemEmail(@PathVariable("email") String email) {
        log.info("Passando em buscarPorContemEmail");
        return ResponseEntity.ok(studentService.findByContemEmail(email));
    }

    @GetMapping("/list")
    public ResponseEntity<Page<Student>> listarAlunoPaginado(@RequestParam(defaultValue = "0") int page,
                                                             @RequestParam(defaultValue = "10") int size){
        return ResponseEntity.ok(studentService.listAllPag(page, size));
    }

    @GetMapping("/course-name/{id}")
    public ResponseEntity<StudentNameCourseDto> getNameCourseStudent(@PathVariable  long id){
//        StudentNameCourseDto dto = new StudentNameCourseDto(studentService.findById(id));
        StudentNameCourseDto studentNameCourseDto = studentService.buscarPorId(id);
//        return ResponseEntity.ok(dto);
        return ResponseEntity.ok(studentNameCourseDto);
    }
}
