package com.halconbit.todo.app.controllers;

import java.util.List;
import java.util.Optional;

import org.hibernate.LazyInitializationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.halconbit.todo.app.service.TodoService;

import com.halconbit.todo.app.helper.ResponseHandler;
import com.halconbit.todo.app.helper.MessagesResponse;

import com.halconbit.todo.app.model.TodoItem;
import com.halconbit.todo.app.repository.TodoRepository;

@RestController
@RequestMapping("/todo")
@CrossOrigin(origins = "*")
public class TodoController {
	
	@Autowired
	private TodoRepository todoRepository;
	/**
	 * FrontEnd     ===> java-server 
	 * HTTP Request ===> Controller  ===> Service ===> Repository
	 * FrontEnd     <=== Controller  <=== Service <===
	 */
	
	@Autowired
	private TodoService todoService;
	
	ResponseHandler responseHandler = new ResponseHandler();
	
	/**
	 * Fetch all items (From database)
	 */
	@GetMapping("/")
	public ResponseEntity<?> index() {
		List<TodoItem> todoItems = todoService.index();
		
		return ResponseEntity.ok(todoItems);
	}
	
	@PostMapping("/new")
    public ResponseEntity<Object> create(@RequestBody TodoItem todoItem){
		try {
            //Optional<TodoItem> optionalCompany = todoRepository.findCompanyById( todoItem.getRfrnc() );
            //Optional<TodoItem> optionalCompany = todoRepository.findById(todoItem.getRfrnc());
            
            return responseHandler.response(HttpStatus.CREATED, MessagesResponse.CREATE.Of("Item"), this.todoService.save(todoItem));
            
        } catch (LazyInitializationException e) {
            return responseHandler.errorException(e);
        }
    }
}
