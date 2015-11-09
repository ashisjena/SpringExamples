package versionexample;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Version;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "contact")
public class Contact implements Serializable {
	private Long id;
	private int version;
	private String firstName;
	private String lastName;
	private Date birthDate;

	@Id
	@TableGenerator(name = "idGenerator", table = "ID_TABLE", pkColumnName = "key", pkColumnValue = "contact", valueColumnName = "next", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "idGenerator")
	@Column(name = "ID")
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Version
	@Column(name = "VERSION")
	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Column(name = "FIRST_NAME")
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "LAST_NAME")
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Type(type = "date")
	@Column(name = "BIRTH_DATE")
	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String toString() {
		return "Contact - Id: " + id + ", First name: " + firstName + ", Last name: " + lastName + ", Birthday: "
				+ birthDate;
	}
}