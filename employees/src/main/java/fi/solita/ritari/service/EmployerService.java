package fi.solita.ritari.service;

import java.util.List;

import fi.solita.ritari.command.AddEmployerCommand;
import fi.solita.ritari.dto.CompanyAvgSalaryDto;
import fi.solita.ritari.dto.EmployerDto;
import fi.solita.ritari.dto.EmployerPersonnelCountDto;

public interface EmployerService {
		public EmployerDto getEmployer(long id);
    public void addEmployer(AddEmployerCommand newEmployer);
		public void deleteEmployer(long id) throws EmployerHasEmployeesException;
    public void modifyEmployer(long id, AddEmployerCommand modifiedEmployer);
		public List<CompanyAvgSalaryDto> averageSalaryPerCompany();
		public List<EmployerPersonnelCountDto> employerPersonnelCount();
}
