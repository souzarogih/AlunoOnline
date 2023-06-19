package com.alunoonline.api.repository;

import com.alunoonline.api.model.Student;

import com.alunoonline.api.model.EnrollmentStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Transactional(readOnly = true)
    Student findByName (String name);

//    @Transactional(readOnly = true)
    Student findByEmail (String email);
}
