package sampleexample.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

@Entity
@Table(name = "DEPT")
public class Department implements Serializable {

	@Id
	@TableGenerator(
			name="idTable",
		    table="ID_TABLE",
		    pkColumnName="key",
		    pkColumnValue="dept",
		    valueColumnName="next"
			)
	@GeneratedValue(generator = "idTable", strategy = GenerationType.TABLE)
	private int deptNo;
	
	private String dName;
	
	private String loc;
	
	@OneToMany(fetch = FetchType.LAZY, targetEntity = Employee.class, mappedBy = "deptObj",orphanRemoval = true) // mappedBy---->Department property name in Employee class
	private Set<Employee> employees = new HashSet<Employee>(0);
	
	@OneToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Address.class, mappedBy = "deptObj")
	//optional = false helps in Lazy loading (it trusts you and doesn't check). if set to true, hibernate fires actual query to verify the relation exists or not to make sure. 
	private Address addrObj;

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public String getdName() {
		return dName;
	}

	public void setdName(String dName) {
		this.dName = dName;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	
	public Address getAddrObj() {
		return addrObj;
	}

	public void setAddrObj(Address addrObj) {
		this.addrObj = addrObj;
	}

	@Override
	public String toString()
	{
		return this.deptNo + ", "  + dName + ", " + loc;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this.deptNo == ((Department) o).deptNo)
			return true;
		else 
			return false;
	}
}
