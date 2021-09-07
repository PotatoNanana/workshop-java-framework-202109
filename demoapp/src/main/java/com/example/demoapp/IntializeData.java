package com.example.demoapp;

import com.example.demoapp.employees.Employee;
import com.example.demoapp.employees.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class IntializeData {
    @Autowired
    private EmployeeRepository employeeRepository;

    //    @PostConstruct
    public void xxxx() {
        Employee employee = new Employee();
        employee.setId(1000);
        employee.setName("Somkiat");
        employeeRepository.save(employee);
    }

}
