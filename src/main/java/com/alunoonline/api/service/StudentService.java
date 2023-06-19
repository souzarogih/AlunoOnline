package com.alunoonline.api.service;

import com.alunoonline.api.model.Student;
import com.alunoonline.api.model.Teacher;
import com.alunoonline.api.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;
    public Student create(Student student){
        return studentRepository.save(student);
    }

    public List<Student> listAll() {
        return studentRepository.findAll();
    }

    public Student findById(Long id) {
        Student student_obj = studentRepository.findById(id).orElse(null);
        return student_obj;
    }

    public Student findByName(String name) {
        Student student_obj = studentRepository.findByName(name);
        return student_obj;
    }

    public Student findByEmail(String email) {
        Student student_obj = studentRepository.findByEmail(email);
        return student_obj;
    }

    public void deleteById (Long id) {
        studentRepository.deleteById(id);
    }
}
