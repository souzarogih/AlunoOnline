package com.alunoonline.api.service;

import com.alunoonline.api.model.Student;
import com.alunoonline.api.model.Teacher;
import com.alunoonline.api.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    TeacherRepository teacherRepository;

    public Teacher create(Teacher teacher){
        return teacherRepository.save(teacher);
    }
    public List<Teacher> listAll() {
        return teacherRepository.findAll();
    }

    public Teacher findById(Long id) {
        Teacher teacher_obj = teacherRepository.findById(id).orElse(null);
        return teacher_obj;
    }

    public Teacher findByName(String name) {
        Teacher teacher_obj = teacherRepository.findByName(name);
        return teacher_obj;
    }

    public Teacher findByEmail(String email) {
        Teacher teacher_obj = teacherRepository.findByEmail(email);
        return teacher_obj;
    }
}
