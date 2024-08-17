package org.jsp.springhibernatedemo.dao;

import java.util.List;
import javax.transaction.Transactional;
import org.jsp.springhibernatedemo.dto.Employee;
import org.springframework.orm.hibernate5.HibernateTemplate;

public class EmployeeDao {

	HibernateTemplate template;

	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	@Transactional
	public Employee saveEmployee(Employee e) {
		template.save(e);
		return e;
	}

	@Transactional
	public Employee updateEmployee(Employee e) {
		template.update(e);
		return e;
	}

	public List<Employee> FindAllEmployee() {
		return template.loadAll(Employee.class);
	}

	@Transactional
	public boolean deleteEmployee(int id) {
		Employee e = template.get(Employee.class, id);
		if (e != null) {
			template.delete(e);
			return true;
		}
		return false;
	}

	public Employee findEmployeeById(int id) {
		return template.get(Employee.class, id);
	}

}
