package com.feuji.mvcMapping.repo;

import java.util.List;

import com.feuji.mvcMapping.entity.Marks;



public interface MarksDAO {
	public void insertMarks(Marks marks);
	public List<Marks> fetchData();
	public void delete(int id);
	public Marks update(int id);
	
}
