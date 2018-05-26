package com.bridgeit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcDao {

	String url = "jdbc:mysql://localhost:3306/RegisterDB";
	String username = "root";
	String passwordd = "root";
	String sql = "select * from RegisterTable where email=? and password=?";

	public boolean checkLogin(String email,String pass) throws ClassNotFoundException, SQLException
		{
		
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection connection=DriverManager.getConnection(url, username, passwordd);
			try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, pass);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			System.out.println("selected result affected :"+resultSet);
			if(resultSet.next())
			{
				return true;
			}
			
		}catch(Exception e){
			System.out.println(e);
			
		}
		
		return false;
		
	}

	public boolean registerInfo(String name, String email, String pass, long number, String date)
				throws ClassNotFoundException, SQLException {

			Class.forName("com.mysql.jdbc.Driver");

			Connection connection = DriverManager.getConnection(url, username, passwordd);
			try {
				PreparedStatement preparedStatement = connection.prepareStatement("insert into RegisterTable values(?,?,?,?,?)");
				preparedStatement.setString(1, name);
				preparedStatement.setString(2, email);
				preparedStatement.setString(3, pass);
				preparedStatement.setLong(4, number);
				preparedStatement.setString(5, date);

				int result = preparedStatement.executeUpdate();
				System.out.println("inserted result affected :" + result);

			} catch (Exception e) {
				System.out.println(e);
			}
			finally {
				connection.close();
			}
			return false;
	}
}
