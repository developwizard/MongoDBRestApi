package com.example.mongodbrestapi.service;

import com.example.mongodbrestapi.entity.Employee;

import java.util.List;

public interface EmployeeService {
    /**
     * Save employee into DB
     *
     * @param employee Employee
     * @return Saved Employee
     */
    Employee saveEmployee(Employee employee);

    /**
     * Retrieves all employees from DB
     *
     * @return Employee list
     */
    List<Employee> getAllEmployees();

    /**
     * Retrieve employee by ID from DB
     *
     * @param id Employee ID
     * @return Employee
     */
    Employee findEmployeeById(Long id);

    /**
     * Update employee in DB
     *
     * @param employee Employee to update
     * @return Updated employee
     */
    Employee updateEmployee(Employee employee);
}
