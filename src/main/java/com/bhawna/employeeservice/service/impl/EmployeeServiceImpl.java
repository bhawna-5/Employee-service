package com.bhawna.employeeservice.service.impl;

import com.bhawna.employeeservice.dto.EmployeeRequestDTO;
import com.bhawna.employeeservice.dto.EmployeeResponseDTO;
import com.bhawna.employeeservice.entity.Employee;
import com.bhawna.employeeservice.enums.EmployeeStatus;
import com.bhawna.employeeservice.exception.ResourceNotFoundException;
import com.bhawna.employeeservice.repository.EmployeeRepository;
import com.bhawna.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeResponseDTO createEmployee(EmployeeRequestDTO employeeRequestDTO) {
        Employee employee = new Employee();
        employee.setFirstName(employeeRequestDTO.getFirstName());
        employee.setLastName(employeeRequestDTO.getLastName());
        employee.setEmail(employeeRequestDTO.getEmail());
        employee.setDepartment(employeeRequestDTO.getDepartment());
        employee.setDesignation(employeeRequestDTO.getDesignation());
        employee.setSalary(employeeRequestDTO.getSalary());
        employee.setPhone(employeeRequestDTO.getPhone());
        employee.setJoiningDate(employeeRequestDTO.getJoiningDate());
        employee.setStatus(EmployeeStatus.ACTIVE);
        Employee savedEmployee = employeeRepository.save(employee);

        EmployeeResponseDTO employeeResponseDTO = new EmployeeResponseDTO();

        employeeResponseDTO.setId(savedEmployee.getId());
        employeeResponseDTO.setFirstName(savedEmployee.getFirstName());
        employeeResponseDTO.setLastName(savedEmployee.getLastName());
        employeeResponseDTO.setEmail(savedEmployee.getEmail());
        employeeResponseDTO.setDepartment(savedEmployee.getDepartment());
        employeeResponseDTO.setDesignation(savedEmployee.getDesignation());
        employeeResponseDTO.setSalary(savedEmployee.getSalary());
        employeeResponseDTO.setPhone(savedEmployee.getPhone());
        employeeResponseDTO.setJoiningDate(savedEmployee.getJoiningDate());
        employeeResponseDTO.setStatus(savedEmployee.getStatus());
        return employeeResponseDTO;
    }

    @Override
    public EmployeeResponseDTO getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee not found with id: " + id));
        EmployeeResponseDTO response = new EmployeeResponseDTO();
        response.setId(employee.getId());
        response.setFirstName(employee.getFirstName());
        response.setLastName(employee.getLastName());
        response.setEmail(employee.getEmail());
        response.setPhone(employee.getPhone());
        response.setDepartment(employee.getDepartment());
        response.setDesignation(employee.getDesignation());
        response.setSalary(employee.getSalary());
        response.setJoiningDate(employee.getJoiningDate());
        response.setStatus(employee.getStatus());
        return response;
    }

    @Override
    public List<EmployeeResponseDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeResponseDTO> response = new ArrayList<>();
        for (Employee employee : employees) {

            EmployeeResponseDTO dto = new EmployeeResponseDTO();

            dto.setId(employee.getId());
            dto.setFirstName(employee.getFirstName());
            dto.setLastName(employee.getLastName());
            dto.setEmail(employee.getEmail());
            dto.setPhone(employee.getPhone());
            dto.setDepartment(employee.getDepartment());
            dto.setDesignation(employee.getDesignation());
            dto.setSalary(employee.getSalary());
            dto.setJoiningDate(employee.getJoiningDate());
            dto.setStatus(employee.getStatus());

            response.add(dto);
        }

        return response;
    }

    @Override
    public EmployeeResponseDTO updateEmployee(Long id, EmployeeRequestDTO employeeRequestDTO) {

        // Find employee by id
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee not found with id: " + id));

        // Update employee details
        existingEmployee.setFirstName(employeeRequestDTO.getFirstName());
        existingEmployee.setLastName(employeeRequestDTO.getLastName());
        existingEmployee.setEmail(employeeRequestDTO.getEmail());
        existingEmployee.setDepartment(employeeRequestDTO.getDepartment());
        existingEmployee.setDesignation(employeeRequestDTO.getDesignation());
        existingEmployee.setSalary(employeeRequestDTO.getSalary());
        existingEmployee.setPhone(employeeRequestDTO.getPhone());
        existingEmployee.setJoiningDate(employeeRequestDTO.getJoiningDate());

        // Save updated employee
        Employee updatedEmployee = employeeRepository.save(existingEmployee);

        // Convert Entity -> DTO
        EmployeeResponseDTO employeeResponseDTO = new EmployeeResponseDTO();

        employeeResponseDTO.setId(updatedEmployee.getId());
        employeeResponseDTO.setFirstName(updatedEmployee.getFirstName());
        employeeResponseDTO.setLastName(updatedEmployee.getLastName());
        employeeResponseDTO.setEmail(updatedEmployee.getEmail());
        employeeResponseDTO.setPhone(updatedEmployee.getPhone());
        employeeResponseDTO.setDepartment(updatedEmployee.getDepartment());
        employeeResponseDTO.setDesignation(updatedEmployee.getDesignation());
        employeeResponseDTO.setSalary(updatedEmployee.getSalary());
        employeeResponseDTO.setJoiningDate(updatedEmployee.getJoiningDate());
        employeeResponseDTO.setStatus(updatedEmployee.getStatus());

        return employeeResponseDTO;
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee not found with id: " + id));
        existingEmployee.setStatus(EmployeeStatus.INACTIVE);
        employeeRepository.save(existingEmployee);

    }
}
