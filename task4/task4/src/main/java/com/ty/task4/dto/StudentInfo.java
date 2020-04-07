package com.ty.task4.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ty.task4.onetoone.StudentOtherInfo;

import lombok.Data;

@Data
@Entity
@Table(name="student_information")
public class StudentInfo implements Serializable{
	@Id
	private int rollNum;
	@Column
	private String name;
	@Column
	private int age;
	@Column
	private String gender;
	@Column
	private long mobileNo;
	@Column
	private String emailId;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "primary")
	private StudentOtherInfo studentOtherInfo;
}
