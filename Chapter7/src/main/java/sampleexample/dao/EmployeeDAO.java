package sampleexample.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sampleexample.DBUtil;
import sampleexample.pojo.Employee;

@Repository("empDAO")
@Scope("singleton")
@Lazy(false)
@Transactional(transactionManager = "txManager")  // If you use "transactionManager" as bean name in XML, no need to mention the bean name here.
// Transactional can be used per method wise instead of whole class
public class EmployeeDAO implements EntityDAO<Employee> {

	@Autowired(required = true)
	private DBUtil util = null;

	@SuppressWarnings("unchecked")
	public List<Employee> list() {
		return util.getSession().createQuery("FROM Employee").list();
	}

	@Transactional(value = "txManager", readOnly=true)
	public Employee get(int id) {
		return util.getSession().get(Employee.class, id);
	}

	public void saveOrUpdate(Employee entity) {
		util.getSession().saveOrUpdate(entity);
	}

	public void delete(int id) {
		Employee employee = new Employee();
		employee.setEmpId(id);
		util.getSession().delete(employee);
	}

	public void delete(Employee entity) {
		util.getSession().delete(entity);
	}
}