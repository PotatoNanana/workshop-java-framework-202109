package com.example.demoapp.employees;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EmployeeControllerTest {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private TestRestTemplate restTemplate;

//    @BeforeEach
//    public void initialDataForTest(){
//        // Arrange
//        int id=1;
//
//        // Act
//        Employee employee100=new Employee();
//        employee100.setName("Napat");
//        employeeRepository.save(employee100);
//    }

    @AfterEach
    public void deleteDataForTest(){
        employeeRepository.deleteAll();
    }

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
        int id = 1;
        Employee employee100=new Employee();
        employee100.setName("Napat");
        employeeRepository.save(employee100);

        // Act
        EmployeeResponse result = restTemplate.getForObject("/employees/"+id,EmployeeResponse.class);

        // Assert
        assertEquals(id,result.getId());
        assertEquals("Napat",result.getName());
    }
}