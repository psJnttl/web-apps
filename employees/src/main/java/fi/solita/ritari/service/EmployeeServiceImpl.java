package fi.solita.ritari.service;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import fi.solita.ritari.command.AddEmployeeCommand;
import fi.solita.ritari.dao.EmployeeRepository;
import fi.solita.ritari.dto.EmployeeAdminDto;
import fi.solita.ritari.model.Employee;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@PersistenceContext
	private EntityManager entityManager;

	@PostConstruct
	private void init() {

	}

	public void addEmployee(AddEmployeeCommand employee) {
		Employee newEmployee = new Employee.Builder().firstName(employee.getFirstName())
				.familyName(employee.getFamilyName()).city(employee.getCity()).employer(employee.getEmployer())
				.salary(employee.getSalary()).title(employee.getTitle()).build();
		employeeRepository.save(newEmployee);
	}

	public List<EmployeeAdminDto> listAllEmployees() {
		List<Object []> employees = entityManager.createNativeQuery("SELECT em.id,em.first_name,em.family_name,em.city,em.employer,em.title,em.salary FROM employee em, employer er WHERE em.employer = er.name")
				.getResultList();
		return employees.stream()
		         .map( (row) -> new EmployeeAdminDto.Builder()
				     .id(((BigInteger)row[0]).longValue())
				     .firstName( (String)row[1] )
				     .familyName( (String)row[2] )
				     .city((String)row[3])
				     .employer((String)row[4])
				     .title((String)row[5])
				     .salary((double)row[6])
				     .build() )
		         .collect(Collectors.toList());
	}

	public void deleteEmployee(long id) {
		employeeRepository.delete(id);
	}

	public void modifyEmployee(Long id, AddEmployeeCommand newEmployee) {

		Employee employee = employeeRepository.findOne(id);
		employee.update(newEmployee);
	}

	public List<EmployeeAdminDto> searchCity(String city) {
		List<Employee> employeeList = employeeRepository.findByCityIgnoreCase(city);
		return mapModelToDto(employeeList);
	}

	public List<EmployeeAdminDto> searchCompany(String company) {
		List<Employee> employeeList = employeeRepository.findByEmployerIgnoreCase(company);
		return mapModelToDto(employeeList);
	}

	private List<EmployeeAdminDto> mapModelToDto(List<Employee> sourceModel) {
		return sourceModel.stream()
				.map((e) -> new EmployeeAdminDto.Builder()
						.id(e.getId())
						.firstName(e.getFirstName())
						.familyName(e.getFamilyName())
						.city(e.getCity())
						.employer(e.getEmployer())
						.salary(e.getSalary())
						.title(e.getTitle())
						.build())
				.collect(Collectors.toList());
	}

    @Override
    public EmployeeAdminDto getEmployee(long id) {
        List<Object []> employees = entityManager.createNativeQuery("SELECT em.id,em.first_name,em.family_name,em.city,em.employer,em.title,em.salary FROM employee em WHERE em.id = " + id)
                .getResultList();
        List <EmployeeAdminDto> resultList = employees.stream()
                .map( (row) -> new EmployeeAdminDto.Builder()
                    .id(((BigInteger)row[0]).longValue())
                    .firstName( (String)row[1] )
                    .familyName( (String)row[2] )
                    .city((String)row[3])
                    .employer((String)row[4])
                    .title((String)row[5])
                    .salary((double)row[6])
                    .build() )
                .collect(Collectors.toList());
        return resultList.get(0);
    }
}
