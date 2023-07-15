package com.alunoonline.api.model.dtos;

import com.alunoonline.api.model.Student;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentNameCourseDto {

    private String name;
    private String course;

    public StudentNameCourseDto(@NotNull Student student){
        this.name = student.getName();
        this.course = student.getCourse();
    }
}
