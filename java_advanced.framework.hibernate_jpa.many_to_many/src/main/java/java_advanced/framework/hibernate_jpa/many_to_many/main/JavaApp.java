package java_advanced.framework.hibernate_jpa.many_to_many.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java_advanced.framework.hibernate_jpa.many_to_many.entity.Project;
import java_advanced.framework.hibernate_jpa.many_to_many.entity.Student;

public class JavaApp {

	public static void execution() {

	    Scanner sc = new Scanner(System.in);

	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Students-List-Projects");

	    EntityManager em = emf.createEntityManager();
	    EntityTransaction et = em.getTransaction();

	    while (true) {

	        System.out.println("\n===== MENU =====");
	        System.out.println("1 Insert Project");
	        System.out.println("2 Insert Student");
	        System.out.println("3 Read Student");
	        System.out.println("4 Read Project");
	        System.out.println("5 Update Student");
	        System.out.println("6 Update Project");
	        System.out.println("7 Delete Student");
	        System.out.println("8 Delete Project");
	        System.out.println("9 Exit");

	        int choice = sc.nextInt();

	        switch (choice) {

	        case 1:

	            System.out.println("Enter Project Id");
	            int pid = sc.nextInt();
	            sc.nextLine();

	            System.out.println("Enter Project Name");
	            String pname = sc.nextLine();

	            System.out.println("Enter Description");
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

	            System.out.println("Enter Email");
	            String email = sc.nextLine();

	            System.out.println("Enter Contact Number");
	            long contact = sc.nextLong();

	            System.out.println("How many projects to assign?");
	            int n = sc.nextInt();

	            List<Project> plist = new ArrayList<>();

	            for(int i=0;i<n;i++) {

	                System.out.println("Enter Project Id");
	                int p = sc.nextInt();

	                Project pr = em.find(Project.class, p);

	                if(pr != null) {
	                    plist.add(pr);
	                } else {
	                    System.out.println("Project not found");
	                }
	            }

	            Student student = new Student();
	            student.setId(sid);
	            student.setName(name);
	            student.setEmailId(email);
	            student.setContactNumber(contact);
	            student.setProjects(plist);

	            et.begin();
	            em.persist(student);
	            et.commit();

	            System.out.println("Student Inserted");

	        break;


	        case 3:

	        	System.out.println("Enter Student Id");
	            int rid = sc.nextInt();

	            Student s = em.find(Student.class, rid);

	            if(s != null) {

	                System.out.println("\n===== Student Details =====");
	                System.out.println("Id: " + s.getId());
	                System.out.println("Name: " + s.getName());
	                System.out.println("Email: " + s.getEmailId());
	                System.out.println("Contact: " + s.getContactNumber());

	                System.out.println("\nProjects:");

	                if(s.getProjects() != null) {

	                    for(Project p : s.getProjects()) {

	                        System.out.println("-----------------------");
	                        System.out.println("Project Id: " + p.getId());
	                        System.out.println("Project Name: " + p.getName());
	                        System.out.println("Description: " + p.getDescription());
	                    }

	                } else {
	                    System.out.println("No projects assigned");
	                }

	            } else {
	                System.out.println("Student not found");
	            }

	        break;


	        case 4:

	        	System.out.println("Enter Project Id");
	            int rpid = sc.nextInt();

	            Project pr = em.find(Project.class, rpid);

	            if(pr != null) {

	                System.out.println("\n===== Project Details =====");
	                System.out.println("Id: " + pr.getId());
	                System.out.println("Name: " + pr.getName());
	                System.out.println("Description: " + pr.getDescription());

	                System.out.println("\nStudents Working On This Project:");

	                if(pr.getStudents() != null) {

	                    for(Student st : pr.getStudents()) {

	                        System.out.println("-----------------------");
	                        System.out.println("Student Id: " + st.getId());
	                        System.out.println("Name: " + st.getName());
	                        System.out.println("Email: " + st.getEmailId());
	                        System.out.println("Contact: " + st.getContactNumber());
	                    }

	                } else {
	                    System.out.println("No students assigned");
	                }

	            } else {
	                System.out.println("Project not found");
	            }

	        break;

	        case 5:

	            System.out.println("Enter Student Id");
	            int usid = sc.nextInt();
	            sc.nextLine();

	            Student us = em.find(Student.class, usid);

	            if(us != null) {

	                System.out.println("Enter new name");
	                String newName = sc.nextLine();

	                us.setName(newName);

	                et.begin();
	                em.merge(us);
	                et.commit();

	                System.out.println("Student Updated");

	            } else {
	                System.out.println("Student not found");
	            }

	        break;

	        case 6:

	            System.out.println("Enter Project Id");
	            int upid = sc.nextInt();
	            sc.nextLine();

	            Project up = em.find(Project.class, upid);

	            if(up != null) {

	                System.out.println("Enter new project name");
	                String newName = sc.nextLine();

	                up.setName(newName);

	                et.begin();
	                em.merge(up);
	                et.commit();

	                System.out.println("Project Updated");

	            } else {
	                System.out.println("Project not found");
	            }

	        break;

	        case 7:

	            System.out.println("Enter Student Id");
	            int dsid = sc.nextInt();

	            Student ds = em.find(Student.class, dsid);

	            if(ds != null) {

	                et.begin();
	                em.remove(ds);
	                et.commit();

	                System.out.println("Student Deleted");

	            } else {
	                System.out.println("Student not found");
	            }

	        break;

	        case 8:

	        	System.out.println("Enter Project Id");
	            int dpid = sc.nextInt();

	            Project dp = em.find(Project.class, dpid);

	            if (dp != null) {

	                et.begin();

	                List<Student> students = dp.getStudents();

	                if (students != null) {

	                    for (Student st : students) {
	                        st.getProjects().remove(dp); 
	                    }

	                }

	                em.remove(dp); 

	                et.commit();

	                System.out.println("Project Deleted");

	            } else {
	                System.out.println("Project not found");
	            }

	        break;

	        case 9:
	            System.exit(0);

	        }
	    }
	}
}