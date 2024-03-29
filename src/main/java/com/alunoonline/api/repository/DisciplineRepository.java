package com.alunoonline.api.repository;

import com.alunoonline.api.model.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DisciplineRepository extends JpaRepository<Discipline, Long> {
    List<Discipline> findByTeacherId(Long teacherId);

//    List<Discipline> findDisciplineByNomeOrderBy(String nome);
}
