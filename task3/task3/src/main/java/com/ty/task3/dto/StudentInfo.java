package com.ty.task3.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="studentinfo")
public class StudentInfo implements Serializable {
	@Id
	private int rollNum;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String subject;
	@Column
	private double totalMarks;
}
