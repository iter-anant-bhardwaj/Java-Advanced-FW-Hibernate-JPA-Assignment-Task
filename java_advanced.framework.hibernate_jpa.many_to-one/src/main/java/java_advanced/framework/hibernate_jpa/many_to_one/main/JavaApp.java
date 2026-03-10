package java_advanced.framework.hibernate_jpa.many_to_one.main;

import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java_advanced.framework.hibernate_jpa.many_to_one.entity.Project;
import java_advanced.framework.hibernate_jpa.many_to_one.entity.Student;

public class JavaApp {

	public static void execution() {

		Scanner sc = new Scanner(System.in);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Students-List-Project");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		while (true) {

			System.out.println("\n===== MENU =====");
			System.out.println("1 Insert Project");
			System.out.println("2 Insert Student");
			System.out.println("3 Read Student");
			System.out.println("4 Update Student");
			System.out.println("5 Delete Student");
			System.out.println("6 Exit");

			int choice = sc.nextInt();

			switch (choice) {

			case 1:

				System.out.println("Enter Project Id");
				int pid = sc.nextInt();
				sc.nextLine();

				System.out.println("Enter Project Name");
				String pname = sc.nextLine();

				System.out.println("Enter Project Description");
				String desc = sc.nextLine();

				Project project = new Project(pid, pname, desc);

				et.begin();
				em.persist(project);
				et.commit();

				System.out.println("Project Inserted");

			break;

			case 2:

				System.out.println("Enter Student Id");
				int sid = sc.nextInt();
				sc.nextLine();

				System.out.println("Enter Student Name");
				String name = sc.nextLine();

				System.out.println("Enter Mail Id");
				String mail = sc.nextLine();

				System.out.println("Enter Contact Number");
				long contact = sc.nextLong();

				System.out.println("Enter Project Id");
				int projectId = sc.nextInt();

				Project p = em.find(Project.class, projectId);

				if (p != null) {

					Student student = new Student(sid, name, mail, contact, p);

					et.begin();
					em.persist(student);
					et.commit();

					System.out.println("Student Inserted with Project");

				} else {
					System.out.println("Project not found");
				}

			break;

			case 3:

				System.out.println("Enter Student Id");
				int readId = sc.nextInt();

				Student s = em.find(Student.class, readId);

				if (s != null) {

					System.out.println(s);
					System.out.println("Project: " + s.getProject());

				} else {
					System.out.println("Student not found");
				}

			break;

			case 4:

				System.out.print("Enter Student ID to delete: ");
				int sid1 = sc.nextInt();

				Student student = em.find(Student.class, sid1);

				if(student != null) {

					em.remove(student);

					System.out.println("Student Deleted Successfully");

				}else {
					System.out.println("Student Not Found");
				}

			break;

			case 5:

				System.out.println("Enter Student Id to delete");
				int did = sc.nextInt();

				Student deleteStudent = em.find(Student.class, did);

				if (deleteStudent != null) {

					et.begin();
					em.remove(deleteStudent);
					et.commit();

					System.out.println("Student Deleted");

				} else {
					System.out.println("Student not found");
				}

			break;

			case 6:
				System.exit(0);
			}
		}
	}
}