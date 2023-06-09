package com.alunoonline.api.controller;

import com.alunoonline.api.model.EnrollmentStudent;
import com.alunoonline.api.service.EnrollmentStudentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/enrollment_student")
public class EnrollmentStudentController {

    @Autowired
    EnrollmentStudentService enrollmentStudentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<EnrollmentStudent> createStudentEnrollment(@RequestBody EnrollmentStudent studentEnrollment) {
        log.warn("EnrollmentStudentController.createStudentEnrollment | Matriculando aluno em disciplina {} ", studentEnrollment.getStudent());
        EnrollmentStudent studentEnrollmentObject = enrollmentStudentService.createStudentEnrollment(studentEnrollment);
        return ResponseEntity.status(201).body(studentEnrollmentObject);
    }

    @GetMapping("/list-all")
    @ResponseStatus(HttpStatus.OK)
    public List<EnrollmentStudent> listAllEnrollmentStudent() {
        log.warn("EnrollmentStudentController.listAllEnrollmentStudent | Listando todas as matrículas.");
        return enrollmentStudentService.listAllStudentEnrollment();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<EnrollmentStudent> findById(@PathVariable Long id) {
        log.warn("EnrollmentStudentController.findById | Obtendo uma matrícula pelo ID {}", id);
        EnrollmentStudent enrollment_student_obj = enrollmentStudentService.findByIdStudentEnrollment(id);
        return ResponseEntity.ok(enrollment_student_obj);
    }

    /**
     * Recurso que retorna a lista de disciplinas que está matriculada para o aluno.
     * @param id
     * @return
     */
    @GetMapping("/student/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<EnrollmentStudent>> findByStudentId(@PathVariable Long id) {
        log.warn("EnrollmentStudentController.findByStudentId | Obtendo uma lista de disciplinas matriculada para um aluno pelo ID {}", id);
        List<EnrollmentStudent> enrollment_student_obj = enrollmentStudentService.findByStudentEnrollmentStudentId(id);
        return ResponseEntity.ok(enrollment_student_obj);
    }
}
