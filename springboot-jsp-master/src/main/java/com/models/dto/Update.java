package com.models.dto;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "update")
public class Update {

	int id;
	@NotNull
	// int taskId;
	// @NotNull
	Date time;
	@NotNull
	String message;

	@JsonManagedReference
	private Task taskRefference;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	@ManyToOne
	@JoinColumn(name = "task_id")
	public Task getTaskRefference() {
		return taskRefference;
	}

	public Update() {
	}

	public Update(String message) {
		this.message = message;
		this.time = Calendar.getInstance().getTime();
	}
	// public int getTaskId() {
	// return taskId;
	// }

	public Date getTime() {
		return time;
	}

	public String getMessage() {
		return message;
	}

	public Update setId(int id) {
		this.id = id;
		return this;
	}

	// public Update setTaskId(int taskId) {
	// this.taskId = taskId;
	// return this;
	// }

	public Update setTime(Date time) {
		this.time = time;
		return this;
	}

	public Update setMessage(String message) {
		this.message = message;
		return this;
	}

	public void setTaskRefference(Task taskRefference) {
		this.taskRefference = taskRefference;
	}

}
