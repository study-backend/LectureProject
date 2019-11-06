package edu.kosta.lecture.controller;

import java.util.List;

import edu.kosta.lecture.model.Student;
import edu.kosta.lecture.service.StudentService;

public class StudentContoller {

	private static StudentService service = new StudentService();
	// 서비스의 메소드 호출
	public static void selectAll() {
		List<Student> list = service.selectAll();
	}
	
	public static void insert(List<Student> list) {
		service.insert(list);
	}
	
	public static void update(Student student) {
		service.update(student);
	}

	public static void delete(List<String> ids) {
		service.delete(ids);
	}
}
