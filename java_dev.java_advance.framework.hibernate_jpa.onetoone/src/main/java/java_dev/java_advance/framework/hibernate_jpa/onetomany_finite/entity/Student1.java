package java_dev.java_advance.framework.hibernate_jpa.onetomany_finite.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Student1 implements Serializable{
	@Id
	private Integer id;
	private String name;
	private String mailId;
	private Long contactNumber;
	@OneToMany(cascade = CascadeType.ALL)
	private Project1[] projects;
	
	public Student1() {
	}
	
	public Student1(Integer id, String name, String mailId, Long contactNumber, Project1[] projects) {
		this.id = id;
		this.name = name;
		this.mailId = mailId;
		this.contactNumber = contactNumber;
		this.projects = projects;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public Long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Project1[] getProjects() {
		return projects;
	}

	public void setProjects(Project1[] projects) {
		this.projects = projects;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", mailId=" + mailId + ", contactNumber=" + contactNumber + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(projects);
		result = prime * result + Objects.hash(contactNumber, id, mailId, name);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student1 other = (Student1) obj;
		return Objects.equals(contactNumber, other.contactNumber) && Objects.equals(id, other.id)
				&& Objects.equals(mailId, other.mailId) && Objects.equals(name, other.name)
				&& Arrays.equals(projects, other.projects);
	}
	
	
	
	
}
