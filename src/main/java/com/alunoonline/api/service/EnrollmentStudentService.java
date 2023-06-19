package com.alunoonline.api.service;

import com.alunoonline.api.enums.StudentStatus;
import com.alunoonline.api.model.Discipline;
import com.alunoonline.api.model.StudentEnrollment;
import com.alunoonline.api.repository.StudentEnrollmentRepository;
import com.alunoonline.api.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentEnrollmentService {

    @Autowired
    StudentEnrollmentRepository studentEnrollmentRepository;

    public StudentEnrollment createStudentEnrollment(StudentEnrollment studentEnrollment){
        studentEnrollment.setStatus(StudentStatus.MATRICULADO);
        return studentEnrollmentRepository.save(studentEnrollment);
    }
}
