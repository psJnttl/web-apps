package fi.solita.ritari.dto;

public final class EmployeeAdminDto {
	private final long id;
	private final String firstName;
	private final String familyName;
	private final String city;
	private final String employer;
	private final double salary;
	private final String title;

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
    public boolean equals(EmployeeAdminDto other) {
    	boolean status = true;
    	if (! this.firstName.equals(other.getFirstName())) {
    		return false;
    	}
    	if (! this.familyName.equals(other.getFamilyName())) {
    		return false;
    	}
    	if (! this.city.equals(other.getCity())) {
    		return false;
    	}
    	if (! this.employer.equals(other.getEmployer())) {
    		return false;
    	}
    	if (! this.title.equals(other.getTitle())) {
    		return false;
    	}
    	if (this.id != other.getId()) {
    		return false;
    	}
    	return status;
    }
	public static class Builder {
		private long id;
		private String firstName;
		private String familyName;
		private String city;
		private String employer;
		private double salary;
		private String title;

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

		public EmployeeAdminDto build() {
			return new EmployeeAdminDto(this);
		}
	}

	private EmployeeAdminDto(Builder builder) {
		this.id = builder.id;
		this.firstName = builder.firstName;
		this.familyName = builder.familyName;
		this.city = builder.city;
		this.employer = builder.employer;
		this.salary = builder.salary;
		this.title = builder.title;
	}
}
