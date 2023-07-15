package com.alunoonline.api.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class EnrollmentStudentTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testEndpoint() {
        // Envie uma requisição GET para o endpoint desejado
        ResponseEntity<String> response = restTemplate.getForEntity("/enrollment_student/{id}", String.class);

        // Verifique o código de status da resposta
        assertEquals(HttpStatus.OK, response.getStatusCode());

        // Verifique o conteúdo da resposta, se necessário
        assertEquals("Hello, world!", response.getBody());
    }




}
