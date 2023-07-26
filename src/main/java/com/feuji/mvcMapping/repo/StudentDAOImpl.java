package com.feuji.mvcMapping.repo;

import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.feuji.mvcMapping.entity.Student;
@Repository
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	private SessionFactory factory;

	@Override
	public void insert(Student student) {
		Session currSession = factory.getCurrentSession();
		currSession.saveOrUpdate(student);
	}

	@Override
	public List<Student> fetchData() {
		Session currSession=factory.getCurrentSession();	
		NativeQuery<Student> nativeQuery= currSession.createNativeQuery("select * from student", Student.class);
		return nativeQuery.getResultList();
	}

	@Override
	public void delete(int id) {
		Session currSession=factory.getCurrentSession();	
//		Student student=currSession.get(Student.class, id);
//		currSession.delete(student);
		Query theQuery = 
				currSession.createQuery("delete from Student where id=:stuId");
	      theQuery.setParameter("stuId", id);
	 
	      theQuery.executeUpdate();    
		
	}

	@Override
	public Student getById(int id) {	
		Session session=factory.getCurrentSession();
		Student student= session.get(Student.class, id);
		return student;
	}

}
