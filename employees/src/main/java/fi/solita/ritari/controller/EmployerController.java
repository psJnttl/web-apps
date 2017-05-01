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

import fi.solita.ritari.command.AddEmployerCommand;
import fi.solita.ritari.dto.CompanyAvgSalaryDto;
import fi.solita.ritari.dto.EmployerDto;
import fi.solita.ritari.dto.EmployerPersonnelCountDto;
import fi.solita.ritari.service.EmployerHasEmployeesException;
import fi.solita.ritari.service.EmployerService;

@RestController
@RequestMapping(value="/api/employer")
public class EmployerController {

	@Autowired
	private EmployerService employerService;
	
	@GetMapping(value="/averagesalary")
	public List<CompanyAvgSalaryDto> searchAverageSalaryPerEmployer() {
		return employerService.averageSalaryPerCompany();
	}
    @GetMapping(value="/personnelcount")
    public List<EmployerPersonnelCountDto> searchEmployerPersonnelCount() {
		return employerService.employerPersonnelCount();
    	
    }
    @PostMapping(value="/")
    public void addEmployer(@RequestBody AddEmployerCommand newEmployer) {
    	employerService.addEmployer(newEmployer);
    }
    @DeleteMapping(value="/{id}")
    public void deleteEmployer(@PathVariable long id) throws EmployerHasEmployeesException {
    	employerService.deleteEmployer(id);
    }
    @PutMapping(value="/{id}")
    public void modifyEmployer(@PathVariable long id, @RequestBody AddEmployerCommand modifiedEmployer) {
    	employerService.modifyEmployer(id, modifiedEmployer);
    }
    @GetMapping(value="/{id}")
    public EmployerDto getEmployer(@PathVariable long id) {
        return employerService.getEmployer(id);
    }
}
