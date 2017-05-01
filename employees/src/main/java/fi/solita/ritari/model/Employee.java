package fi.solita.ritari.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import fi.solita.ritari.command.AddEmployeeCommand;

@Entity
public class Employee {
	@Id
	@SequenceGenerator(name = "employeeseq", sequenceName = "employee_id_seq")
	@GeneratedValue(generator = "employeeseq", strategy = GenerationType.SEQUENCE)
	private long id;
	@Column
	private String firstName;
	@Column
	private String familyName;
	@Column
	private String city;
	@Column
	private String employer;
	@Column
	private double salary;
	@Column
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

	public long getId() {
		return id;
	}
	public void update(AddEmployeeCommand employee) {
		firstName = employee.getFirstName();
		familyName = employee.getFamilyName();
		city = employee.getCity();
		employer = employee.getEmployer();
		salary = employee.getSalary();
		title = employee.getTitle();
	}

	public String toString() {
		return String.format("Employee[id= %d, name= %s %s, city= %s, company= %s, salary= %f, title= %s]", id,
				firstName, familyName, city, employer, salary, title);
	}

	public static class Builder {
		private long id;
		private String firstName = "Aatami";
		private String familyName = "Aakkula";
		private String city = "Aarresuo";
		private String employer = "Aaltopahvi Oy";
		private double salary = 9999.99;
		private String title = "aaltopahvivastaava";

		public Builder id(long id) {
			this.id = id;
			return this;
		}

		public Builder firstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public Builder familyName(String familyName) {
			this.familyName = familyName;
			return this;
		}

		public Builder city(String city) {
			this.city = city;
			return this;
		}

		public Builder employer(String employer) {
			this.employer = employer;
			return this;
		}

		public Builder salary(double salary) {
			this.salary = salary;
			return this;
		}

		public Builder title(String title) {
			this.title = title;
			return this;
		}

		public Employee build() {
			return new Employee(this);
		}
	}

	private Employee(Builder builder) {
		this.id = builder.id;
		this.firstName = builder.firstName;
		this.familyName = builder.familyName;
		this.city = builder.city;
		this.employer = builder.employer;
		this.salary = builder.salary;
		this.title = builder.title;
	}
	Employee() {}
}
