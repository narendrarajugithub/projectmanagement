package com.ust.pms.dao;

import org.springframework.stereotype.Repository;

import com.ust.pms.entity.Employee;

import org.springframework.data.repository.CrudRepository;
@Repository
public interface EmployeeRepository extends CrudRepository<Employee , Long>{

}
