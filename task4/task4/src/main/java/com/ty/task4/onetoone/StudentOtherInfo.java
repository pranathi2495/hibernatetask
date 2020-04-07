package com.ty.task4.onetoone;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ty.task4.dto.StudentInfo;

import lombok.Data;
@Data
@Entity
@Table(name="student_other_information")
public class StudentOtherInfo implements Serializable {
	@Id
	private int rollNum;
	@Column
	private String fatherName;
	@Column
	private String motherName;
	@Column
	private String religion;
	@Column
	private String nationality; 
	@MapsId
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "rollNum")
	private StudentInfo primary;
}
