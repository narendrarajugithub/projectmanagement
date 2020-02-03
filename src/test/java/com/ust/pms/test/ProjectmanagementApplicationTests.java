package com.ust.pms.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import com.ust.pms.ProjectmanagementApplication;
import com.ust.pms.dao.ProjectDao;
import com.ust.pms.entity.Project;


@SpringBootTest(classes = ProjectmanagementApplication.class)
@RunWith(SpringRunner.class)

@TestPropertySource(locations="classpath:application_test.properties")

/*
 * @SqlGroup({
 * 
 * @Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = {
 * "classpath:data.sql" }) ,@Sql(executionPhase =
 * ExecutionPhase.AFTER_TEST_METHOD, scripts = {"classpath:drop.sql"} ) })
 */
public class ProjectmanagementApplicationTests {

	@Autowired
	ProjectDao projectRepo;
	
	@Test
	public void saveProject() {
		
		if(projectRepo.findAll().size()<1) {
		
		  Project project=new Project(); project.setName("DEMO");
		  project.setProjectId(0); project.setStage("INPROGRESS");
		  project.setDescription("STARTED");
		  projectRepo.save(project); System.out.println(
		  "________________________________________________________________if>");
		 
		}
			 System.out.println(
					  "________________________________________________________________else>");
			assertEquals( projectRepo.findAll().size()>=1,true);
		
		
	}
	
}
