package fi.solita.ritari.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fi.solita.ritari.dto.EmployeeAdminDto;
import fi.solita.ritari.service.EmployeeService;

@RestController
@RequestMapping(value="/api/search")
public class EmployeeSearchController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping(value="/city/{city}")
	public List<EmployeeAdminDto> searchEmployeesPerCity(@PathVariable String city) {
		return employeeService.searchCity(city);
	}
	
	@GetMapping(value="/company/{company}")
    public List<EmployeeAdminDto> searchEmployeesPerCompany(@PathVariable String company) {
		return employeeService.searchCompany(company);
	}
	

}
