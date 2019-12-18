package com.ust.pms.dao;

import org.springframework.stereotype.Repository;

import com.ust.pms.entity.Employee;

import org.springframework.data.repository.CrudRepository;
@Repository
public interface EmployeeRepository extends CrudRepository<Employee , Long>{

	/*jdbc:h2:mem:testdb  for the embedded databases in the spring boot to connect 
		to connect to the database we need to type the url like localhost:8080/h2-console
		(spring.h2.console.path	=	/h2-console) from the application.properties file
	*/	
}
