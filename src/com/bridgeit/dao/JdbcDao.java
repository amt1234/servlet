package com.bridgeit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcDao {

	private static final String URL = "jdbc:mysql://localhost:3306/RegisterDB";
	private static final String USERNAME = "root";
	private static final String PASSWORDD = "root";

	public static boolean checkLogin(String email, String pass) {

		try {
			Class.forName("com.mysql.jdbc.Driver");

			try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORDD)) {
				String sql = "select * from RegisterTable where email=? and password=?";
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, email);
				preparedStatement.setString(2, pass);

				ResultSet resultSet = preparedStatement.executeQuery();
				System.out.println("selected result affected :" + resultSet);
				if (resultSet.next()) {
					return true;
				}
			}
		} catch (Exception e) {
			System.out.println(e);

		}

		return false;

	}

	public static boolean registerInfo(String name, String email, String pass, long number, String date) {

		try {
			Class.forName("com.mysql.jdbc.Driver");

			try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORDD)) {

				PreparedStatement preparedStatement = connection
						.prepareStatement("insert into RegisterTable values(?,?,?,?,?)");
				preparedStatement.setString(1, name);
				preparedStatement.setString(2, email);
				preparedStatement.setString(3, pass);
				preparedStatement.setLong(4, number);
				preparedStatement.setString(5, date);

				int result = preparedStatement.executeUpdate();
				System.out.println("inserted result affected :" + result);

			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
}
