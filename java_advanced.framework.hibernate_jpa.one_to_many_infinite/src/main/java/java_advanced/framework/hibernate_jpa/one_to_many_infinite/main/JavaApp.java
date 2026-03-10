package java_advanced.framework.hibernate_jpa.one_to_many_infinite.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java_advanced.framework.hibernate_jpa.one_to_many_infinite.entity.Project;
import java_advanced.framework.hibernate_jpa.one_to_many_infinite.entity.Student;

public class JavaApp {
	public static void execution() {
		Scanner sc = new Scanner(System.in);
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Student-List-Project");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		while (true) {

			System.out.println("\n===== MENU =====");
			System.out.println("1 Insert Student");
			System.out.println("2 Read Student");
			System.out.println("3 Update Student");
			System.out.println("4 Delete Student");
			System.out.println("5 Delete Project");
			System.out.println("6 Exit");

			int choice = sc.nextInt();

			switch (choice) {

			case 1:

				System.out.println("Enter Student Id");
				int sid = sc.nextInt();
				sc.nextLine();

				System.out.println("Enter Student Name");
				String name = sc.nextLine();

				System.out.println("Enter Mail Id");
				String mail = sc.nextLine();

				System.out.println("Enter Contact Number");
				long contact = sc.nextLong();

				System.out.println("How many projects?");
				int n = sc.nextInt();

				List<Project> projectList = new ArrayList<>();

				for (int i = 0; i < n; i++) {

					System.out.println("Enter Project Id");
					int pid = sc.nextInt();
					sc.nextLine();

					System.out.println("Enter Project Name");
					String pname = sc.nextLine();

					System.out.println("Enter Project Description");
					String desc = sc.nextLine();

					Project p = new Project();
					p.setId(pid);
					p.setName(pname);
					p.setDescription(desc);

					projectList.add(p);
				}

				Student student = new Student(sid, name, mail, contact, projectList);

				entityTransaction.begin();
				entityManager.persist(student);
				entityTransaction.commit();

				System.out.println("Student Inserted");

				break;

			case 2:

				System.out.println("Enter Student Id");
				int readId = sc.nextInt();

				Student s = entityManager.find(Student.class, readId);

				if (s != null) {
					System.out.println(s);
					System.out.println("Projects : " + s.getProjects());
				} else {
					System.out.println("Student not found");
				}

				break;

			case 3:

				System.out.println("Enter Student Id to update");
				int uid = sc.nextInt();
				sc.nextLine();

				Student updateStudent = entityManager.find(Student.class, uid);

				if (updateStudent != null) {

					System.out.println("Enter new name");
					String newName = sc.nextLine();

					updateStudent.setName(newName);

					entityTransaction.begin();
					entityManager.merge(updateStudent);
					entityTransaction.commit();

					System.out.println("Student Updated");

				} else {
					System.out.println("Student not found");
				}

				break;

			case 4:

				System.out.println("Enter Student Id to delete");
				int did = sc.nextInt();

				Student deleteStudent = entityManager.find(Student.class, did);

				if (deleteStudent != null) {

					entityTransaction.begin();
					entityManager.remove(deleteStudent);
					entityTransaction.commit();

					System.out.println("Student Deleted");

				} else {
					System.out.println("Student not found");
				}

				break;
			
			case 5:

				System.out.print("Enter Student ID: ");
				int sid1 = sc.nextInt();

				Student student1 = entityManager.find(Student.class, sid1);

				if (student1 != null) {

					List<Project> projects = student1.getProjects();

					System.out.print("\nEnter Project ID to delete: ");
					int pid = sc.nextInt();

					Project projectToDelete = null;

					for (Project p : projects) {
						if (p.getId() == pid) {
							projectToDelete = p;
							break;
						}
					}

					if (projectToDelete != null) {

						projects.remove(projectToDelete);

						entityManager.remove(projectToDelete);

						System.out.println("Project Deleted Successfully");

					} else {
						System.out.println("Project Not Found");
					}

				} else {
					System.out.println("Student Not Found");
				}
			break;
			
			case 6:
				System.exit(0);
			}
		}
	}
}
