package com.demo.myapp.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import com.demo.myapp.db.pojo.Contact;

@XmlRootElement(name = "contact")
//@XmlType(propOrder = { "firstName", "lastName", "desc", "birthDate" })
@XmlAccessorType(XmlAccessType.PROPERTY)
public class ContactModel {
	private int id;
	private String firstName;
	private String lastName;
	private int version;
	private String birthDate;
	private String description;
	
	public ContactModel(Contact c)
	{
		this.id = c.getId();
		this.firstName = c.getFirstName();
		this.lastName = c.getLastName();
		this.version = c.getVersion();
		this.birthDate = c.getBirthDateString();
		this.description = c.getDescription();
	}
	
	@XmlAttribute
	public int getId() {
		return id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	@XmlTransient
	public int getVersion() {
		return version;
	}
	
	public String getBirthDate() {
		return birthDate;
	}
	
	@XmlElement(name = "desc")
	public String getDescription() {
		return description;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
