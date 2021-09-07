package com.example.demoapp.employees;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EmployeeControllerServiceTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private EmployeeRepository employeeRepository;

    @Test
    @DisplayName("Success case")
    public void case01(){
        //Arrange
        int id = 1;
        Employee employee=new Employee();
        employee.setId(1);
        employee.setName("Mock name");
        when(employeeRepository.findById(1)).thenReturn(Optional.of(employee));

        // Act
        EmployeeResponse result = restTemplate.getForObject("/employees/"+id,EmployeeResponse.class);

        // Assert
        assertEquals(id,result.getId());
        assertEquals("Mock name",result.getName());
    }

    @Test
    @DisplayName("Failure case :: Employee not found id = 100")
    public void case02(){
        //Arrange
        int id = 100;

        // Act
        ResponseEntity<ErrorResponse> result = restTemplate.getForEntity("/employees/"+id,ErrorResponse.class);

        // Assert
//        assertEquals();
        assertEquals(200,result.getStatusCodeValue());
        assertEquals(404,result.getBody().getCode());
        assertEquals("Employee not found id=100",result.getBody().getDetail());
    }
}