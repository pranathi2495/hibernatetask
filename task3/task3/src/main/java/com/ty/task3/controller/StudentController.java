package com.ty.task3.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import com.ty.task3.dao.StudentDAO;
import com.ty.task3.dao.StudentDAOFactory;
import com.ty.task3.dto.StudentInfo;


public class StudentController {
	public static void main(String[] args) {
		StudentDAO dao = StudentDAOFactory.getInstance();
		StudentInfo info = new StudentInfo();

		try(Scanner scanner = new Scanner(System.in); 
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));) {

			//To insert the data
			/*System.out.println("Enter the Student Information");
			System.out.println("Enter the Student roll number");
			int rollNum = scanner.nextInt();
			info.setRollNum(rollNum);;
			System.out.println("Enter the student First name");
			String firstName = scanner.next();
			info.setFirstName(firstName);
			System.out.println("Enter the student Last name");
			String lastName = scanner.next();
			info.setLastName(lastName);
			System.out.println("Enter the subject name");
			String subject = bufferedReader.readLine();
			info.setSubject(subject);;
			System.out.println("Enter the total marks");
			double totalMarks = scanner.nextDouble();
			info.setTotalMarks(totalMarks);			
			boolean isInserted = dao.createStudentInfo(info);

			if(isInserted) {
				System.out.println("Student Information is added");
			} else {
				System.out.println("Student Information is not added");
			}*/

			//To get the details of students first name and total marks
			/*System.out.println("Details of students first name and total marks");
			List<Object []> info1 = dao.getAllFirstNameandtotalMarks();
			for(Object[] a:info1) {
				System.out.println("--------------------------------------");
				System.out.println("Student First Name: "+a[0]);
				System.out.println("Total marks: "+a[1]);
				System.out.println("--------------------------------------");
			}*/
			
			//To get all the details of student with the help of roll number and student
			/*System.out.println("Details of student with the help of roll number and student");
			System.out.println("Enter the roll Number");
			int rollNum = scanner.nextInt();
			System.out.println("Enter the subject name");
			String subject = bufferedReader.readLine();
			StudentInfo info2 = dao.getStudentDetailrollNumandSubject(rollNum, subject);
			System.out.println("First Name: "+info2.getFirstName());
			System.out.println("Last Name: "+info2.getLastName());
			System.out.println("Roll Number: "+info2.getRollNum());
			System.out.println("Subject: "+info2.getSubject());
			System.out.println("Total Marks: "+info2.getTotalMarks());*/
			
			//To get the aggregate of Min
			/*double min = dao.findAggregateMin();
			System.out.println("---------------------------");
			System.out.println("MIN(totalMarks): "+min);*/
			
			//To get the aggregate of Min
			/*double max = dao.findAggregateMax();
			System.out.println("---------------------------");
			System.out.println("MAX(totalMarks): "+max);*/
			
			//To get the aggregate of AVG
			double avg = dao.findAggregateAvg();
			System.out.println("---------------------------");
			System.out.println("AVG(totalMarks): "+avg);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
