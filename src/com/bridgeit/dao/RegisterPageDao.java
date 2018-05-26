package com.bridgeit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterPageDao {

	String url = "jdbc:mysql://localhost:3306/RegisterDB";
	String username = "root";
	String password = "root";
	String sql = "insert into RegisterTable values(?,?,?,?,?)";

	public boolean registerInfo(String name, String email, String passwd, long number, String date)
			throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");

		Connection connection = DriverManager.getConnection(url, username, password);
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, email);
			preparedStatement.setString(3, passwd);
			preparedStatement.setLong(4, number);
			preparedStatement.setString(5, date);

			int result = preparedStatement.executeUpdate();
			System.out.println("result affected" + result);

		} catch (Exception e) {
			System.out.println(e);

		} finally {
			connection.close();
		}

		return false;

	}
}
