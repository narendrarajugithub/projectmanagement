package com.ust.pms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ust.pms.attribute.Project;
import com.ust.pms.dao.ProjectRepository;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	@Autowired
	ProjectRepository projectRepo;
	
	@RequestMapping("/new")
	public String displayProjects(Model	 model) {
		model.addAttribute("project", new Project() );
		System.out.println("new project created");
		return"newproject";
	}
	
	public String CreateOroject(Project project,Model model) {
		projectRepo.save(project);
		
		return "redirect:/new";
		
	}
}
