package com.ust.pms.attribute;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long projectId;
	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}
	private String name;
	private String status;
	private String discription;
	
	public Project(){
		System.out.println("constructor executing");
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String stage) {
		this.status = stage;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String description) {
		this.discription = description;
	}
	
}
