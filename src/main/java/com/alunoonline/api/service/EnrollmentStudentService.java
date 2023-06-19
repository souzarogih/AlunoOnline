package com.alunoonline.api.service;

import com.alunoonline.api.enums.StudentStatus;
import com.alunoonline.api.model.EnrollmentStudent;
import com.alunoonline.api.model.Student;
import com.alunoonline.api.repository.EnrollmentStudentRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class EnrollmentStudentService {

    @Autowired
    EnrollmentStudentRepository studentEnrollmentRepository;

    public EnrollmentStudent createStudentEnrollment(EnrollmentStudent studentEnrollment){
        log.warn("EnrollmentStudentService.createStudentEnrollment - Métodos para matricular um aluno em uma disciplina.");
        studentEnrollment.setStatus(StudentStatus.MATRICULADO);
        return studentEnrollmentRepository.save(studentEnrollment);
    }

    public List<EnrollmentStudent> listAllStudentEnrollment() {
        log.warn("EnrollmentStudentService.listAllStudentEnrollment - Métodos para listar alunos matriculados em uma disciplina.");
        return studentEnrollmentRepository.findAll();
    }

    public EnrollmentStudent findByIdStudentEnrollment(Long id) {
        log.warn("EnrollmentStudentService.findByIdStudentEnrollment - Métodos para localiazr os dados de um alunos matriculado em uma disciplina.");
        EnrollmentStudent enrollment_student_obj = studentEnrollmentRepository.findById(id).orElse(null);
        return enrollment_student_obj;
    }
}
