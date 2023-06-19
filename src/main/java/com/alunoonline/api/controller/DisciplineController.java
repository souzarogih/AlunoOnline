package com.alunoonline.api.controller;

import com.alunoonline.api.model.Discipline;
import com.alunoonline.api.model.Student;
import com.alunoonline.api.service.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/discipline")
public class DisciplineController {

    @Autowired
    DisciplineService disciplineService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Discipline> createDiscipline(@RequestBody Discipline discipline) {
        Discipline createDiscipline = disciplineService.createDiscipline(discipline);
        return ResponseEntity.status(201).body(createDiscipline);
    }

    @GetMapping("/list-all")
    @ResponseStatus(HttpStatus.OK)
    public List<Discipline> listAllDisciplines() {
        return disciplineService.listAllDisciplines();
    }

    @GetMapping("/professor/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Discipline>> findById(@PathVariable Long id) {
        List<Discipline> discipline = disciplineService.findDisciplinesByTeacherId(id);
        return ResponseEntity.ok(discipline);
    }
}
