package com.models.dto;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "employee")
public class Employee {

	int id;

	@NotNull
	String firstName;
	@NotNull
	String midName;
	@NotNull
	String familyName;
	@NotNull
	int departmentId;
	@NotNull
	String phone;
	@NotNull
	@JsonFormat(pattern = "yyyy-MM-dd")
	Date hireDate;
	@NotNull
	String job;
	@NotNull
	int yearEducation;
	@NotNull
	boolean gender;
	@NotNull
	@JsonFormat(pattern = "yyyy-MM-dd")
	Date birthDate;
	@NotNull
	long salary;
	@NotNull
	int bonus;
	@NotNull
	int comission;
	@NotNull
	boolean active;
	@JsonManagedReference
	private Employer employerRefference;
	@JsonIgnore
	private Task taskRefference;
	private User user;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	@JsonIgnore
	@OneToOne(mappedBy = "employeeRefference")
	@NotFound(action = NotFoundAction.IGNORE)
	public User getUser() {
		return user;
	}

	@ManyToOne
	@JoinColumn(name = "employer_id")
	public Employer getEmployerRefference() {
		return employerRefference;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "task_id")
	public Task getTaskRefference() {
		return taskRefference;
	}

	public Employee(String firstName, String midName, String familyName, int departmentId, String phone, Date hireDate,
			String job, int yearEducation, boolean gender, Date birthDate, int salary, int bonus, int comission,
			boolean active) {
		this.firstName = firstName;
		this.midName = midName;
		this.familyName = familyName;
		this.departmentId = departmentId;
		this.phone = phone;
		this.hireDate = hireDate;
		this.job = job;
		this.yearEducation = yearEducation;
		this.gender = gender;
		this.birthDate = birthDate;
		this.salary = salary;
		this.bonus = bonus;
		this.comission = comission;
		this.active = active;
	}

	public Employee() {
	}

	public String getFirstName() {
		return firstName;
	}

	public String getMidName() {
		return midName;
	}

	public String getFamilyName() {
		return familyName;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public String getPhone() {
		return phone;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public String getJob() {
		return job;
	}

	public int getYearEducation() {
		return yearEducation;
	}

	public boolean isGender() {
		return gender;
	}

	public Date getBirthDate() {
		return birthDate;
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

	public boolean isActive() {
		return active;
	}

	public Employee setId(int id) {
		this.id = id;
		return this;
	}

	public Employee setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public Employee setMidName(String midName) {
		this.midName = midName;
		return this;
	}

	public Employee setFamilyName(String familyName) {
		this.familyName = familyName;
		return this;
	}

	public Employee setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
		return this;
	}

	public Employee setPhone(String phone) {
		this.phone = phone;
		return this;
	}

	public Employee setHireDate(Date hireDate) {
		this.hireDate = hireDate;
		return this;
	}

	public Employee setJob(String job) {
		this.job = job;
		return this;
	}

	public Employee setYearEducation(int yearEducation) {
		this.yearEducation = yearEducation;
		return this;
	}

	public Employee setGender(boolean gender) {
		this.gender = gender;
		return this;
	}

	public Employee setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
		return this;
	}

	public Employee setSalary(long salary) {
		this.salary = salary;
		return this;
	}

	public Employee setBonus(int bonus) {
		this.bonus = bonus;
		return this;
	}

	public Employee setComission(int comission) {
		this.comission = comission;
		return this;
	}

	public Employee setActive(boolean active) {
		this.active = active;
		return this;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + familyName + ", dob=" + birthDate
				+ ", phone=" + phone + "employer ID: " + "]";
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setEmployerRefference(Employer employerRefference) {
		this.employerRefference = employerRefference;
	}

	public void setTaskRefference(Task taskRefference) {
		this.taskRefference = taskRefference;
	}
}
