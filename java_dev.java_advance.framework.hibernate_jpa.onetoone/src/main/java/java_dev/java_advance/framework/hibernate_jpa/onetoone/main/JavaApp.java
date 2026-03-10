package java_dev.java_advance.framework.hibernate_jpa.onetoone.main;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java_dev.java_advance.framework.hibernate_jpa.onetoone.entity.Project;
import java_dev.java_advance.framework.hibernate_jpa.onetoone.entity.Student;

public class JavaApp {
	public static void execution() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Student-Project");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		
//		Project project1 = new Project();
//		project1.setId(1);
//		project1.setName("Bus Reservation System");
//		project1.setDescription("AI based reservation system");
//		entityManager.persist(project1);
//		
//		
//		Student student1 = new Student();
//		student1.setId(1);
//		student1.setName("Ansh");
//		student1.setMailId("ansh@gmail.com");
//		student1.setContactNumber(8755844213L);
//		student1.setProject(project1);
//		entityManager.persist(student1);
		
//		Project project2 = new Project();
//		project2.setId(2);
//		project2.setName("Train Reservation System");
//		project2.setDescription("AI based train reservation system");
//		entityManager.persist(project2);
//		
//		
//		Student student2 = new Student();
//		student2.setId(2);
//		student2.setName("Anuj");
//		student2.setMailId("anuj@gmail.com");
//		student2.setContactNumber(7545844213L);
//		student2.setProject(project2);
//		entityManager.persist(student2);
		
//		Project project3 = new Project();
//		project3.setId(3);
//		project3.setName("Movie Recommendation System");
//		project3.setDescription("AI based train reservation system");
//		entityManager.persist(project3);
//		
//		
//		Student student3 = new Student();
//		student3.setId(3);
//		student3.setName("Raj");
//		student3.setMailId("raj@gmail.com");
//		student3.setContactNumber(7555445213L);
//		student3.setProject(project3);
//		entityManager.persist(student3);
		
		
		
		
		
		//read
		
//		Student stu = entityManager.find(Student.class, 2);
//		if(stu!=null) {
//			System.out.println(stu);
//			Project project = stu.getProject();
//			if(project!=null) {
//				System.out.println(project);
//			}
//			else {
//				System.out.println("Project not found");
//			}
//		}
//		else {
//			System.out.println("Student not found");
//		}
		
		
		
		
		//update
//		Student stu = entityManager.find(Student.class, 2);
//		if(stu!=null) {
//			stu.setMailId("king@gmail.com");
//			entityManager.merge(stu);
//		}
//		else {
//			System.out.println("Student not found");
//		}
		
		
		
		
		//delete
		Student stu = entityManager.find(Student.class, 2);
		if(stu!=null) {
			entityManager.remove(stu);
			
		}
		else {
			System.out.println("Student not found");
		}
		
		
		
		
		entityTransaction.commit();
		
		entityManager.close();
		entityManagerFactory.close();
		
	}
}
