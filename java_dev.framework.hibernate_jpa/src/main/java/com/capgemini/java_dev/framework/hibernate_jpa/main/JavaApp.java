package com.capgemini.java_dev.framework.hibernate_jpa.main;

import java.util.EmptyStackException;
import java.util.Scanner;

import com.capgemini.java_dev.framework.hibernate_jpa.entity.Employee;
import com.capgemini.java_dev.framework.hibernate_jpa.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JavaApp {
	public static void execution() {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Student");
		EntityManager entityManager  = entityManagerFactory.createEntityManager();
//		System.out.println(entityManager);
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		
		
		//insert
		Student student1 = new Student();
		student1.setId(1);
		student1.setName("Raja");
		student1.setMailId("raja@gmail.com");
		student1.setContactNumber(987654321L);
//		entityManager.persist(student1);
		

		
		Student student2 = new Student();
		student2.setId(2);
		student2.setName("Rani");
		student2.setMailId("rani@gmail.com");
		student2.setContactNumber(9876587488L);
//		entityManager.persist(student2);
		
		Student student3 = new Student();
		student3.setId(3);
		student3.setName("Rocky");
		student3.setMailId("rocky@gmail.com");
		student3.setContactNumber(9124587488L);
//		entityManager.persist(student3);
		
		Student student4 = new Student();
		student4.setId(4);
		student4.setName("Reena");
		student4.setMailId("reena@gmail.com");
		student4.setContactNumber(9875512488L);
//		entityManager.persist(student4);
		
		
		
				
		//read and update
		Student student = entityManager.find(Student.class, 1);
		if(student!=null) {
			System.out.println(student);
			student.setMailId("king@gmail.com");
			student.setContactNumber(9558454452L);
			entityManager.merge(student);
			System.out.println("Student data updated successfully!");
		}
		else {
			System.out.println("Student data not there!");
		}
		
		
		
		//delete
		Student data = entityManager.find(Student.class, 4);
		entityManager.remove(data);
		
		
		entityTransaction.commit();
		
		
		
		
		
		
		System.out.println("Hello World!");
	}
	
	
	
	public static void execution2() {
		Scanner sc = new Scanner(System.in);
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Employee");
		EntityManager entityManager  = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		while (true) {
			
            System.out.println("\n===== Employee Management =====");
            System.out.println("1. Insert Employee");
            System.out.println("2. Read Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");

            System.out.println("Enter choice:");
            int choice = sc.nextInt();

            switch (choice) {

            case 1:
                System.out.println("Enter the numbers of employees: ");
                int n = sc.nextInt();
                entityTransaction.begin();
                for(int i=0;i<n;i++) {
                	Employee emp = new Employee();
                	System.out.println("Enter Employee ID:");
                    emp.setEmpId(sc.nextInt());

                    System.out.println("Enter Employee Name:");
                    emp.setEmpName(sc.next());
                    
                    System.out.println("Enter Email:");
                    emp.setEmpMailId(sc.next());

                    System.out.println("Enter Contact Number:");
                    emp.setEmpContactNumber(sc.nextLong());
                    
                    entityManager.persist(emp);

                    System.out.println("Employee Inserted Successfully\n");
                }
                entityTransaction.commit();
                
                break;

            case 2:
                System.out.println("Enter Employee ID to read: ");
                int id = sc.nextInt();
                Employee emp = entityManager.find(Employee.class, id);
                if (emp != null)
                    System.out.println(emp);
                else
                    System.out.println("Employee not found");
                
                break;

            case 3:
            	System.out.println("Enter Employee ID to update:");
            	int id1 = sc.nextInt();

            	entityTransaction.begin();

            	Employee emp1 = entityManager.find(Employee.class, id1);

            	if (emp1 != null) {

            	    System.out.println("What do you want to update?");
            	    System.out.println("1. Email");
            	    System.out.println("2. Contact Number");
            	    System.out.println("3. Both");

            	    int choice1 = sc.nextInt();

            	    switch(choice1) {

            	    case 1:
            	        System.out.println("Enter new Email:");
            	        emp1.setEmpMailId(sc.next());
            	        break;

            	    case 2:
            	        System.out.println("Enter new Contact:");
            	        emp1.setEmpContactNumber(sc.nextLong());
            	        break;

            	    case 3:
            	        System.out.println("Enter new Email:");
            	        emp1.setEmpMailId(sc.next());

            	        System.out.println("Enter new Contact:");
            	        emp1.setEmpContactNumber(sc.nextLong());
            	        break;

            	    default:
            	        System.out.println("Invalid choice");
            	    }

            	    entityManager.merge(emp1);

            	    System.out.println("Employee Updated Successfully");

            	} else {
            	    System.out.println("Employee not found");
            	}

            	entityTransaction.commit();
            	break;

            case 4:
            	System.out.println("Enter Employee ID to delete:");
                int id2 = sc.nextInt();

                entityTransaction.begin();

                Employee emp2 = entityManager.find(Employee.class, id2);

                if (emp2 != null) {

                    entityManager.remove(emp2);
                    System.out.println("Employee deleted successfully");

                } else {
                    System.out.println("Employee not found");
                }

                entityTransaction.commit();
                break;

            case 5:
                System.exit(0);

            default:
                System.out.println("Invalid Choice");
            }
        }
		
	}
}
