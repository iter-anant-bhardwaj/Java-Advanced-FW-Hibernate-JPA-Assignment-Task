package com.capgemini.java_dev.framework.hibernate_jpa.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student implements Serializable {
	@Id
	private Integer id;
	private String name;
	private String mailId;
	private Long contactNumber;
	
	public Student() {
	}
	
	public Student(Integer id, String name, String mailId, Long contactNumber) {
		this.id = id;
		this.name = name;
		this.mailId = mailId;
		this.contactNumber = contactNumber;
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
	public void setContactNumber(Long contackNumber) {
		this.contactNumber = contackNumber;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", mailId=" + mailId + ", contactNumber=" + contactNumber + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(contactNumber, id, mailId, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(contactNumber, other.contactNumber) && Objects.equals(id, other.id)
				&& Objects.equals(mailId, other.mailId) && Objects.equals(name, other.name);
	}
	
	
}
