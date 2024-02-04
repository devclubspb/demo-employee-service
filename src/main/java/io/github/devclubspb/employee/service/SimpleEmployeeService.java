package io.github.devclubspb.employee.service;

import io.github.devclubspb.employee.domain.Employee;
import io.github.devclubspb.employee.domain.NewEmployee;
import io.github.devclubspb.employee.entity.EmployeeEntity;
import io.github.devclubspb.employee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class SimpleEmployeeService implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(NewEmployee newEmployee) {
        EmployeeEntity entity = EmployeeEntity.builder()
                .name(newEmployee.getName())
                .build();
        EmployeeEntity savedEntity = employeeRepository.save(entity);
        return mapEntity2Domain(savedEntity);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAllSortedByName().stream()
                .map(this::mapEntity2Domain)
                .toList();
    }

    @Override
    public List<Employee> findEmployeesByIds(Set<Long> ids) {
        return employeeRepository.findAllByIds(ids).stream()
                .map(this::mapEntity2Domain)
                .toList();
    }

    @Override
    public Optional<Employee> findEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId)
                .map(this::mapEntity2Domain);
    }

    private Employee mapEntity2Domain(EmployeeEntity entity) {
        return Employee.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

}
