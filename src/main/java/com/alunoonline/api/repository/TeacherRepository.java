package com.alunoonline.api.repository;

import com.alunoonline.api.model.Student;
import com.alunoonline.api.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    @Transactional(readOnly = true)
    Teacher findByName (String name);

    //    @Transactional(readOnly = true)
    Teacher findByEmail (String email);
}
