package com.alunoonline.api.controller;

import com.alunoonline.api.model.StudentEnrollment;
import com.alunoonline.api.service.StudentEnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentEnrollmentController {

    @Autowired
    StudentEnrollmentService studentEnrollmentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<StudentEnrollment> createStudentEnrollment(@RequestBody StudentEnrollment studentEnrollment) {
        StudentEnrollment studentEnrollmentObject = studentEnrollmentService.createStudentEnrollment(studentEnrollment);
        return ResponseEntity.status(201).body(studentEnrollmentObject);
    }
}
