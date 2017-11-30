package com.jsp.project.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import com.jsp.project.user.User;

/**
 * Data access object for Users in data base.
 * 
 * @author Stiliyan Koev.
 */
public class UserDao {
	private static Connection connection = null;

	/**
	 * Static class for getting the connection.
	 * 
	 * @return - Connection to data base.
	 */
	public static Connection getConnection() {
		if (connection != null)
			return connection;
		else {
			try {
				Properties prop = new Properties();
				InputStream inputStream = UserDao.class.getClassLoader().getResourceAsStream("/db.properties");
				prop.load(inputStream);
				String driver = prop.getProperty("driver");
				String url = prop.getProperty("url");
				String user = prop.getProperty("user"); // user
				String password = prop.getProperty("password"); // password
				Class.forName(driver);
				connection = DriverManager.getConnection(url, user, password);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return connection;
		}

	}

	/**
	 * Saving a new or edited user.
	 * 
	 * @param user
	 *            - User to be saved.
	 * @return - Status. 1 for success 0 for fail.
	 */
	public static int save(User user) {
		int status = 0;
		Date date = new Date();
		try {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into users(firstName,lastName,dob,email,phone) values (?, ?, ?, ?, ? )");
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			date = new SimpleDateFormat("dd/MM/yyyy").parse(user.getDob().toString());
			preparedStatement.setDate(3, new java.sql.Date(date.getTime()));
			preparedStatement.setString(4, user.getEmail());
			preparedStatement.setString(5, user.getPhone());
			status = preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	/**
	 * Updating an user.
	 * 
	 * @param user
	 *            - User to be updated.
	 * @return - Status. 1 for success 0 for fail.
	 */
	public static int update(User user) {
		int status = 0;
		try {
			Connection con = getConnection();
			PreparedStatement preparedStatement = con
					.prepareStatement("update users set firstName=?,lastName=?,dob=?,email=?,phone=? where id=?");
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getDob());
			preparedStatement.setString(4, user.getEmail());
			preparedStatement.setString(5, user.getPhone());
			preparedStatement.setInt(6, user.getId());
			status = preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	/**
	 * Deleting an user.
	 * 
	 * @param user
	 *            - User to be deleted.
	 * @return - Status. 1 for success 0 for fail.
	 */
	public static int delete(User user) {
		int status = 0;
		try {
			Connection connection = getConnection();
			PreparedStatement ps = connection.prepareStatement("delete from users where id=?");
			ps.setInt(1, user.getId());
			status = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}

		return status;
	}

	public static List<User> getAllRecords() {
		List<User> list = new ArrayList<User>();

		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select * from users");
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getInt("id"));
				user.setFirstName(resultSet.getString("firstName"));
				user.setLastName(resultSet.getString("lastName"));
				user.setDob(resultSet.getString("dob"));
				user.setEmail(resultSet.getString("email"));
				user.setPhone(resultSet.getString("phone"));
				list.add(user);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	/**
	 * Accessing a record by given id.
	 * 
	 * @param id
	 *            - Id of which record to be accessed.
	 * @return - An object of User with the found exception.
	 */
	public static User getRecordById(int id) {
		User user = null;
		try {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from users where id=?");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				user = new User();
				user.setId(resultSet.getInt("id"));
				user.setFirstName(resultSet.getString("firstName"));
				user.setLastName(resultSet.getString("lastName"));
				user.setDob(resultSet.getString("dob"));
				user.setEmail(resultSet.getString("email"));
				user.setPhone(resultSet.getString("phone"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return user;
	}
}