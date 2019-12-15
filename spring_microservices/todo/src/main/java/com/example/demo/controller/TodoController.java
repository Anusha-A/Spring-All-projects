package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.TodoService;
import com.example.demo.entity.Todo;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:3003/")
public class TodoController {
	
	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}

	private TodoService todoService;
	
	@GetMapping("/getTodos")
	public List<Todo> getAllTodos()
	{
		return todoService.getAllTodos();
	}
	
	@PostMapping("/getTodos")
	public Todo saveTodos(@RequestBody Todo todo)
	{
		return todoService.saveTodo(todo);
	}

}
