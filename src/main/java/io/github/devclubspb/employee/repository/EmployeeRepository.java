package io.github.devclubspb.employee.repository;

import io.github.devclubspb.employee.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

    @Query("from EmployeeEntity order by name")
    List<EmployeeEntity> findAllSortedByName();

    @Query("from EmployeeEntity where id in(:ids)")
    List<EmployeeEntity> findAllByIds(Set<Long> ids);

}
