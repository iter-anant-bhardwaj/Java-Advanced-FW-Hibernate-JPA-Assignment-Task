package com.capgemini.java_dev.framework.hibernate_jpa.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee implements Serializable {
	@Id
	private Integer empId;
	private String empName;
	private String empMailId;
	private Long empContactNumber;
	public Employee() {
		
	}
	public Employee(Integer empId, String empName, String empMailId, Long empContactNumber) {
		this.empId = empId;
		this.empName = empName;
		this.empMailId = empMailId;
		this.empContactNumber = empContactNumber;
	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpMailId() {
		return empMailId;
	}
	public void setEmpMailId(String empMailId) {
		this.empMailId = empMailId;
	}
	public Long getEmpContactNumber() {
		return empContactNumber;
	}
	public void setEmpContactNumber(Long empContactNumber) {
		this.empContactNumber = empContactNumber;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empMailId=" + empMailId + ", empContactNumber="
				+ empContactNumber + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(empContactNumber, empId, empMailId, empName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(empContactNumber, other.empContactNumber) && Objects.equals(empId, other.empId)
				&& Objects.equals(empMailId, other.empMailId) && Objects.equals(empName, other.empName);
	}
	
	
	
}
