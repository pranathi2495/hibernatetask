package com.ty.task2.controller;

import java.util.List;
import java.util.Scanner;

import com.ty.task2.dao.ProductDAO;
import com.ty.task2.dao.ProductDAOFactory;
import com.ty.task2.dto.ProductsInfo;

public class ProductsController {
	public static void main(String[] args) {
		ProductDAO dao = ProductDAOFactory.getInstance();
		ProductsInfo info = new ProductsInfo();

		try(Scanner scanner = new Scanner(System.in)) {

			System.out.println("Details of products name starts with letter A");
			List<ProductsInfo> info3 = dao.getAllCustomerInfoStartsWithA();
			for(ProductsInfo info4:info3) {
				System.out.println("Product ID: "+info4.getProductId());
				System.out.println("Product Name:"+info4.getProductName());
				System.out.println("Colour: "+info4.getColour());
				System.out.println("Price: "+info4.getPrice());
				System.out.println("Weight"+info4.getWeight());
				System.out.println("--------------------------------------");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
}
