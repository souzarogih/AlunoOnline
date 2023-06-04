package com.alunoonline.api.repository;

import com.alunoonline.api.model.StudentHistory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentHistoryRepository extends MongoRepository<StudentHistory, String> {
}
