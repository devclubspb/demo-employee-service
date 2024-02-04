package io.github.devclubspb.employee.repository;

import io.github.devclubspb.employee.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

    @Query("from EmployeeEntity order by name")
    List<EmployeeEntity> findAllSortedByName();

}
