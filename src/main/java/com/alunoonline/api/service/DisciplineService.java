package com.alunoonline.api.service;

import com.alunoonline.api.model.Discipline;
import com.alunoonline.api.repository.DisciplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplineService {

    @Autowired
    DisciplineRepository disciplineRepository;

    public Discipline createDiscipline(Discipline discipline){
        return disciplineRepository.save(discipline);
    }

    public List<Discipline> listAllDisciplines(){
        return disciplineRepository.findAll();
    }

    public List<Discipline> findDisciplinesByTeacherId(Long id) {
        List<Discipline> discipline = disciplineRepository.findByTeacherId(id);
        return discipline;
    }

}
