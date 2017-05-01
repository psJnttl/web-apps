  package fi.solita.ritari.dto;

public class CompanyAvgSalaryDto {

	private final String employer;
	private final double averageSalary;

	public String getEmployer() {
		return employer;
	}

	public double getAverageSalary() {
		return averageSalary;
	}

	public static class Builder {
		private String employer = "Jankon betoni";
		private double averageSalary = 888.99;

		public Builder employer(String employer) {
			this.employer = employer;
			return this;
		}

		public Builder averageSalary(double averageSalary) {
			this.averageSalary = averageSalary;
			return this;
		}

		public CompanyAvgSalaryDto build() {
			return new CompanyAvgSalaryDto(this);
		}
	}

	private CompanyAvgSalaryDto(Builder builder) {
		this.employer = builder.employer;
		this.averageSalary = builder.averageSalary;
	}
}
