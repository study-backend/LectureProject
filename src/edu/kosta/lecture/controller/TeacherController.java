package edu.kosta.lecture.controller;

import java.util.List;


import edu.kosta.lecture.model.Teacher;
import edu.kosta.lecture.service.TeacherService;

public class TeacherController {

	private static TeacherService service = new TeacherService();
	
	public static void selectAll() throws Exception {
		List<Teacher> list = service.selectAll();
	}
	
	public static void insert(Teacher teacher) throws Exception {
		service.insert(teacher);
	}
	
	public static void update(Teacher teacher) throws Exception {
		service.update(teacher);
	}

	public static void delete(List<String> ids) throws Exception {
		service.delete(ids);
	}
}
