package io.github.devclubspb.employee.controller;

import io.github.devclubspb.employee.domain.Employee;
import io.github.devclubspb.employee.domain.NewEmployee;
import io.github.devclubspb.employee.payload.EmployeeRequest;
import io.github.devclubspb.employee.payload.EmployeeResponse;
import io.github.devclubspb.employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public EmployeeResponse createEmployee(@RequestBody EmployeeRequest request) {
        NewEmployee newEmployee = NewEmployee.builder()
                .name(request.getName())
                .build();
        Employee createdEmployee = employeeService.createEmployee(newEmployee);
        return mapDomain2Response(createdEmployee);
    }

    @GetMapping
    public List<EmployeeResponse> getEmployees() {
        return employeeService.getAllEmployees().stream()
                .map(this::mapDomain2Response)
                .toList();
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeResponse> getEmployee(@PathVariable Long employeeId) {
        return employeeService.findEmployeeById(employeeId)
                .map(this::mapDomain2Response)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    private EmployeeResponse mapDomain2Response(Employee domain) {
        return EmployeeResponse.builder()
                .id(domain.getId())
                .name(domain.getName())
                .build();
    }

}
