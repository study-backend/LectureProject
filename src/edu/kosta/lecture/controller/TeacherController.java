package edu.kosta.lecture.controller;

import java.util.List;


import edu.kosta.lecture.model.Teacher;
import edu.kosta.lecture.service.TeacherService;

public class TeacherController {

	private static TeacherService service = new TeacherService();
	
	public static void selectAll() {
		List<Teacher> list = service.selectAll();
	}
	
	public static void insert(List<Teacher> list) {
		service.insert(list);
	}
	
	public static void update(Teacher teacher) {
		service.update(teacher);
	}

	public static void delete(List<String> ids) {
		service.delete(ids);
	}
}
