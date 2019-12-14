package com.ust.pms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ust.pms.dao.ProjectDao;
import com.ust.pms.entity.Project;

import javassist.expr.NewArray;

@Controller
@RequestMapping("/projects")
public class ProjectMangementController {
	@Autowired
	ProjectDao projrepo;
	
	@GetMapping("/new")
	public String displayproject(Model model) {
	model.addAttribute("project", new Project() );	
	return "new-project";
	}
	
	@PostMapping("/save")
	public String CreateProject(Project proj,Model model) {
		projrepo.save(proj);

		
		return "redirect:/new";
	}
}
