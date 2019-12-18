package com.ust.pms.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ust.pms.entity.Project;

@Repository
public interface ProjectDao extends CrudRepository<Project, Long>  {

	
		@Override
		public List<Project> findAll();
}
