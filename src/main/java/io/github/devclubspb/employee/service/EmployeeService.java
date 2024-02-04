package io.github.devclubspb.employee.service;

import io.github.devclubspb.employee.domain.Employee;
import io.github.devclubspb.employee.domain.NewEmployee;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    List<Employee> findEmployeesByIds(Set<Long> ids);

    Employee createEmployee(NewEmployee newEmployee);

    Optional<Employee> findEmployeeById(Long employeeId);

}
