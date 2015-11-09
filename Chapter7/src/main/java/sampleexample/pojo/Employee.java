package sampleexample.pojo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
@Table(name = "EMP", 
	   //uniqueConstraints = { @UniqueConstraint(columnNames = {"COLUMN_NAME"}) }, 
	   indexes = {@Index(name = "DEPT_NON_UNIQUE_INDEX", columnList = "DEPTNO", unique=false)})
public class Employee implements Serializable{

	@Id
    /*@GenericGenerator(
    		name = "idTable", 
    		strategy = "enhanced-table", 
    		parameters = {
    				@Parameter(name="table", value="ID_TABLE"),
		            @Parameter(name="primary_key_column", value="key"),
		            @Parameter(name="primary_key_value", value="emp"),
		            @Parameter(name="value_column", value="next"),
		            @Parameter(name="max_lo", value="0")
    				}
    		)
    */  // You can implement you own strategy and mention strategy="com.kaseya.MyStrategy"
		// This is hibernate specific
	
	@TableGenerator(
		    name="idTable",
		    table="ID_TABLE",
		    pkColumnName="key",
		    pkColumnValue="emp",
		    valueColumnName="next",
		    allocationSize=1  // default is 50
		)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "idTable")
	@Column(name = "EMPNO")
	private Integer empId;

	@NotNull
	@Column(name = "ENAME", unique = false, nullable = false)
	private String eName;
	
	@Column(name = "JOB", unique = false, nullable = false)
	private String job;
	
	@Column(name = "MGR", nullable = true)
	private Integer mgrId;
	
	@Column(name = "HIREDATE")
	//@DateTimeFormat(pattern="dd/MM/yyyy") // Doesn't work properly. need to look on spare time
	// @Type(type = "date") // for java util Date
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime") // for joda datetime
	private DateTime hireDate;
	
	@Column(name = "SAL") //If name property name is same as column name no need to specify here
	private Float sal;
	
	@Column(name = "COMM")
	private Float commision;
	
	@ManyToOne(targetEntity = Department.class, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name="DEPTNO", foreignKey = @ForeignKey(name = "FK_DEPTNO"))  // if foreign key name is not mentioned, then random named key will get created if the hbm.2ddl is auto
	private Department deptObj;

	@Override
	public String toString() {
		return this.empId + ", " + this.eName + ", " + this.job + ", " + hireDate;
	}
	
	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Integer getMgrId() {
		return mgrId;
	}

	public void setMgrId(Integer mgrId) {
		this.mgrId = mgrId;
	}

	public DateTime getHireDate() {
		return hireDate;
	}

	public void setHireDate(DateTime hireDate) {
		this.hireDate = hireDate;
	}

	public Float getSal() {
		return sal;
	}

	public void setSal(Float sal) {
		this.sal = sal;
	}

	public Float getCommision() {
		return commision;
	}

	public void setCommision(Float commision) {
		this.commision = commision;
	}

	public Department getDepartment() {
		return deptObj;
	}

	public void setDepartment(Department dept) {
		this.deptObj = dept;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this.empId .equals(((Employee) o).empId))
			return true;
		else 
			return false;
	}
	
	@Override
	public int hashCode()
	{
		return 1;
	}
}