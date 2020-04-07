package com.ty.task3.dao;

import java.util.List;

import com.ty.task3.dto.StudentInfo;

public interface StudentDAO {

	boolean createStudentInfo(StudentInfo info);
	List<Object[]> getAllFirstNameandtotalMarks();
	StudentInfo getStudentDetailrollNumandSubject(int rollNum, String subject);
	double findAggregateMin();
	double findAggregateMax();
	double findAggregateAvg();
}
