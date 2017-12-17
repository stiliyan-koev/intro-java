package com.markovski.dto;

public class EmployeeDTOForEmployer {

	int id;
	int departmentId;
	String job;
	long salary;
	int bonus;
	int comission;

	public EmployeeDTOForEmployer(Employee employee) {
		this.id = employee.id;
		this.departmentId = employee.departmentId;
		this.job = employee.job;
		this.salary = employee.salary;
		this.bonus = employee.bonus;
		this.comission = employee.comission;
	}

	public EmployeeDTOForEmployer(int id, int departmentId, String job, long salary, int bonus, int comission) {
		this.id = id;
		this.departmentId = departmentId;
		this.job = job;
		this.salary = salary;
		this.bonus = bonus;
		this.comission = comission;
	}

	public EmployeeDTOForEmployer() {

	}

	public EmployeeDTOForEmployer getEmployeeDTO() {
		return this;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public String getJob() {
		return job;
	}

	public long getSalary() {
		return salary;
	}

	public int getBonus() {
		return bonus;
	}

	public int getComission() {
		return comission;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	public void setComission(int comission) {
		this.comission = comission;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
