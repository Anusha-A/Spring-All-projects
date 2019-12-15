package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Project;
import com.example.demo.repository.ProjectRepository;
@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	private ProjectRepository projectRepository;
	
	@Override
	@Transactional
	public List<Project> getAllProjects() {
		
		return projectRepository.findAllByOrderByTitleAsc();
	}

	@Override
	public Project saveProject(Project project) {
		return projectRepository.save(project);
		
	}

	@Override
	public Project findById(int theId) {
		Optional<Project> result = projectRepository.findById(theId);
		
		Project theProject = null;
		
		if (result.isPresent()) {
			theProject = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find employee id - " + theId);
		}
		
		return theProject;
		 
	}

	@Override
	public void delete(int theId) {
		projectRepository.deleteById(theId);
		
	}
	@Override
	public List<Project> searchBy(String theTitle, String theDescription) {
		
		return projectRepository.findByTitleContainsAndDescriptionContainsAllIgnoreCase(theTitle, theDescription);
				
	}

	

}
