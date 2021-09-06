package com.example.demoapp.Employees;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @GetMapping("/employees/{id}")
    public EmployeeResponse getEmployeeById(@PathVariable String id){
        // Validate input

        // Cleansing data
        EmployeeResponse employee01 = new EmployeeResponse();
        employee01.setId(Integer.parseInt(id));
        employee01.setName("Napat");
        return employee01;
    }

    @GetMapping("/employees")
    public EmployeeResponse[] listEmployee(){
        EmployeeResponse employee01 = new EmployeeResponse();
        employee01.setId(1);
        employee01.setName("Napat01");
        EmployeeResponse employee02 = new EmployeeResponse();
        employee02.setId(2);
        employee02.setName("Napat02");
        return new EmployeeResponse[]{employee01,employee02};
    }
}
