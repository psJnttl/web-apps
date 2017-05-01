package fi.solita.ritari.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fi.solita.ritari.model.Employer;

public interface EmployerRepository extends JpaRepository<Employer, Long> {

}
