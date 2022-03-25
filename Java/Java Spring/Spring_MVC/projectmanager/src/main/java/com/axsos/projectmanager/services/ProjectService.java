package com.axsos.projectmanager.services;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.axsos.projectmanager.models.Project;
import com.axsos.projectmanager.models.User;
import com.axsos.projectmanager.repositories.ProjectRepository;
import com.axsos.projectmanager.repositories.UserRepository;
@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;
	@Autowired
	private UserService userService;
	
	public ProjectService(ProjectRepository projectrepository, UserService userService) {
		
		this.projectRepository = projectrepository;
		this.userService = userService;
	}
	
	public List <Project> getAllProjects(){
		return projectRepository.findAll();
	}
	
	public Project findProject(Long id) {
		Optional<Project> optionalBook = projectRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
	
	public Project createProject(Project project) {
		return this.projectRepository.save(project);
	}
	
	public List<Project> getAllProjectsByUser(Long userId){
		return projectRepository.findByUserId(userId);
	}
	
	public void updateProject(Project newProject, Long projectId) {

		Project project = findProject(projectId);
		project.setTitle(newProject.getTitle());
		project.setDescription(newProject.getDescription());
		project.setDueDate(newProject.getDueDate());
		projectRepository.save(project);
	}
	
	public List<Project> getAvailableProjects(User user) {
		return projectRepository.findByUserIdNotAndJoinedUsersNotContaining(user.getId(), user);
		
	}
	
	public List<Project> getJoinedProjects(User user) {
		return projectRepository.findByJoinedUsersContaining(user);	
	}
	
	public List<Project> getProjectsCreatedByUser(Long userId) {
		return projectRepository.findByUserId(userId);
	}
	
	public void joinProject(Long projectId, Long UserId) {
		Project project = findProject(projectId);
		User user = userService.findUserById(UserId);
		project.getJoinedUsers().add(user);
		projectRepository.save(project);
		
	}
	
	public void leaveProject(Long projectId, Long UserId) {
		Project project = findProject(projectId);
		User user = userService.findUserById(UserId);
		project.getJoinedUsers().remove(user);
		projectRepository.save(project);
		
	}
	public void deleteProject(long id) {
		projectRepository.deleteById(id);
	}
	
}
