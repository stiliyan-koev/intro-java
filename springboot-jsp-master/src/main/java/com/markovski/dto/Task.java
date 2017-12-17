package com.markovski.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name = "task")
public class Task {

	int id;
	// @NotNull
	// int employeeId;
	@NotNull
	String title;
	@NotNull
	String assignees;

	private Employee employee;
	private List<Update> updates;

	public Task() {
	}

	public Task(String title, String assignees) {
		this.title = title;
		this.assignees = assignees;
	}

	public Task(String title, String assignees, List<Update> updates) {
		this.title = title;
		this.assignees = assignees;
		this.updates = updates;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	@OneToOne(mappedBy = "taskRefference")
	@NotFound(action = NotFoundAction.IGNORE)
	public Employee getEmployee() {
		return employee;
	}

	@OneToMany(mappedBy = "taskRefference")
	public List<Update> getUpdates() {
		return updates;
	}

	// public int getEmployeeId() {
	// return employeeId;
	// }

	public String getTitle() {
		return title;
	}

	public String getAssignees() {
		return assignees;
	}

	public Task setId(int id) {
		this.id = id;
		return this;
	}

	// public Task setEmployeeId(int employeeId) {
	// this.employeeId = employeeId;
	// return this;
	// }

	public Task setTitle(String title) {
		this.title = title;
		return this;
	}

	public Task setAssignees(String assignees) {
		this.assignees = assignees;
		return this;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void setUpdates(List<Update> updates) {
		this.updates = updates;
	}
}
