package com.feuji.mvcMapping.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@Entity
@RequiredArgsConstructor
public class Marks implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int maths;
	private int english;
	private int social;
	private int totalMarks;
	@OneToOne(cascade = CascadeType.ALL,mappedBy =  "marks")
	private Student student;

	public Marks( int maths, int english, int social) {
		super();
		this.maths = maths;
		this.english = english;
		this.social = social;
	}
	
}
