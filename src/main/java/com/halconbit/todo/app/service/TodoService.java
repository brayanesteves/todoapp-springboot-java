package com.halconbit.todo.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.halconbit.todo.app.model.TodoItem;
import com.halconbit.todo.app.repository.TodoRepository;

@Service
public class TodoService {
	
	@Autowired // Inject
	private TodoRepository todoRepo;
	public List<TodoItem> index() {
		return this.todoRepo.findAll();
	}
	
	public TodoItem save(TodoItem TodoItem) {
        return this.todoRepo.save(TodoItem);
    }
	
}
