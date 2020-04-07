package com.ty.task2.dao;


public class ProductDAOFactory {
	private ProductDAOFactory() {

	}
	private static String  dbInteractionType = "hibernate";

	public static ProductDAO getInstance() {
		ProductDAO dao = null;

		if (dbInteractionType.equals("hibernate")) {
			dao = new ProductDAOHibernateImplement();
		} 
		return dao;
	}
}
