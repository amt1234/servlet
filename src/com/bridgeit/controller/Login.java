package com.bridgeit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgeit.dao.JdbcDao;

/**
 * Servlet implementation class LoginJsp
 */
public class Login extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username=request.getParameter("email");
		String password=request.getParameter("pass");
	
		try {
			if(JdbcDao.checkLogin(username,password))
			{
				HttpSession httpSession=request.getSession();
				httpSession.setAttribute("Username",username);
				
				Cookie cookie=new Cookie("username",username);
				
				response.sendRedirect("welcome.jsp");
			}
			else
			{
				response.sendRedirect("login.jsp");			 
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
