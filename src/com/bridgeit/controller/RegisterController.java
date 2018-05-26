package com.bridgeit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bridgeit.dao.JdbcDao;


public class RegisterController extends HttpServlet{

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		PrintWriter out=response.getWriter();
		JdbcDao jdbcDao=new JdbcDao();
		
		String name=request.getParameter("username");
		String email=request.getParameter("email");
		String pass=request.getParameter("password");
		long number=Long.parseLong(request.getParameter("mobileNo"));
		String date=request.getParameter("dob");
		
		
		try {
			jdbcDao.registerInfo(name, email, pass, number, date);
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		out.println("Registered successfully..");
		response.sendRedirect("login.jsp");
		
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		doGet(request, response);
	}
}
