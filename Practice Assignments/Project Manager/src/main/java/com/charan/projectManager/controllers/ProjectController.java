package com.charan.projectmanager.controllers;

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

import com.charan.projectmanager.models.Project;
import com.charan.projectmanager.models.User;
import com.charan.projectmanager.services.ProjectService;
import com.charan.projectmanager.services.UserService;

@Controller
public class ProjectController {

	@Autowired
	UserService userServ;

	@Autowired
	ProjectService projectServ;

	@GetMapping("/dashboard")
	public String welcomePage(HttpSession session, Model model) {
		// we don't want this page to render if there is no user in session
		if (session.getAttribute("session_user_id") == null) {
			return "redirect:/";
		}

		Long userID = (Long) session.getAttribute("session_user_id");
		User user = userServ.findUser(userID);
		model.addAttribute("user", user);

		List<Project> projectsWithoutUser = projectServ.projectsWithoutUser(user);

		model.addAttribute("projectsWithoutUser", projectsWithoutUser);

		return "dashboard.jsp";
	}

	@GetMapping("/new/project")
	public String newProjectPage(@ModelAttribute("newProject") Project newProject, HttpSession session) {
		// we don't want this page to render if there is no user in session
		if (session.getAttribute("session_user_id") == null) {
			return "redirect:/";
		}

		return "newProject.jsp";
	}

	@PostMapping("/new/project")
	public String createNewProject(@Valid @ModelAttribute("newProject") Project project, BindingResult result,
			HttpSession session) {
		// we don't want this page to render if there is no user in session
		if (session.getAttribute("session_user_id") == null) {
			return "redirect:/";
		}

		if (result.hasErrors()) {
			return "newProject.jsp";
		} else {
			Long userID = (Long) session.getAttribute("session_user_id");
			User user = userServ.findUser(userID);

			project.setUser(user);
			projectServ.createProject(project);

			user.getAllProjects().add(project);
			userServ.updateUser(user);

			return "redirect:/dashboard";
		}
	}

	@GetMapping("/project/{id}")
	public String viewProject(@PathVariable("id") Long projectID, HttpSession session, Model model) {
		// we don't want this page to render if there is no user in session
		if (session.getAttribute("session_user_id") == null) {
			return "redirect:/";
		}

		Project thisProject = projectServ.findProject(projectID);
		model.addAttribute("thisProject", thisProject);

		Long loggedInUserID = (Long) session.getAttribute("session_user_id");
		model.addAttribute("loggedInUserID", loggedInUserID);

		return "oneProject.jsp";
	}

	@DeleteMapping("/project/{id}/delete")
	public String deleteProject(@PathVariable("id") Long projectID, HttpSession session) {
		// we don't want this page to render if there is no user in session
		if (session.getAttribute("session_user_id") == null) {
			return "redirect:/";
		}

		projectServ.deleteProject(projectID);

		return "redirect:/dashboard";
	}

	@GetMapping("/project/{id}/edit")
	public String editProductPage(@PathVariable("id") Long projectID, HttpSession session, Model model) {
		// we don't want this page to render if there is no user in session
		if (session.getAttribute("session_user_id") == null) {
			return "redirect:/";
		}

		Project thisProject = projectServ.findProject(projectID);
		model.addAttribute("thisProject", thisProject);

		Long userID = (Long) session.getAttribute("session_user_id");
		User user = userServ.findUser(userID);
		
//		System.out.println(user.getAllProjects());
		
		return "editProject.jsp";
	}

	@PostMapping("/submit/edits")
	public String submitEdits(@Valid @ModelAttribute("thisProject") Project project, BindingResult result,
			HttpSession session) {
		// we don't want this page to render if there is no user in session
		if (session.getAttribute("session_user_id") == null) {
			return "redirect:/";
		}
		
		if(result.hasErrors()) {
			return "editProject.jsp";
		} else {
			projectServ.updateProject(project);
			Long userID = (Long) session.getAttribute("session_user_id");
			User user = userServ.findUser(userID);
			
//			System.out.println(user.getAllProjects());
			
			user.getAllProjects().add(project);
			userServ.updateUser(user);
			
//			System.out.println(user.getAllProjects());
			
			return "redirect:/dashboard";
		}
		
	}

	@GetMapping("/project/{id}/join")
	public String joinProject(@PathVariable("id") Long projectID, HttpSession session) {
		// we don't want this page to render if there is no user in session
		if (session.getAttribute("session_user_id") == null) {
			return "redirect:/";
		}

		Long userID = (Long) session.getAttribute("session_user_id");
		User user = userServ.findUser(userID);

		Project thisProject = projectServ.findProject(projectID);

		user.getAllProjects().add(thisProject);
		userServ.updateUser(user);

		return "redirect:/dashboard";
	}

	@GetMapping("/project/{id}/leave")
	public String leaveProject(@PathVariable("id") Long projectID, HttpSession session) {
		// we don't want this page to render if there is no user in session
		if (session.getAttribute("session_user_id") == null) {
			return "redirect:/";
		}

		Long userID = (Long) session.getAttribute("session_user_id");
		User user = userServ.findUser(userID);

		Project thisProject = projectServ.findProject(projectID);
		user.getAllProjects().remove(thisProject);
		userServ.updateUser(user);

		return "redirect:/dashboard";
	}

}
