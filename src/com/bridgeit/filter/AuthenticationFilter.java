package com.bridgeit.filter;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AuthenticationFilter implements Filter {
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {

	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		PrintWriter out = response.getWriter();
		String username = request.getParameter("email");
		String password = request.getParameter("pass");
	
		try {
			if (!(username==null) && !(password==null)) {
				chain.doFilter(request, response);

			} else {
				out.println("You entered wrong username or password ");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
				requestDispatcher.include(request, response);

			}
		
		} catch (Exception e) {

			System.out.println(e);
		} finally {
			out.close();
		}
	}

	public void destroy() {
	}

}
