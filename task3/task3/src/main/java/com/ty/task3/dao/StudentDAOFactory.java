package com.ty.task3.dao;

public class StudentDAOFactory {

	private StudentDAOFactory() {
		
	}
	private static String  dbInteractionType = "hibernate";
	
	public static StudentDAO getInstance() {
		StudentDAO dao = null;
		
		if (dbInteractionType.equals("hibernate")) {
			dao = new StudentDAOHibernateImplement();
		} 
		return dao;
	}

}
