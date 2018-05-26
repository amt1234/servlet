package com.bridgeit.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regexv {

	public static void main(String[] args) {

		String username="Priyanka";
		String email="abc@gmail.com";
		String password="abcd1234";
		long mobileNo=Long.parseLong("9934561234");
		String dob="2000-09-10";
		
		try {
			
			if (((username != null) &&(regexname(username)==true))&&((email != null)&&(regexemail(email)==true)) && ((password != null)&&(password.length()>6)) && (((1111111111)*7)<mobileNo && mobileNo>(9*1111111111)) && !(dob == null)) {
				System.out.println("valid info");
			} 
			else {
				System.out.println("invalid info");
			}

		} catch (Exception e) {

			System.out.println(e);
		} finally {
			
		}
	}
	
	
	public static boolean regexname(String username)
	{
		Pattern pattern=Pattern.compile("[a-zA-Z]*");
		Matcher matcher=pattern.matcher(username);
		if(matcher.find()&& matcher.group().equals(username))
		{
			return true;
		}
		return false;
	}
	public static boolean regexemail(String email)
	{
		Pattern pattern=Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9_.]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
		Matcher matcher=pattern.matcher(email);
		if(matcher.find()&& matcher.group().equals(email))
		{
			return true;
		}
		return false;
	}
//	public static boolean regexMobile(long mobileNo)
//	{
//		Pattern pattern=Pattern.compile("[7-9]{1}[0-9]{9}");
//		Matcher matcher=pattern.matcher(mobileNo);
//		if(matcher.find()&& matcher.group().equals(mobileNo))
//		{
//			return true;
//		}
//		return false;
//	}
//	

	

}
