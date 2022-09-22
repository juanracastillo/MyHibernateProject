package com.allinone.myproject.northwind.queries;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.allinone.myproject.hibernate.HibernateUtils;
import com.allinone.myproject.northwind.entity.Employees;

public class EmployeesHQL {

	public void showEmployees() {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.getTransaction().begin();
			@SuppressWarnings("unchecked")
			List<Employees> result = session.createQuery("from " + Employees.class.getName()).list();
			for (Employees emp : (List<Employees>) result) {
				System.out.println("Emp " + emp.getId() + ": " + emp.getFirstName() + " " + emp.getLastName());
			}
			session.close();
			return;
		} catch (Exception e) {
			e.printStackTrace();
			session.close();
		}
	}

	public void checkEmployee() {
		return;
	}

	public void addEmployee() {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();
		Employees employee = new Employees();

		try {
			Scanner sc = new Scanner(System.in);
			System.out.print("Nombre: ");
			employee.setFirstName(sc.nextLine());
			System.out.print("Apellido: ");
			employee.setLastName(sc.nextLine());
			session.getTransaction().begin();
			session.save(employee);
			session.persist(employee);
			session.getTransaction().commit();
			session.close();
			sc.close();
			return;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
			session.close();
			System.exit(-1);
		}
	}

	public void editEmployee() {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();
		Employees employee = new Employees();

		try {
			Scanner sc = new Scanner(System.in);
			System.out.print("Nombre actual: ");
			employee.setFirstName(sc.nextLine());
			System.out.print("Apellido actual: ");
			employee.setLastName(sc.nextLine());
			session.getTransaction().begin();
			session.save(employee);
			session.evict(employee);

			System.out.print("Nombre nuevo: ");
			employee.setFirstName(sc.nextLine());
			System.out.print("Apellido nuevo: ");
			employee.setLastName(sc.nextLine());
			session.merge(employee);
			session.getTransaction().commit();
			session.close();
			sc.close();
			return;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
			session.close();
			System.exit(-1);
		}
	}

	public void deleteEmployee() {
		return;
	}

}
