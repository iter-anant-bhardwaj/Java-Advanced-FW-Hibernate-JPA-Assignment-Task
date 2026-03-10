package java_dev.java_advance.framework.hibernate_jpa.onetomany_finite.main;

import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java_dev.java_advance.framework.hibernate_jpa.onetomany_finite.entity.Project1;
import java_dev.java_advance.framework.hibernate_jpa.onetomany_finite.entity.Student1;



public class JavaApp {
	public static void execution() {
		Scanner sc = new Scanner(System.in);
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Student-Array-Project");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		
//		Project1 project1 = new Project1();
//		project1.setId(1);
//		project1.setName("Bus Reservation System");
//		project1.setDescription("AI based reservation system");
//		entityManager.persist(project1);
//		
//		Project1 project2 = new Project1();
//		project2.setId(2);
//		project2.setName("Train Reservation System");
//		project2.setDescription("AI based train reservation system");
//		entityManager.persist(project2);
//		
//		Project1 project3 = new Project1();
//		project3.setId(3);
//		project3.setName("Movie Recommendation System");
//		project3.setDescription("AI based train reservation system");
//		entityManager.persist(project3);
//		
//		Project1 projects[] = new Project1[3];
//		projects[0] = project1;
//		projects[1] = project2;
//		projects[2] = project3;
//						
//		Student1 student1 = new Student1();
//		student1.setId(1);
//		student1.setName("Ansh");
//		student1.setMailId("ansh@gmail.com");
//		student1.setContactNumber(8755844213L);
//		student1.setProjects(projects);
//		entityManager.persist(student1);
		
		
//		read
//		Student1 student = entityManager.find(Student1.class, 1);
//		if(student!=null) {
//			System.out.println(student);
//			Project1 proj[] = student.getProjects();
//			for(Project1 proje: proj) {
//				System.out.println(proje);
//			}
//		}
//		else {
//			System.out.println("Student not found");
//		}
		
		
		//update
//		Student1 student = entityManager.find(Student1.class, 1);
//		if(student!=null) {
////			System.out.println(student);
//			Project1 proj[] = student.getProjects();
//			for(Project1 p: proj) {
//				System.out.println(p);
//			}
//			System.out.println("Enter Project ID to update:");
//		    int pid = sc.nextInt();
//		    sc.nextLine();
//		    
//		    for(Project1 p : proj) {
//		        if(p.getId() == pid) {
//
//		            System.out.println("Enter new project name:");
//		            String newName = sc.nextLine();
//		            System.out.println("Enter new project description:");
//		            String newDescription = sc.nextLine();
//
//		            p.setName(newName);
//		            p.setDescription(newDescription);
//
//		            entityManager.merge(p);
//
//		            System.out.println("Project Updated Successfully");
//		        }
//		    }
//		}
//		else {
//			System.out.println("Student not found");
//		}
		
		
		
		//delete student
		Student1 stu = entityManager.find(Student1.class, 1);
		if(stu!=null) {
			entityManager.remove(stu);
		}
		else {
			System.out.println("Student not found");
		
		}
		
		
		//delete project
//		Student1 student = entityManager.find(Student1.class, 1);
//
//		if(student != null) {
//
//			Project1 proj[] = student.getProjects();
//			System.out.println("Enter Project ID to be deleted:");
//			int pid = sc.nextInt();
//		    for(Project1 p : proj) {
//		        if(pid == p.getId()) {
//		            entityManager.remove(p);
//		            p = null;
////		            entityManager.merge(p);
//		            System.out.println("Project Deleted Successfully");
//		            break;
//		        }
//		    }
//		}
//		else {
//			System.out.println("Student not found");
//		}
		
	
		
		entityTransaction.commit();
		
		entityManager.close();
		entityManagerFactory.close();
		sc.close();
		
	}
}
