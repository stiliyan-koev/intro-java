package com.markovski.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "employer")
public class Employer {

	private int id;
	private User user;

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
	Date hireDate;
	@NotNull
	boolean gender;
	@NotNull
	Date birthDate;
	@NotNull
	int salary;
	@NotNull
	int bonus;
	@NotNull
	int comission;
	@JsonBackReference
	private List<Employee> employees;

	public Employer(String firstName, String midName, String familyName, int departmentId, String phone, Date hireDate,
			boolean gender, Date birthDate, int salary, int comission, int bonus) {
		this.firstName = firstName;
		this.midName = midName;
		this.familyName = familyName;
		this.departmentId = departmentId;
		this.phone = phone;
		this.hireDate = hireDate;
		this.gender = gender;
		this.birthDate = birthDate;
		this.salary = salary;
		this.bonus = bonus;
		this.comission = comission;
	}

	public Employer() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	@JsonIgnore
	@OneToOne(mappedBy = "employerRefference")
	public User getUser() {
		return user;
	}

	@OneToMany(mappedBy = "employerRefference")
	public List<Employee> getEmployees() {
		return employees;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setUser(User user) {
		this.user = user;
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

	public boolean isGender() {
		return gender;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public int getSalary() {
		return salary;
	}

	public int getBonus() {
		return bonus;
	}

	public int getComission() {
		return comission;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setMidName(String midName) {
		this.midName = midName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	public void setComission(int comission) {
		this.comission = comission;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}
