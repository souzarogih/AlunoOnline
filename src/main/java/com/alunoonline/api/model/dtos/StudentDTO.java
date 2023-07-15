package com.alunoonline.api.model.dtos;

import lombok.Data;

@Data
public class StudentDTO {

    private Long id;

    private String name;

    private String email;

    private String course;
}
