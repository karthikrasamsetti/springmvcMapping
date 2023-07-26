package com.feuji.mvcMapping.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.feuji.mvcMapping.entity.Marks;
import com.feuji.mvcMapping.entity.Student;
import com.feuji.mvcMapping.entity.StudentBean;
import com.feuji.mvcMapping.repo.MarksDAO;
import com.feuji.mvcMapping.repo.StudentDAO;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDAO studentDAO;
	@Autowired
	MarksDAO marksDAO;

	@Override
	public void insert(StudentBean bean) {
		Student student = studentDAO.getById(bean.getId());
		if (student != null) {
			Marks marks = student.getMarks();
			marks.setMaths(bean.getMaths());
			marks.setEnglish(bean.getEnglish());
			marks.setSocial(bean.getSocial());
			marks.setTotalMarks(bean.getMaths() + bean.getEnglish() + bean.getSocial());
			student.setName(bean.getName());
			student.setAge(bean.getAge());
			student.setBranch(bean.getBranch());

			studentDAO.insert(student);
		}
		else {
		Marks marks = new Marks(bean.getMaths(), bean.getEnglish(), bean.getSocial());
		Student stu = new Student(bean.getName(), bean.getAge(), bean.getBranch(), marks);
			
		int sum = marks.getMaths() + marks.getEnglish() + marks.getSocial();
		marks.setTotalMarks(sum);
		int percentage = (sum / 3);
		studentDAO.insert(stu);
		}
	}

	@Override
	public List<StudentBean> fetchData() {
		List<Student> slist = studentDAO.fetchData();
		//List<StudentBean> list = new ArrayList<>();
//		for (Student student : slist) {
//			int sum = student.getMarks().getTotalMarks();
//			int percentage = (sum / 3);
//			StudentBean bean = new StudentBean(student.getId(), student.getName(), student.getAge(),
//					student.getBranch(), student.getMarks().getMaths(), student.getMarks().getEnglish(),
//					student.getMarks().getSocial(), sum, percentage);
//			list.add(bean);
//		}
		List<StudentBean> list1 = slist.stream()
			    .map(student -> {
			        int sum = student.getMarks().getTotalMarks();
			        int percentage = (sum / 3);
			        return new StudentBean(student.getId(), student.getName(), student.getAge(), student.getBranch(),
			            student.getMarks().getMaths(), student.getMarks().getEnglish(), student.getMarks().getSocial(),
			            sum, percentage);
			    })
			    .collect(Collectors.toList());


		return list1;
	}

	@Override
	public void delete(int id) {
		System.out.println(id);
		studentDAO.delete(id);
		marksDAO.delete(id);
	}
	@Override
	public StudentBean get(int id) {

		Student student = studentDAO.getById(id);
		int sum = student.getMarks().getTotalMarks();
		int percentage = (sum / 3);
		StudentBean studentBean = new StudentBean(student.getId(), student.getName(), student.getAge(),
				student.getBranch(), student.getMarks().getMaths(), student.getMarks().getEnglish(),
				student.getMarks().getSocial(), sum, percentage);
		System.out.println(studentBean);
		return studentBean;
	}

}
