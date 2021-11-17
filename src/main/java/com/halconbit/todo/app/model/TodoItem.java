package com.halconbit.todo.app.model;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "0_todoapp")
public class TodoItem {
	
	/**
	 * Long stores 2^63 - 1 bytes = 9,223,372,036,854,775,807
	 * Integer                    =             2,147,483,647
	 */	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Rfrnc;
	private String task;
	private String description;
	private Boolean Cndtn;
	
	public Long getRfrnc() {
		return Rfrnc;
	}
	public void setRfrnc(Long rfrnc) {
		Rfrnc = rfrnc;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getCndtn() {
		return Cndtn;
	}
	public void setCndtn(Boolean cndtn) {
		Cndtn = cndtn;
	}
	
}
