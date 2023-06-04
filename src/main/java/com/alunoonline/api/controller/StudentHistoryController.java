package com.alunoonline.api.controller;

import com.alunoonline.api.model.StudentHistory;
import com.alunoonline.api.service.StudentHistoryService;
import com.alunoonline.api.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student-history")
public class StudentHistoryController {

    @Autowired
    StudentHistoryService studentHistoryService;

    @PostMapping
    public ResponseEntity<StudentHistory> createStudentHistory(@RequestBody StudentHistory student_history) {
        StudentHistory savedStudentHistory = studentHistoryService.createStudentHistory(student_history);
        String studentHistoryId = savedStudentHistory.getId().toString();
        savedStudentHistory.setId(studentHistoryId);
        return ResponseEntity.ok(savedStudentHistory);
    }
}
