package com.alunoonline.api.repository;

import com.alunoonline.api.model.EnrollmentStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EnrollmentStudentRepository extends JpaRepository<EnrollmentStudent, Long> {

    List<EnrollmentStudent> findByStudentId(Long id);
}
