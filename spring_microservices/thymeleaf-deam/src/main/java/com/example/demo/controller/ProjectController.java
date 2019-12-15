package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Project;
import com.example.demo.service.ProjectService;



@Controller
@RequestMapping("/projects")
public class ProjectController {
	@Autowired
	private ProjectService projectService ; 
	
	@GetMapping("/showFormForAdd")
	public String addProjects(Model theModel)
	{
		Project theProject = new Project();
		theModel.addAttribute("project", theProject);
		return "projects/project-form";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("projectId") int theId, Model theModel) {

		// get the employee from the service
		Project theProject = projectService.findById(theId);

		// set employee as a model attribute to pre-populate the form
		theModel.addAttribute("project", theProject);

		// send over to our form
		return "projects/project-form";
	}
	
	@GetMapping("/allproject")
	public String listProjects(Model theModel) {
		theModel.addAttribute("projects", projectService.getAllProjects());
		
		return "projects/allprojects";
	}
	
	@PostMapping("/save")
	public String saveProjects(@ModelAttribute("project")  @Valid Project theProject, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "employees/employee-form";
		}
		else {	
		projectService.saveProject(theProject);
		
		return "redirect:/projects/allproject";
		}
	}
	
	
	
	
	@PostMapping("/delete")
	public String deletProject(@RequestParam("projectId") int theId ,Model model)
	{
		projectService.delete(theId);
		return "redirect:/projects/allproject";
	}
	

	@GetMapping("/search")
	public String search(@RequestParam("title") String theTitle,
						 @RequestParam("description") String theDescription,
						 Model theModel) {
		
		// check names, if both are empty then just give list of all employees

		if (theTitle.trim().isEmpty() && theDescription.trim().isEmpty()) {
			return "redirect:/projects/allproject";
		}
		else {
			// else, search by first name and last name
			List<Project> theProjects =
							projectService.searchBy(theTitle, theDescription);
			
			// add to the spring model
			theModel.addAttribute("projects", theProjects);
			
			// send to list-employees
			return "projects/allprojects";
		}
		
	}
}
