package com.bhawna.employeeservice.controller;

import com.bhawna.employeeservice.dto.EmployeeRequestDTO;
import com.bhawna.employeeservice.dto.EmployeeResponseDTO;
import com.bhawna.employeeservice.response.ApiResponse;
import com.bhawna.employeeservice.service.EmployeeService;
import com.bhawna.employeeservice.service.impl.EmployeeServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/create")
    public ApiResponse<EmployeeResponseDTO> createEmployee(@Valid @RequestBody EmployeeRequestDTO employeeRequestDTO) {
        return new ApiResponse<>(true, "Employee created successfully", employeeService.createEmployee(employeeRequestDTO));
    }

    @GetMapping("/{id}")
    public ApiResponse<EmployeeResponseDTO> getEmployeeById(@PathVariable Long id) {
        return new ApiResponse<>(true,"",employeeService.getEmployeeById(id));
    }
}
