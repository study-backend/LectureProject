package edu.kosta.lecture.controller;

import java.util.List;


import edu.kosta.lecture.model.Subject;
import edu.kosta.lecture.service.SubjectService;

public class SubjectController {

	private static SubjectService service = new SubjectService();

	public static void selectAll() {
		List<Subject> list = service.selectAll();
	}
	
	public static void insert(List<Subject> list) {
		service.insert(list);
	}
	
	public static void update(Subject subject) {
		service.update(subject);
	}

	public static void delete(List<String> ids) {
		service.delete(ids);
	}
}
