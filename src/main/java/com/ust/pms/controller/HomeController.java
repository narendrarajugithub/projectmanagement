package com.ust.pms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ust.pms.dao.EmployeeRepository;
import com.ust.pms.dao.ProjectDao;
import com.ust.pms.dto.ChartData;
import com.ust.pms.entity.Employee;
import com.ust.pms.entity.Project;



@Controller
public class HomeController {
	
	  @Value("${app.version}") public String version;
	 
	
	@Autowired
	ProjectDao projrepo;
	
	@Autowired
	EmployeeRepository emprepo;
	
	@GetMapping("/")
	public String diplayHome(Model model) throws JsonProcessingException {
	List <Project> projects=  projrepo.findAll();
	List<Employee> employees =emprepo.findAll();
	
	List<ChartData> ProjectStatus=	projrepo.getprojectStatus();
	
	ObjectMapper chartdata =new ObjectMapper();
	String jsonData= chartdata.writeValueAsString(ProjectStatus);
	model.addAttribute("projectsStatus", jsonData);	
	model.addAttribute("version", version);
	model.addAttribute("employees",employees);
	model.addAttribute("projects", projects);
	return "main/home";
	}
}
