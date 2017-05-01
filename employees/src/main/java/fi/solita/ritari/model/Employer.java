package fi.solita.ritari.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import fi.solita.ritari.command.AddEmployerCommand;

@Entity
public class Employer {
	@Id
	@SequenceGenerator(name = "employerseq", sequenceName = "employer_id_seq")
	@GeneratedValue(generator = "employerseq", strategy = GenerationType.SEQUENCE)
	private long id;

	@Column
	private String name;
	@Column
	private String yCode;

	public Employer() {
	}
	public String getName() {
		return name;
	}
	public String getyCode() {
		return yCode;
	}
	public void update(AddEmployerCommand employer) {
    	name = employer.getName();
    	yCode = employer.getyCode();
    }
	public static class Builder {
		private long id;
		private String name;
		private String yCode;

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

		public Employer build() {
			return new Employer(this);
		}
	}

	private Employer(Builder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.yCode = builder.yCode;
	}
}
