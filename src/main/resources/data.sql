-- INSERT EMPLOYEES			
insert into employee (employee_id, firstname, lastname, email) values (select HIBERNATE_SEQUENCE.NEXTVAL from dual, 'John', 'Warton', 'warton@gmail.com');
insert into employee (employee_id, firstname, lastname, email) values (SELECT HIBERNATE_SEQUENCE.NEXTVAL FROM DUAL, 'Mike', 'Lanister', 'lanister@gmail.com');
insert into employee (employee_id, firstname, lastname, email) values (SELECT HIBERNATE_SEQUENCE.NEXTVAL FROM DUAL, 'Steve', 'Reeves', 'Reeves@gmail.com');
insert into employee (employee_id, firstname, lastname, email) values (SELECT HIBERNATE_SEQUENCE.NEXTVAL FROM DUAL, 'Ronald', 'Connor', 'connor@gmail.com');
insert into employee (employee_id, firstname, lastname, email) values (SELECT HIBERNATE_SEQUENCE.NEXTVAL FROM DUAL, 'Jim', 'Salvator', 'Sal@gmail.com');
insert into employee (employee_id, firstname, lastname, email) values (SELECT HIBERNATE_SEQUENCE.NEXTVAL FROM DUAL, 'Peter', 'Henley', 'henley@gmail.com');
insert into employee (employee_id, firstname, lastname, email) values (SELECT HIBERNATE_SEQUENCE.NEXTVAL FROM DUAL, 'Richard', 'Carson', 'carson@gmail.com');
insert into employee (employee_id, firstname, lastname, email) values (SELECT HIBERNATE_SEQUENCE.NEXTVAL FROM DUAL, 'Honor', 'Miles', 'miles@gmail.com');
insert into employee (employee_id, firstname, lastname, email) values (SELECT HIBERNATE_SEQUENCE.NEXTVAL FROM DUAL, 'Tony', 'Roggers', 'roggers@gmail.com');

-- INSERT PROJECTS			
insert into project (project_id, name, stage, description) values (nextval('project_seq'), 'Large Production Deploy', 'NOTSTARTED', 'This requires all hands on deck for the final deployment of the software into production');
insert into project (project_id, name, stage, description) values (nextval('project_seq'), 'New Employee Budget',  'COMPLETED', 'Decide on a new employee bonus budget for the year and figureout who will be promoted');
insert into project (project_id, name, stage, description) values (nextval('project_seq'), 'Office Reconstruction', 'INPROGRESS', 'The office building in Monroe has been damaged due to hurricane in the region. This needs to be reconstructed');
insert into project (project_id, name, stage, description) values (nextval('project_seq'), 'Improve Intranet Security', 'INPROGRESS', 'With the recent data hack, the office security needs to be improved and proper security team needs to be hired for implementation');

-- INSERT PROJECT_EMPLOYEE_RELATION
insert into project_employee (employee_id, project_id) (select e.employee_id, p.project_id from employee e, project p where e.lastname ='Warton' AND p.name = 'Large Production Deploy');
insert into project_employee (employee_id, project_id) (select e.employee_id, p.project_id from employee e, project p where e.lastname ='Warton' AND p.name = 'New Employee Budget');
insert into project_employee (employee_id, project_id) (select e.employee_id, p.project_id from employee e, project p where e.lastname ='Warton' AND p.name = 'Office Reconstruction');
insert into project_employee (employee_id, project_id) (select e.employee_id, p.project_id from employee e, project p where e.lastname ='Reeves' AND p.name = 'Large Production Deploy');
insert into project_employee (employee_id, project_id) (select e.employee_id, p.project_id from employee e, project p where e.lastname ='Warton' AND p.name = 'New Employee Budget');
insert into project_employee (employee_id, project_id) (select e.employee_id, p.project_id from employee e, project p where e.lastname ='Warton' AND p.name = 'Improve Intranet Security');
insert into project_employee (employee_id, project_id) (select e.employee_id, p.project_id from employee e, project p where e.lastname ='Henley' AND p.name = 'Office Reconstruction');
insert into project_employee (employee_id, project_id) (select e.employee_id, p.project_id from employee e, project p where e.lastname ='Henley' AND p.name = 'Improve Intranet Security');															