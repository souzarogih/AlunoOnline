package com.alunoonline.api.repository;

import com.alunoonline.api.model.EnrollmentStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentStudentRepository extends JpaRepository<EnrollmentStudent, Long> {
}
