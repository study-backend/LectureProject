package edu.kosta.lecture.controller;

import java.util.List;

import edu.kosta.lecture.model.Student;
import edu.kosta.lecture.service.StudentService;

public class StudentContoller {

	private static StudentService service = new StudentService();
	// 서비스의 메소드 호출
	public static void selectAll() throws Exception {
		List<Student> list = service.selectAll();
	}
	
	public static void insert(Student student) throws Exception {
		service.insert(student);
	}
	
	public static void update(Student student) throws Exception {
		service.update(student);
	}

	public static void delete(List<String> ids) throws Exception {
		service.delete(ids);
	}
}
