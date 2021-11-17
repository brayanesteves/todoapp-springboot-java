package com.halconbit.todo.app.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.halconbit.todo.app.model.TodoItem;


@Repository
public interface TodoRepository extends JpaRepository<TodoItem, Long> {		
	
	
}
