package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Project;

public interface ProjectService {
	public List<Project> getAllProjects();
	public Project saveProject(Project project);
	public Project findById(int theId);
	public void delete(int theId);
	public List<Project> searchBy(String theTitle, String theDescription);
	

}
