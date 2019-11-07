package edu.kosta.lecture.controller;

import java.util.List;


import edu.kosta.lecture.model.Subject;
import edu.kosta.lecture.service.SubjectService;

public class SubjectController {

	private static SubjectService service = new SubjectService();

	public static List<Subject> selectAll() throws Exception {
		List<Subject> list = service.selectAll();
		return list;
	}
	
	public static void insert(List<Subject> list) throws Exception {
		service.insert(list);
	}
	
	public static void update(Subject subject) throws Exception {
		service.update(subject);
	}

	public static void delete(List<String> ids) throws Exception {
		service.delete(ids);
	}
}
