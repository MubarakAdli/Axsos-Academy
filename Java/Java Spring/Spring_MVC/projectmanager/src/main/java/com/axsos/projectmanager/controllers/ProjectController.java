package com.axsos.projectmanager.controllers;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.axsos.projectmanager.models.Project;
import com.axsos.projectmanager.models.User;
import com.axsos.projectmanager.services.ProjectService;
import com.axsos.projectmanager.services.UserService;


@Controller
public class ProjectController {
	@Autowired
	private ProjectService projectService;
	@Autowired
	private UserService userService;
	
	public ProjectController(ProjectService projectService, UserService userService) {
		
		this.projectService = projectService;
		this.userService = userService;
	}
	
	@RequestMapping("/dashboard")
	public String homePage(Model model ,HttpSession session, Long id){
		if (session.getAttribute("user_id") != null) {
			long userId = (long) session.getAttribute("user_id");
			User loggedUser = userService.findUserById(userId);
			
//			List<Project> createdProjects=projectService.getAllProjectsByUser(id);
			List<Project> allProjects=projectService.getAvailableProjects(loggedUser);
			
			
//			model.addAttribute("availableProjects", availableProjects);
//			model.addAttribute("joinedProjects", joinedProjects);
			model.addAttribute("loggedUser", loggedUser);
//			model.addAttribute("availableProjects", availableProjects);
			model.addAttribute("allProjects", allProjects);
			List<Project> joinedProjects =projectService.getJoinedProjects(loggedUser);
			List<Project> createdProjectsList = projectService.getProjectsCreatedByUser(userId);
			createdProjectsList.addAll(joinedProjects);
			model.addAttribute("createdProjects", createdProjectsList);

			
			return "home.jsp";
		
	}
		else {
			return "rdirect:/";
		}
	}
	
	@RequestMapping("/projects/new")
	public String newProject(@ModelAttribute("project") Project project, HttpSession session) {
		if (session.getAttribute("user_id") != null) {

			return "newProject.jsp";
		}

		return "redirect:/";
	}
	
	
	@PutMapping("/join/{id}")
	public String joinProject(@ModelAttribute("project") Project project, HttpSession session, @PathVariable("id") Long id) {
		if (session.getAttribute("user_id") != null) {
			long userId = (long) session.getAttribute("user_id");
			projectService.joinProject(project.getId(), userId);
		}

		return "redirect:/dashboard";
	}
	
	@PutMapping("/leave/{id}")
	public String leaveProject(@ModelAttribute("project") Project project, HttpSession session, @PathVariable("id") Long id) {
		if (session.getAttribute("user_id") != null) {
			long userId = (long) session.getAttribute("user_id");
			projectService.leaveProject(project.getId(), userId);
		}

		return "redirect:/dashboard";
	}
	
	@PostMapping("/projects/new")
	public String addProject(@Valid @ModelAttribute("project") Project project, BindingResult result, Model model,
			HttpSession session) {
		if (session.getAttribute("user_id") != null) {
			if (result.hasErrors()) {
				model.addAttribute("user_id", session.getAttribute("user_id"));

				return "newProject.jsp";
			} else {

				long userId = (long) session.getAttribute("user_id");
				User loggedUser = userService.findUserById(userId);
				project.setUser(loggedUser);

				projectService.createProject(project);

				return "redirect:/dashboard";
			}
		} else {
			return "redirect:/";
		}

	}
	
	@GetMapping("/projects/{id}/edit")
	public String editBook(@PathVariable("id") Long id, Model model ,HttpSession session) {
		if (session.getAttribute("user_id") != null) {
			Project project=projectService.findProject(id);
			model.addAttribute("project", project);
			return "editProject.jsp";
		}
		else {
			return "redirect:/";
		}
	}
	
	@PutMapping("/projects/{id}/edit")
	public String editBookDeatils(@PathVariable("id") Long id, @Valid@ModelAttribute("project") Project project, BindingResult result,HttpSession session) {
		if (session.getAttribute("user_id") != null) {
			if (result.hasErrors()) {

				return "editProject.jsp";
			} else {
				projectService.updateProject(project, id);
				return "redirect:/dashboard";
			}
		}
			else {
				return "redirect:/";
			}
		}
	
	@GetMapping("/projects/{id}")
	public String show(@PathVariable("id") Long id, Model model, HttpSession session) {
		if (session.getAttribute("user_id") != null) {
			model.addAttribute("user_id", session.getAttribute("user_id"));
			Project project = projectService.findProject(id);
			model.addAttribute("project", project);
			return "projectDetails.jsp";
		} else {
			return "redirect:/";
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable(value = "id") long id) {
		
			projectService.deleteProject(id);
			return "redirect:/bookmarket";
		}
}

