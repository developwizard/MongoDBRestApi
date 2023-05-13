package com.example.mongodbrestapi.service;

import com.example.mongodbrestapi.entity.Employee;

public interface EmployeeService {
    /**
     * Save employee into DB
     *
     * @param employee Employee
     * @return Saved Employee
     */
    Employee saveEmployee(Employee employee);
}
