package com.ust.pms.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private long projectId;
	
	public void setEmpList(List<Employee> empList) {
		this.empList = empList;
	}
	private String name;
	private String stage;
	private String description;
	
	
	  @OneToMany(cascade =
	  {CascadeType.REFRESH,CascadeType.DETACH,CascadeType.PERSIST,CascadeType.MERGE
	  }, mappedBy = "project" )
	 
	 private List<Employee> empList; 
		
	
	  public List<Employee> getEmpList() { return empList; }
	  public void	  setEmpList1(List<Employee> empList1) { this.empList = empList; }
	 
	public long getProjectId() {
		return projectId;
	}
	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStage() {
		return stage;
	}
	public void setStage(String stage) {
		this.stage = stage;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
