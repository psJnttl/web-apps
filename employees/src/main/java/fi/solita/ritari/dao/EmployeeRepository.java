package fi.solita.ritari.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fi.solita.ritari.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByCityIgnoreCase(String city);
    List<Employee> findByEmployerIgnoreCase(String employer);
    
}
