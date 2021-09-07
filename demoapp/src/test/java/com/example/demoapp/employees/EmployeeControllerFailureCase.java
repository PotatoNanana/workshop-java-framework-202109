package com.example.demoapp.employees;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeControllerFailureCase {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @DisplayName("เกิด error 404 เมื่อค้นหา employee id = 1 ไม่เจอ")
    public void case01(){
        // Arrange
        int id =1000;

        // Act
        ResponseEntity<ErrorResponse> result = restTemplate.getForEntity("/emplyees"+id,ErrorResponse.class);

        // Assert
        assertEquals(404,result.getStatusCodeValue());
//        assertEquals("Employee not found id=1",result.getBody().getDetail());
    }

}
