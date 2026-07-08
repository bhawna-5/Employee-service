package com.bhawna.employeeservice.controller;

import com.bhawna.employeeservice.dto.EmployeeRequestDTO;
import com.bhawna.employeeservice.dto.EmployeeResponseDTO;
import com.bhawna.employeeservice.service.EmployeeService;
import com.bhawna.employeeservice.service.impl.EmployeeServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/create")
    public EmployeeResponseDTO createEmployee(@Valid @RequestBody EmployeeRequestDTO employeeRequestDTO) {
        return employeeService.createEmployee(employeeRequestDTO);
    }
    public
}
