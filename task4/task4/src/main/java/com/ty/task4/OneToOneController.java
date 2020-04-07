package com.ty.hibernateassignment4;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.hibernateassignment4.dto.StudentInfo;
import com.ty.hibernateassignment4.onetoone.StudentOtherInfo;

public class OneToOneController {
	public static void main(String[] args) {
		StudentInfo info = new StudentInfo();
		StudentOtherInfo otherInfo = new StudentOtherInfo();
		Scanner scanner = new Scanner(System.in);
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;


		System.out.println("Enter the primary information");
		System.out.println("Enter the Roll Number");
		int rollNum = scanner.nextInt();
		info.setRollNum(rollNum);
		
		System.out.println("Enter the student name");
		String name = scanner.next();
		info.setName(name);
		
		System.out.println("Enter the age");
		int age = scanner.nextInt();
		info.setAge(age);
		
		System.out.println("Enter the gender");
		String gender = scanner.next();
		info.setGender(gender);
		
		System.out.println("Enter the Mobile Number");
		long mobileNo = scanner.nextLong();
		info.setMobileNo(mobileNo);
		
		System.out.println("Enter the Email Id");
		String emailId = scanner.next();
		info.setEmailId(emailId);

		System.out.println("Enter the secondary information");
		System.out.println("Enter the Father Name");
		String fatherName = scanner.next();
		
		otherInfo.setFatherName(fatherName);
		System.out.println("Enter the Mother Name");
		String motherName = scanner.next();
		otherInfo.setMotherName(motherName);
		System.out.println("Enter the Religion");
		String religion = scanner.next();
		otherInfo.setReligion(religion);
		System.out.println("Enter the Nationality");
		String nationality = scanner.next();
		otherInfo.setNationality(nationality);
		otherInfo.setPrimary(info);

		try {	
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(otherInfo);
			transaction.commit();
			System.out.println("Record inserted");

		}  catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			manager.close();
			factory.close();
			scanner.close();
		}

	}
}
