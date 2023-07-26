package com.feuji.mvcMapping.repo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.feuji.mvcMapping.entity.Marks;
@Repository
@Transactional
public class MarksDAOImpl implements MarksDAO {

	@Autowired
	private SessionFactory factory;
	@Override
	public void insertMarks(Marks marks) {
		// TODO Auto-generated method stub
		Session currSession = factory.getCurrentSession();

		currSession.saveOrUpdate(marks);

	}
	@Override
	public List<Marks> fetchData() {
		Session currSession=factory.getCurrentSession();	
		NativeQuery<Marks> nativeQuery= currSession.createNativeQuery("select * from marks", Marks.class);
		return nativeQuery.getResultList();
	}

	@Override
	public void delete(int id) {
		Session currSession=factory.getCurrentSession();	
		Marks marks=currSession.get(Marks.class, id);
		currSession.delete(marks);
		
	}

	@Override
	public Marks update(int id) {
		
		Session session=factory.getCurrentSession();
		Marks marks= session.get(Marks.class, id);
		return marks;
	}
	}


