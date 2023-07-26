package com.feuji.mvcMapping.entity;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Component
@Data
@RequiredArgsConstructor
public class StudentBean {

	private int id;
	private String name;
	private int age;
	private String branch;
	private int maths;
	private int english;
	private int social;
	private int totalMarks;
	private int percentage;
	public StudentBean(int id, String name, int age, String branch, int maths, int english, int social, int totalMarks,
			int percentage) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.branch = branch;
		this.maths = maths;
		this.english = english;
		this.social = social;
		this.totalMarks = totalMarks;
		this.percentage = percentage;
	}


}
