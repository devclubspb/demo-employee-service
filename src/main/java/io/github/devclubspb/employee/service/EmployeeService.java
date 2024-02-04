package io.github.devclubspb.employee.service;

import io.github.devclubspb.employee.domain.Employee;
import io.github.devclubspb.employee.domain.NewEmployee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    Employee createEmployee(NewEmployee newEmployee);

}
