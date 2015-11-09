package sampleexample.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="ADDR")
public class Address implements Serializable{
	
	@Id
	@TableGenerator(name="idTable", pkColumnName = "KEY", pkColumnValue = "addr", valueColumnName = "NEXT", allocationSize = 1, table = "ID_TABLE")
	@GeneratedValue(generator="idTable", strategy = GenerationType.TABLE)
	@Column(name = "ADDRNO")
	private Integer addrId;
	
	private String street;
	
	private String country;
	
	private String pincode;

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Department deptObj;

	public Integer getAddrId() {
		return addrId;
	}

	public void setAddrId(Integer addrId) {
		this.addrId = addrId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public Department getDeptObj() {
		return deptObj;
	}

	public void setDeptObj(Department deptObj) {
		this.deptObj = deptObj;
	}
}
