package com.alunoonline.api.service;

import com.alunoonline.api.enums.StudentStatus;
import com.alunoonline.api.model.EnrollmentStudent;
import com.alunoonline.api.model.Student;
import com.alunoonline.api.repository.EnrollmentStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentStudentService {

    @Autowired
    EnrollmentStudentRepository studentEnrollmentRepository;

    public EnrollmentStudent createStudentEnrollment(EnrollmentStudent studentEnrollment){
        studentEnrollment.setStatus(StudentStatus.MATRICULADO);
        return studentEnrollmentRepository.save(studentEnrollment);
    }

    public List<EnrollmentStudent> listAllStudentEnrollment() {
        return studentEnrollmentRepository.findAll();
    }

    public EnrollmentStudent findByIdStudentEnrollment(Long id) {
        EnrollmentStudent enrollment_student_obj = studentEnrollmentRepository.findById(id).orElse(null);
        return enrollment_student_obj;
    }
}
