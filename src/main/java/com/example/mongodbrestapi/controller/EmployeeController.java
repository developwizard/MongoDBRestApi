package com.example.mongodbrestapi.controller;

import com.example.mongodbrestapi.entity.Employee;
import com.example.mongodbrestapi.entity.EmployeeDTO;
import com.example.mongodbrestapi.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * Create new employee
     *
     * @param employeeDTO Employee to save
     * @return Employee
     */
    @PostMapping
    public Employee createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.saveEmployee(employeeDTO);
    }

    /**
     * Get all employees
     *
     * @return Employee list
     */
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    /**
     * Find employee by id
     *
     * @param id Employee ID
     * @return Employee
     */
    @GetMapping("{id}")
    public Employee findEmployeeById(@PathVariable Long id) {
        return employeeService.findEmployeeById(id);
    }

    /**
     * Update employee
     *
     * @param employeeDTO Employee to update
     * @return Updated employee
     */
    @PutMapping
    public Employee updateEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.updateEmployee(employeeDTO);
    }

    /**
     * Delete employee by ID
     *
     * @param id Employee ID
     */
    @DeleteMapping("{id}")
    public void deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
    }
}
