package fi.solita.ritari.service;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import fi.solita.ritari.command.AddEmployerCommand;
import fi.solita.ritari.dao.EmployerRepository;
import fi.solita.ritari.dto.CompanyAvgSalaryDto;
import fi.solita.ritari.dto.EmployerDto;
import fi.solita.ritari.dto.EmployerPersonnelCountDto;
import fi.solita.ritari.model.Employer;

@Service
@Transactional
public class EmployerServiceImpl implements EmployerService {

	@PersistenceContext
	private EntityManager entityManager;
	
	private EmployerRepository employerRepository;
	public EmployerServiceImpl(EmployerRepository employerRepository) {
		this.employerRepository = employerRepository;
	}

    @Override
    public EmployerDto getEmployer(long id) {
        List<Object[]> sqlResult = entityManager.createNativeQuery("SELECT id, name, y_code FROM employer WHERE id=" + id)
                .getResultList();
        List<EmployerDto> resultList = sqlResult.stream().map( (row) -> new EmployerDto.Builder()
                .id(((BigInteger)row[0]).longValue())
                .name((String)row[1])
                .yCode((String)row[2])
                .build())
                .collect(Collectors.toList());
        return resultList.get(0);
    }
	
	public List<CompanyAvgSalaryDto> averageSalaryPerCompany() {  // getResultList  returns raw list
		List<Object[]> sqlResult = entityManager.createNativeQuery("SELECT employer, AVG(salary) FROM employee em, employer er WHERE em.employer=er.name GROUP BY employer").getResultList();
		return sqlResult.stream().map( (row) -> new CompanyAvgSalaryDto.Builder()
				                      .employer((String)row[0])
				                      .averageSalary((double)row[1])
				                      .build())
				        .collect(Collectors.toList());
	}


	public List<EmployerPersonnelCountDto> employerPersonnelCount() {
		List<Object[]> sqlResult = entityManager.createNativeQuery("SELECT DISTINCT er.id, name,y_code,(SELECT COUNT(*) from employee where employer=er.name) as employees FROM employer er LEFT JOIN employee em on er.name=em.employer")
				.getResultList();
		return sqlResult.stream()
				.map( (row) -> new EmployerPersonnelCountDto.Builder()
						.id(((BigInteger)row[0]).longValue())
						.name((String)row[1])
						.yCode((String)row[2])
						.employees(((BigInteger)row[3]).longValue())
						.build() )
				.collect( Collectors.toList());
	}

	public void addEmployer(AddEmployerCommand newEmployer) {
		Employer employer = new Employer.Builder()
				            .name(newEmployer.getName())
				            .yCode(newEmployer.getyCode())
				            .build();
		employerRepository.save(employer);
	}

	public void deleteEmployer(long id) throws EmployerHasEmployeesException {
		List<EmployerPersonnelCountDto> companies = employerPersonnelCount();
		List<EmployerPersonnelCountDto> hasNoEmployees = companies.stream()
		         .filter(e -> e.getId() == id )
		         .filter(e-> e.getEmployees() == 0)                              // vain ei työllistävät firmat voi deletoida
		         .collect(Collectors.toList());
	    if(hasNoEmployees.isEmpty()) {
	    	throw new EmployerHasEmployeesException("Cannot delete employer that has employees!");
	    }
	    else {
	    	employerRepository.delete(id);
	    }
	}
    
	public void modifyEmployer(long id, AddEmployerCommand modifiedEmployer) {
		Employer employer = employerRepository.findOne(id);
        employer.update(modifiedEmployer);		
	}


}
