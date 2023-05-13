package com.example.mongodbrestapi.service;

import com.example.mongodbrestapi.entity.Employee;
import com.example.mongodbrestapi.entity.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    /**
     * Save employee into DB
     *
     * @param employeeDTO Employee
     * @return Saved Employee
     */
    Employee saveEmployee(EmployeeDTO employeeDTO);

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
     * @param employeeDTO Employee to update
     * @return Updated employee
     */
    Employee updateEmployee(EmployeeDTO employeeDTO);

    /**
     * Remove employee from DB
     *
     * @param id Employee ID
     */
    void deleteEmployee(Long id);
}
