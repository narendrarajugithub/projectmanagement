package com.ust.pms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ust.pms.dao.EmployeeRepository;
import com.ust.pms.entity.Employee;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	EmployeeRepository employeeDao;
	
	@GetMapping
	public String name(Model model) {
		 List<Employee> emplist=	employeeDao.findAll();
		 model.addAttribute("emplist", emplist);
		 return "/employee/list-employees";
	}
	
	@GetMapping("/new")
	public String employee(Model emp) {
		emp.addAttribute("employee", new Employee());
		System.out.println("inside new");
		System.out.println("---------------------------------------------------");
		
		return "/employee/new-employee";
	}
	
	@PostMapping("/save")
	public String saveemployee(Model model,Employee emp) {
		
		employeeDao.save(emp);
		System.out.println("---------------------------------------------------");
		return "redirect:/employee/new";
	}
	
}
