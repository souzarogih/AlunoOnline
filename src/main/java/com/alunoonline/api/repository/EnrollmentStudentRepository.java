package com.alunoonline.api.repository;

import com.alunoonline.api.enums.StudentStatus;
import com.alunoonline.api.model.EnrollmentStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EnrollmentStudentRepository extends JpaRepository<EnrollmentStudent, Long> {

    @Query(value = "select * from enrollmentstudent where status = 'MATRICULADO' and student = :id", nativeQuery = true)
    List<EnrollmentStudent> findEnrollmentStudentByStudentIdAndStatusAprovado(@Param("id") Long id);
}
