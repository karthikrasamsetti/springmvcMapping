package com.feuji.mvcMapping.repo;


import java.util.List;


import com.feuji.mvcMapping.entity.Student;

public interface StudentDAO {

	public void insert(Student student);
	public List<Student> fetchData();
	public void delete(int id);
	public Student getById(int id);
	
}
