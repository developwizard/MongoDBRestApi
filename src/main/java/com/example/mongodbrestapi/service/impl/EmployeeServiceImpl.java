package com.example.mongodbrestapi.service.impl;

import com.example.mongodbrestapi.entity.Employee;
import com.example.mongodbrestapi.repository.EmployeeRepository;
import com.example.mongodbrestapi.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        employee.setId(0);
        return employeeRepository.save(employee);
    }
}
