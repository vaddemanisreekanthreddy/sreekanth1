package org.jsp.springhibernatedemo.controller;

import java.util.List;
import java.util.Scanner;

import org.jsp.springhibernatedemo.dao.EmployeeDao;
import org.jsp.springhibernatedemo.dto.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeController {
	static EmployeeDao dao;
	static Scanner s = new Scanner(System.in);
	static {
		ApplicationContext context = new ClassPathXmlApplicationContext("hibernate-template.xml");
		System.out.println(context);
//		Resource r =new ClassPathResource("hibernate-template.xml");
//		BeanFactory f=new XmlBeanFactory(r);
//		System.out.println(f);
		dao = context.getBean(EmployeeDao.class);
	}

	public static void main(String[] args) {
		System.out.println("1.Save Employee");
		System.out.println("2.Update Employee");
		System.out.println("3.Find Employee By Id");
		System.out.println("4.Delete Employee by Id");
		System.out.println("5.Find all Employee");
		System.out.println("ENTER YOUR CHOICE");
		int choice = s.nextInt();
		switch (choice) {
		case 1: {
			save();
			break;
		}
		case 2: {
			updateEmployee();
			break;

		}
		case 3: {
			findEmployeeById();
			break;

		}
		case 4: {
			deleteEmployee();
			break;

		}
		case 5: {
			findAlltheEmployees();
			break;

		}

		}

	}

	private static void findAlltheEmployees() {
		List<Employee> emp = dao.FindAllEmployee();
		if (emp != null) {
			for (Employee e : emp) {
				System.out.println(e);
			}
		} else {
			System.out.println("Data is Not present");
		}
	}

	private static void updateEmployee() {
		System.out.println("Enter Employee id");
		int id = s.nextInt();
		Employee e = dao.findEmployeeById(id);
		System.out.println("Enter Name ,Desgnation and Salary");
		String name = s.next();
		String desg = s.next();
		int salary = s.nextInt();
		e.setName(name);
		e.setSalary(salary);
		e.setDesg(desg);
		Employee e1 = dao.updateEmployee(e);
		System.out.println(e1);
		System.err.println("Employee updated successfully at id : " + e.getId());
	}

	private static void save() {
		System.out.println("Enter Name ,Desgnation and Salary");
		String name = s.next();
		String desg = s.next();
		int salary = s.nextInt();
		Employee e = new Employee();
		e.setName(name);
		e.setSalary(salary);
		e.setDesg(desg);
		Employee e1 = dao.saveEmployee(e);
		System.out.println(e1);
	}

	private static Employee findEmployeeById() {
		System.out.println("Enter User id");
		int id = s.nextInt();
		Employee e = dao.findEmployeeById(id);
		if (e != null) {
			System.out.println(e);
		}
		return null;

	}

	private static void deleteEmployee() {
		System.out.println("Enter Employee id");
		int id = s.nextInt();
		boolean u = dao.deleteEmployee(id);
		if (u)
			System.out.println("Employee Deleted Succefully");
		else
			System.out.println("You Entered Invalid Id or Employee is Not Present");
	}

}
