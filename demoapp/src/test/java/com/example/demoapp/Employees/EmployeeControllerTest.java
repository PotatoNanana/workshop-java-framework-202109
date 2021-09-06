package com.example.demoapp.Employees;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EmployeeControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void listEmployee() {
        EmployeeResponse[] result = restTemplate.getForObject("/employees",EmployeeResponse[].class);

        // Assert
        assertEquals(2,result.length);
        assertEquals(1,result[0].getId());
        assertEquals("Napat01",result[0].getName());
    }

    @Test
    public void getEmployeeById(){
        //Arrange
        int id = 100;

        // Act
        EmployeeResponse result = restTemplate.getForObject("/employees/"+id,EmployeeResponse.class);

        // Assert
        assertEquals(id,result.getId());
        assertEquals("Napat",result.getName());
    }
}