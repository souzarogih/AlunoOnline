package com.alunoonline.api.repository;

import com.alunoonline.api.model.StudentHistory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentHistoryRepository extends MongoRepository<StudentHistory, String> {

    List<StudentHistory> findByStudentId(String studentId);
}
