package fi.solita.ritari.dto;

public class EmployerPersonnelCountDto {
    private final long id;
	private final String name;
	private final String yCode;
	private final long employees;

	public long getId() {
		return id;
	}

	public long getEmployees() {
		return employees;
	}

	public String getName() {
		return name;
	}

	public String getyCode() {
		return yCode;
	}

	public static class Builder {
	    private long id;
		private String name;
		private String yCode;
		private long employees;

		public Builder id(long id) {
			this.id = id;
			return this;
		}

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder yCode(String yCode) {
			this.yCode = yCode;
			return this;
		}

		public Builder employees(long employees) {
			this.employees = employees;
			return this;
		}

		public EmployerPersonnelCountDto build() {
			return new EmployerPersonnelCountDto(this);
		}
	}

	private EmployerPersonnelCountDto(Builder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.yCode = builder.yCode;
		this.employees = builder.employees;
	}
}
