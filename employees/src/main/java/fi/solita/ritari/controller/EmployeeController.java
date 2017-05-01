package fi.solita.ritari.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fi.solita.ritari.command.AddEmployeeCommand;
import fi.solita.ritari.dto.EmployeeAdminDto;
import fi.solita.ritari.service.EmployeeService;

@RestController
@RequestMapping(value="/api")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	
	@GetMapping(value="/employee/list")
	public List<EmployeeAdminDto> listAllEmployees() {
		return employeeService.listAllEmployees();
	}
	@GetMapping(value="/employee/{id}")
	public EmployeeAdminDto getEmployee(@PathVariable long id) {
	    return employeeService.getEmployee(id);   
	}

	@PostMapping(value="/employee")
	public void addEmployee(@RequestBody AddEmployeeCommand newEmployee) {
		employeeService.addEmployee(newEmployee);
	}
	
	@DeleteMapping(value="/employee/{id}")
	public void deleteEmployee(@PathVariable long id) {
		employeeService.deleteEmployee(id);
	}

	@PutMapping(value="/employee/{id}")
	public void modifyEmployee(@PathVariable long id, @RequestBody AddEmployeeCommand modifiedEmployee) {
		employeeService.modifyEmployee(id, modifiedEmployee);
	}
}
