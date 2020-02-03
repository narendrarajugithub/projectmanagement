package com.ust.pms.services;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	
	/*Parameter 0 of constructor in com.ust.pms.services.EmployeeService required a single bean, but 2 were found:
		- IStaffRepository1: defined in file [C:\Users\NarendraRaju's\IStaffRepository1.class]
		- IStaffRepository2: _in file [C:\Users\NarendraRaju's\*\target\classes\services\IStaffRepository2.class]
*/	@Autowired()
	//@Qualifier("IStaffRepository1")
	IStaffRepository staffrepo;
	
	EmployeeService( @Qualifier("IStaffRepository1") IStaffRepository staffrepo){
		super();
		this.staffrepo=staffrepo;
	}
	
}
