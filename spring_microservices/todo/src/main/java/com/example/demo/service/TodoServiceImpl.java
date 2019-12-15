package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Todo;
import com.example.demo.repository.TodoRepository;

@Service
public class TodoServiceImpl implements TodoService {
	
	@Autowired
	private TodoRepository todoRepository;

	@Override
	public List<Todo> getAllTodos() {
		// TODO Auto-generated method stub
		return todoRepository.findAll();
	}

	@Override
	public Todo saveTodo(Todo todo) {
		// TODO Auto-generated method stub
		return todoRepository.save(todo);
	}

}
