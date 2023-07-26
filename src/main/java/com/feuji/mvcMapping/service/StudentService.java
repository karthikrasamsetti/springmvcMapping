package com.feuji.mvcMapping.service;

import java.util.List;

import com.feuji.mvcMapping.entity.StudentBean;

public interface StudentService {
	public void insert(StudentBean bean);
	public List<StudentBean> fetchData();
	public void delete(int id);
	public StudentBean get(int id);


}
