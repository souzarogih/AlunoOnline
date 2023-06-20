package com.alunoonline.api.controller;

import com.alunoonline.api.model.StudentHistory;
import com.alunoonline.api.service.StudentHistoryService;
import com.alunoonline.api.service.StudentService;
import org.aspectj.weaver.ast.Literal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{id}")
    public ResponseEntity<StudentHistory> consultStudentHistory(@PathVariable String id) {
        StudentHistory savedStudentHistory = studentHistoryService.consultStudentHistoryById(id);
        return ResponseEntity.ok(savedStudentHistory);
    }

    @GetMapping("/student/{student_id}")
    public ResponseEntity<List<StudentHistory>> consultStudentId(@PathVariable String student_id) {
        List<StudentHistory> savedStudentHistory = studentHistoryService.consultStudentHistoryByStudentId(student_id);
        return ResponseEntity.ok(savedStudentHistory);
    }

    @GetMapping("/list-all")
    public ResponseEntity<List<StudentHistory>> listAllsStudentHistory() {
        List<StudentHistory> all_student_history_obj = studentHistoryService.listAllsStudentHistory();
        return ResponseEntity.ok(all_student_history_obj);
    }
}
