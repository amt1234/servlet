package com.bridgeit.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

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
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		long mobileNo = Long.parseLong(request.getParameter("mobileNo"));
		String dob = request.getParameter("dob");

		try {
			if (((username != null) && (regexname(username) == true))
					&& ((email != null) && (regexemail(email) == true))
					&& ((password != null) && (password.length() > 6))
					&& (((1111111111) * 7) < mobileNo && mobileNo > (9 * 1111111111)) && !(dob == null)) {
				chain.doFilter(request, response);

			} else {
				out.println("You entered wrong Information ");
				HttpServletResponse httpServletResponse = (HttpServletResponse) response;
				httpServletResponse.sendRedirect("login.jsp");
			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			out.close();
		}
	}

	public void destroy() {
	}

	public boolean regexname(String username) {
		Pattern pattern = Pattern.compile("[a-zA-Z]*");
		Matcher matcher = pattern.matcher(username);
		if (matcher.find() && matcher.group().equals(username)) {
			return true;
		}
		return false;
	}

	public boolean regexemail(String email) {
		Pattern pattern = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9_.]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
		Matcher matcher = pattern.matcher(email);
		if (matcher.find() && matcher.group().equals(email)) {
			return true;
		}
		return false;
	}

}
