package sampleexample;

import java.util.Set;

import org.springframework.context.support.GenericXmlApplicationContext;

import sampleexample.dao.EntityDAO;
import sampleexample.pojo.Address;
import sampleexample.pojo.Department;
import sampleexample.pojo.Employee;

public class Main {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:sampleexample/app-context.xml");
		ctx.refresh();
		EntityDAO<Employee> empDao = ctx.getBean("empDAO", EntityDAO.class);  // When the bean implements an interface always give interface Class while retrieving the bean. otherwise it will throw error
																			// As the implementation will not be EmployeeDAO, rather a proxy
		Employee employee = empDao.get(7369);
		System.out.println(employee);
		System.out.println(employee.getDepartment());
		
		EntityDAO<Department> deptDao = ctx.getBean("deptDAO", EntityDAO.class);
		
		Department dept = deptDao.get(10);
		System.out.println(dept);
		Address address = dept.getAddrObj();
		System.out.println(address);
		Set<Employee> employees = dept.getEmployees();
		System.out.println(employees);
		
		
		/*Employee emp = new Employee();
		emp.seteName("RAMA");
		emp.setJob("CODER");
		emp.setHireDate(new DateTime() );
		emp.setMgrId(7902);
		emp.setSal(5000.00f);
		emp.setCommision(0f);
		emp.setDeptNo(10);
		dao.saveOrUpdate(emp);*/
		
		
		// Below section is for difference testing of CascadeType.All vs  orphanRemoval
		/*DBUtil util = ctx.getBean("dbUtil", DBUtil.class);
		Session sess = util.getSession();
		Transaction transaction = sess.beginTransaction();
		transaction.begin();
		
		Department d = sess.get(Department.class, 10);
		//System.out.println(d.getEmployees());
		
		Employee employee = new Employee();
		employee.setEmpId(7782);
		d.getEmployees().remove(employee);
		//sess.saveOrUpdate(d);
		sess.delete(d);
		transaction.commit();*/
	}
}