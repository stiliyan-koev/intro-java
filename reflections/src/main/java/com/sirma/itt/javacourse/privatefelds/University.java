package com.sirma.itt.javacourse.privatefelds;

/**
 * Class presenting an university.
 * 
 * @author Stiliyan Koev.
 */
public class University {
	private int privateNumber = 10;
	private String privateString = "this is private string";
	private String studentName = "default empty private student name";
	private long facultyNumber = 1;
	private int studentCourse = 1;

	/**
	 * Getter for privateNumber.
	 * 
	 * @return - return an Integer value of privateNumber.
	 */
	public int getPrivateNumber() {
		return privateNumber;
	}

	/**
	 * Setter for privateNumber.
	 * 
	 * @param privateNumber
	 *            - private number.
	 */
	public void setPrivateNumber(int privateNumber) {
		this.privateNumber = privateNumber;
	}

	/**
	 * Getter for studentName.
	 * 
	 * @return - return an String value of studentName.
	 */
	@SuppressWarnings("unused")
	private String getStudentName() {
		return studentName;
	}

	/**
	 * Setter for studentName.
	 * 
	 * @param studentName
	 *            - a student name.
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	/**
	 * Getter for facultyNumber.
	 * 
	 * @return - return an Long value of facultyNumber.
	 */
	@SuppressWarnings("unused")
	private long getFacultyNumber() {
		return facultyNumber;
	}

	/**
	 * Setter for facultyNumber.
	 * 
	 * @param facultyNumber
	 *            - A faculty number.
	 */
	public void setFacultyNumber(long facultyNumber) {
		this.facultyNumber = facultyNumber;
	}

	/**
	 * Getter for studentCourse.
	 * 
	 * @return - return an Integer value of studentCourse.
	 */
	@SuppressWarnings("unused")
	private int getStudentCourse() {
		return studentCourse;
	}

	/**
	 * Setter for studentCourse.
	 * 
	 * @param studentCourse
	 *            - A student course.
	 */
	public void setStudentCourse(int studentCourse) {
		this.studentCourse = studentCourse;
	}

	/**
	 * Getter for privateString.
	 * 
	 * @return - return an String information for privateString.
	 */
	public String getPrivateString() {
		return privateString;
	}

	/**
	 * Setter for privateString.
	 * 
	 * @param privateString
	 *            - A private string.
	 */
	public void setPrivateString(String privateString) {
		this.privateString = privateString;
	}

}
