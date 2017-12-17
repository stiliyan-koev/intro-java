package com.markovski.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class User implements Serializable {

	private int id;
	private String firstName;
	@NotNull
	private String lastName;
	@NotNull
	private Date dob;
	@NotNull
	private String phone;
	@NotNull
	private String email;
	@NotNull
	private boolean isEmployer;
	@NotNull
	private String accountName;
	@NotNull
	private String password;

	private Employer employerRefference;

	private Employee employeeRefference;

	public User() {
	}

	public User(String firstName, String lastName, Date dob, String phone, String email, boolean isEmployer,
			String accountName, String password, Employer employerRefference) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.phone = phone;
		this.email = email;
		this.isEmployer = isEmployer;
		this.accountName = accountName;
		this.password = password;
		this.employerRefference = employerRefference;
	}

	public User(String firstName, String lastName, Date dob, String phone, String email, boolean isEmployer,
			String accountName, String password, Employee employeeRefference) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.phone = phone;
		this.email = email;
		this.isEmployer = isEmployer;
		this.accountName = accountName;
		this.password = password;
		this.employeeRefference = employeeRefference;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "employer_id")
	public Employer getEmployerRefference() {
		return employerRefference;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_id")
	public Employee getEmployeeRefference() {
		return employeeRefference;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setEmployerRefference(Employer employerRefference) {
		this.employerRefference = employerRefference;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Date getDob() {
		return dob;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public boolean isEmployer() {
		return isEmployer;
	}

	public String getAccountName() {
		return accountName;
	}

	public String getPassword() {
		return password;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setEmployer(boolean isEmployer) {
		this.isEmployer = isEmployer;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmployeeRefference(Employee employeeRefference) {
		this.employeeRefference = employeeRefference;
	}

}
