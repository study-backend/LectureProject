package edu.kosta.lecture.controller;

import java.util.List;

import edu.kosta.lecture.model.Student;
import edu.kosta.lecture.service.StudentService;

public class StudentContoller {

	private static StudentService service = new StudentService();
	// ������ �޼ҵ� ȣ��
	public static void selectAll() {
		List<Student> list = service.selectAll();
	}
}
