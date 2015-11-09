package sampleexample.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sampleexample.DBUtil;
import sampleexample.pojo.Department;
import sampleexample.pojo.Employee;

@Repository("deptDAO")
@Scope("singleton")
@Lazy(false)
@Transactional(transactionManager="txManager")  // If you use "transactionManager" as bean name in XML, no need to mention the bean name here.
// Transactional can be used per method wise instead of whole class
public class DeptDAO implements EntityDAO<Department> {

	@Autowired(required = true)
	private DBUtil util = null;

	@SuppressWarnings("unchecked")
	public List<Department> list() {
		return util.getSession().createQuery("FROM Department").list();
	}

	public Department get(int id) {
		return util.getSession().get(Department.class, id);
	}

	public void saveOrUpdate(Department entity) {
		util.getSession().saveOrUpdate(entity);
	}

	public void delete(int id) {
		Department dept = new Department();
		dept.setDeptNo(id);
		util.getSession().delete(dept);
	}
	
	public void delete(Department dept)
	{
		util.getSession().delete(dept);
	}
}