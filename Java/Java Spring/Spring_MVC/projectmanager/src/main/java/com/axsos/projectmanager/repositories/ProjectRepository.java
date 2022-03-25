package com.axsos.projectmanager.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.projectmanager.models.Project;
import com.axsos.projectmanager.models.User;
@Repository
public interface ProjectRepository extends CrudRepository<Project,Long> {
	
	List<Project> findAll();
	
	
	
	// Get all projects created by this user
	List<Project> findByUserId(Long userId);
	
	//@Query("{'projects.user_id' : ?1}")
	List<Project> findByUserIdNotAndJoinedUsersNotContaining(Long id1, User user);
	
	List<Project> findByJoinedUsersContaining(User user);

	
	// find all available Projects
//	List<Project> findByJoinedNull();
	
//	find all projects joined by this user
//	List<Project> findByJoinedUsers(Long joinedUsersId);
	
//	List<Project> findByUserId(long userId);
	

}
