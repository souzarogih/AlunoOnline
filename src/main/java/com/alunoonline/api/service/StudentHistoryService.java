package com.alunoonline.api.service;

import com.alunoonline.api.model.StudentHistory;
import com.alunoonline.api.repository.StudentHistoryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentHistoryService {

    @Autowired
    StudentHistoryRepository studentHistoryRepository;

    public StudentHistory createStudentHistory(StudentHistory studentHistory) {
        return studentHistoryRepository.save(studentHistory);
    }

    public StudentHistory consultStudentHistoryById(String id) {
        return studentHistoryRepository.findById(id).orElse(null);
    }
}
