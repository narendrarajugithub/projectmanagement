package com.ust.pms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ust.pms.dao.EmployeeRepository;
import com.ust.pms.dao.ProjectDao;
import com.ust.pms.entity.Employee;
import com.ust.pms.entity.Project;



@Controller
public class HomeController {
	@Autowired
	ProjectDao projrepo;
	
	@Autowired
	EmployeeRepository emprepo;
	
	@GetMapping("/")
	public String diplayHome(Model model) {
	List <Project> projects=  projrepo.findAll();
	List<Employee> employees =emprepo.findAll();
	model.addAttribute("employees",employees);
	model.addAttribute("projects", projects);
	return "main/home";
	}
}
