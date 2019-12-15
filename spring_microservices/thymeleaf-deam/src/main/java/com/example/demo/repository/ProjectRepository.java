package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
	public List<Project> findAllByOrderByTitleAsc();

	// add a method to search by first name and last name
	public List<Project> findByTitleContainsAndDescriptionContainsAllIgnoreCase(
									String theTitle, String theDescription);

}
