package com.ust.pms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ust.pms.dao.EmployeeRepository;
import com.ust.pms.dao.ProjectDao;
import com.ust.pms.entity.Employee;
import com.ust.pms.entity.Project;

import javassist.expr.NewArray;

@Controller
@RequestMapping("/projects")
public class ProjectMangementController {
	@Autowired
	ProjectDao projrepo;
	
	@Autowired
	EmployeeRepository empDao;
	
	@GetMapping
	public String allprojects(Model model) {
		List<Project> proje= projrepo.findAll();
		model.addAttribute("projects", proje);
		return "projects/list-projects";
	}
	
	@GetMapping("/new")
	public String displayproject(Model model) {
	Project proj=	new Project();
	
	
	List<Project> projlist=   projrepo.findAll();
	List<Employee> emplist= empDao.findAll();
	
	model.addAttribute("project", proj );
	
	model.addAttribute("empList", emplist);
	
	return "projects/new-project";
	}
	
	@PostMapping("/save" )
	public String CreateProject(Project proj ,@RequestParam(name = "empList") List<Long> empList, Model model) {
		System.out.println("----------------------------------------->");
		projrepo.save(proj);
		
		
		
		  for(Employee e:proj.getEmpList()) {
			  e.setProject(proj);
			  empDao.save(e);
			  }
		 
		
		return "redirect:/projects/";
	}
}
