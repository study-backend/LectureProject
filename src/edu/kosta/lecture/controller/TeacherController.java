package edu.kosta.lecture.controller;

import java.util.List;


import edu.kosta.lecture.model.Teacher;
import edu.kosta.lecture.service.TeacherService;

public class TeacherController {

	private static TeacherService service = new TeacherService();
	
	public static void selectAll() {
		List<Teacher> list = service.selectAll();
	}
}
