package com.alunoonline.api.repository;

import com.alunoonline.api.model.Student;

import com.alunoonline.api.model.EnrollmentStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Transactional(readOnly = true)
    Student findByName(String name);

    @Transactional(readOnly = true)
    Student findByEmail (String email);

    List<Student> findStudentByName(String name);

    List<Student> findStudentByNameAndEmail(String name, String email);

    @Query("select s from Student s where s.name=:nome and s.email=:email")
    Student findStudentByNameAndEmail2(@Param("nome") String nome, @Param("email") String email);

    @Query("select s from Student s where s.email like %:email% ")
    public List<Student> buscarAlunoPorEmailLike(@Param("email") String email);

    @Query(value = "select * from student s where s.email like '%lipe%' ", nativeQuery = true)
    public List<Student> buscarAlunoPorEmailLikeNative(@Param("email") String email);

}