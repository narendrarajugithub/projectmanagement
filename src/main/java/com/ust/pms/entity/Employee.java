package com.ust.pms.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long employeeId;
	
	private String firstname;
	private String lastname;
	private String email;
	
	
	@ManyToMany(cascade =
		  {CascadeType.REFRESH,CascadeType.DETACH,CascadeType.PERSIST,CascadeType.MERGE
		  } )
	@JoinTable(name = "PROJECT_EMPLOYEE",
 	joinColumns = @JoinColumn(name="project_id"),
 	inverseJoinColumns = @JoinColumn(name="employee_id")
 )
	//this join column will map  parent table primary key
	private List<Project> project;
	
	public List<Project> getProject() {
		return project;
	}
	public void setProject(List<Project> project) {
		this.project = project;
	}
	public Employee(String firstname, String lastname, String email) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
}
