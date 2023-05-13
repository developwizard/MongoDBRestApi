package com.example.mongodbrestapi.service.impl;

import com.example.mongodbrestapi.entity.Employee;
import com.example.mongodbrestapi.entity.EmployeeDTO;
import com.example.mongodbrestapi.exception.ResourceNotFoundException;
import com.example.mongodbrestapi.repository.EmployeeRepository;
import com.example.mongodbrestapi.service.EmployeeService;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(EmployeeDTO employeeDTO) {
        val employee = new Employee();
        employee.setId(0);
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setEmailId(employeeDTO.getEmailId());
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "ID", id));
    }

    @Override
    public Employee updateEmployee(EmployeeDTO employeeDTO) {
        val employeeFromDB = employeeRepository.findById(employeeDTO.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "ID", employeeDTO.getId()));
        employeeFromDB.setFirstName(employeeDTO.getFirstName());
        employeeFromDB.setLastName(employeeDTO.getLastName());
        employeeFromDB.setEmailId(employeeDTO.getEmailId());
        return employeeRepository.save(employeeFromDB);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
