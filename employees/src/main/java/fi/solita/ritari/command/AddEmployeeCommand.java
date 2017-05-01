package fi.solita.ritari.command;

public final class AddEmployeeCommand {
	private String firstName;
	private String familyName;
	private String city;
	private String employer;
	private double salary;
	private String title;

	public String getFirstName() {
		return firstName;
	}
	public String getFamilyName() {
		return familyName;
	}
	public String getCity() {
		return city;
	}
	public String getEmployer() {
		return employer;
	}
	public double getSalary() {
		return salary;
	}
	public String getTitle() {
		return title;
	}
	
}
