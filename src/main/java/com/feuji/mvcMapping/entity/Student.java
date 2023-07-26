package com.feuji.mvcMapping.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;



@Data
@Entity
@RequiredArgsConstructor
public class Student implements Serializable  {
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int age;
	private String branch;
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "marks_id",referencedColumnName = "id")
	private Marks marks;
	public Student(String name, int age, String branch, Marks marks) {
		super();
		this.name = name;
		this.age = age;
		this.branch = branch;
		this.marks = marks;
	}
	
}
