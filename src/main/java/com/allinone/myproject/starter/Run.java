package com.allinone.myproject.starter;

import java.util.Scanner;

import com.allinone.myproject.northwind.queries.EmployeesHQL;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.getProperty("java.runtime.version");
		EmployeesHQL employee = new EmployeesHQL();

		try {
			Scanner sc = new Scanner(System.in);
			int key = 0;
			while (key != 6) {
				System.out.println("Elige una opcion: \n");
				System.out.println("1.- Listar empleados");
				System.out.println("2.- Añadir empleado");
				System.out.println("3.- Buscar empleado");
				System.out.println("4.- Editar empleado");
				System.out.println("5.- Borrar empleado");
				System.out.println("6.- Salir \n");

				key = sc.nextInt();
				switch (key) {
				case 1:
					System.out.println("1.- Listar empleados");
					employee.showEmployees();
					break;
				case 2:
					System.out.println("2.- Añadir empleado");
					employee.addEmployee();
					break;
				case 3:
					System.out.println("3.- Buscar empleado");
					employee.checkEmployee();
					break;
				case 4:
					System.out.println("4.- Editar empleado");
					employee.editEmployee();
					break;
				case 5:
					System.out.println("5.- Borrar empleado");
					employee.deleteEmployee();
					break;
				case 6:
					System.out.println("Saliendo...");
					System.exit(0);
					break;
				default:
					System.out.println("Opcion incorrecta. Intentalo de nuevo.");
					break;
				}
				System.out.println("\nPulsa ENTER para volver al menu principal");
				System.in.read();
			}
			sc.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.exit(-1);
		}
	}
}
