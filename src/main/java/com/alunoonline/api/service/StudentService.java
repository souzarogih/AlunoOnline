package com.alunoonline.api.service;

import com.alunoonline.api.model.Student;
import com.alunoonline.api.model.dtos.StudentDTO;
import com.alunoonline.api.model.dtos.StudentNameCourseDto;
import com.alunoonline.api.repository.StudentRepository;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log4j2
@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    ModelMapper modelMapper;

    public StudentDTO create(StudentDTO studentDTO){
        log.warn("StudentService.create | Realizando a criação de um aluno.");
        Student student = modelMapper.map(studentDTO, Student.class);
        student = studentRepository.save(student);
        studentDTO = modelMapper.map(student, StudentDTO.class);
        return studentDTO;
    }

    public List<Student> listAll() {
        log.warn("StudentService.listAll | Listando todos os alunos existente na base de dados.");
        return studentRepository.findAll();
    }

    public Page<Student> listAllPag(int page, int size) {
        log.warn("StudentService.listAllPag | Listando alunos com pagina");
        Pageable pageable = PageRequest.of(page, size);
        return studentRepository.findAll(pageable);
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

    public StudentNameCourseDto buscarPorId(Long id) {
        log.debug("Service que localiza um aluno por id. {}", id);
        StudentNameCourseDto studentNameCourseDto = modelMapper.map(this.findById(id), StudentNameCourseDto.class);
        return studentNameCourseDto;
    }

    public Student findByNomeAndEmail(String name, String email) {
        log.warn("StudentService.findByName | Listando um aluno pelo nome.");
        Student student_obj = studentRepository.findStudentByNameAndEmail2(name, email);
        return student_obj;
    }

    public Student findByEmail(String email) {
        log.warn("StudentService.findByEmail | Listando um aluno pelo e-mail.");
        Student student_obj = studentRepository.findByEmail(email);
        return student_obj;
    }

    public List<Student> findByContemEmail(String email) {
        log.warn("StudentService.findByEmail | Localizando e-mail com [{}].", email);
//        List<Student> student_obj = studentRepository.buscarAlunoPorEmailLike(email);
        List<Student> student_obj = studentRepository.buscarAlunoPorEmailLikeNative(email);
        return student_obj;
    }

    public void deleteById (Long id) {
        log.warn("StudentService.deleteById | Removendo um aluno cadastrado na base de dados.");
        studentRepository.deleteById(id);
    }
}
