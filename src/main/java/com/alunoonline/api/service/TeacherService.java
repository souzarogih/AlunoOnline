package com.alunoonline.api.service;

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
}
