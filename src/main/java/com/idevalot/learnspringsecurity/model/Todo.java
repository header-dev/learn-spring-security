package com.idevalot.learnspringsecurity.model;

public class Todo {

	private String name;
	private String description;

	public Todo(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Todo [name=" + name + ", description=" + description + "]";
	}

}
