package com.ust.pms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ust.pms.dto.ChartData;
import com.ust.pms.entity.Project;

@Repository
public interface ProjectDao extends CrudRepository<Project, Long>  {

	
		@Override
		public List<Project> findAll();
		
		@Query(nativeQuery = true, value = "select stage ,count(*)as value from project group by stage" )
		public List<ChartData> getprojectStatus();
		
}
