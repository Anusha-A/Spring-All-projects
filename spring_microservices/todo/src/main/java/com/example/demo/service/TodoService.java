package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Todo;
public interface TodoService {
	
	public List<Todo> getAllTodos();
	public Todo saveTodo(Todo todo);

}
