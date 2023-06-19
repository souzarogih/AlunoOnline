package com.alunoonline.api.service;

import com.alunoonline.api.model.Student;
import com.alunoonline.api.model.Teacher;
import com.alunoonline.api.repository.StudentRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;
    public Student create(Student student){
        log.warn("StudentService.create | Realizando a criação de um aluno.");
        return studentRepository.save(student);
    }

    public List<Student> listAll() {
        log.warn("StudentService.listAll | Listando todos os alunos existente na base de dados.");
        return studentRepository.findAll();
    }

    public Student findById(Long id) {
        log.warn("StudentService.findById | Listando um aluno pelo ID.");
        Student student_obj = studentRepository.findById(id).orElse(null);
        return student_obj;
    }

    public Student findByName(String name) {
        log.warn("StudentService.findByName | Listando um aluno pelo nome.");
        Student student_obj = studentRepository.findByName(name);
        return student_obj;
    }

    public Student findByEmail(String email) {
        log.warn("StudentService.findByEmail | Listando um aluno pelo e-mail.");
        Student student_obj = studentRepository.findByEmail(email);
        return student_obj;
    }

    public void deleteById (Long id) {
        log.warn("StudentService.deleteById | Removendo um aluno cadastrado na base de dados.");
        studentRepository.deleteById(id);
    }
}
