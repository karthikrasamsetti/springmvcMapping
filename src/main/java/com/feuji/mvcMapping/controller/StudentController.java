package com.feuji.mvcMapping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.feuji.mvcMapping.entity.StudentBean;
import com.feuji.mvcMapping.service.StudentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class StudentController {
	@Autowired
	private StudentService service;

	@GetMapping(value = "/insert")
	public ModelAndView insert() {
		return new ModelAndView("data", "studentBean", new StudentBean());
	}

	@PostMapping(value = "/showDetails")
	public String notify(StudentBean studentBean, ModelMap map) {

		map.put("studentBean", studentBean);
		System.out.println(map);
		service.insert(studentBean);
		return "redirect:/datatable";

	}

	@GetMapping(value = "/datatable")
	public ModelAndView getAllStudents() {
		List<StudentBean> beans = service.fetchData();
		System.out.println(beans);
		return new ModelAndView("studentData", "studentBean", beans);
	}

	@GetMapping(value = "/delete")
	public String deleteDetails(@RequestParam("stuId") int id) {
		log.error("id:", id);
		service.delete(id);
		return "redirect:/datatable";
	}

	@GetMapping(value = "/update")
	public ModelAndView update(@RequestParam("stuId") int id) {

		StudentBean bean = service.get(id);
		return new ModelAndView("data", "studentBean", bean);
	}

//	@PostMapping(value = "/show")
//	public String get(StudentBean studentBean, ModelMap map) {
//		System.out.println("show started");
//		map.put("studentBean", studentBean);
//		service.update(studentBean);
//		return "redirect:/datatable";
//
//	}

}
