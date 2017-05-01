package fi.solita.ritari.service;

import java.util.List;

import fi.solita.ritari.command.AddEmployeeCommand;
import fi.solita.ritari.dto.EmployeeAdminDto;


public interface EmployeeService {
		List<EmployeeAdminDto> listAllEmployees();
		public void addEmployee(AddEmployeeCommand employee);
    public void deleteEmployee(long id);
    public void modifyEmployee(Long id, AddEmployeeCommand employee);
		public EmployeeAdminDto getEmployee(long id);
	
		List<EmployeeAdminDto> searchCity(String city);
		List<EmployeeAdminDto> searchCompany(String company);
}
