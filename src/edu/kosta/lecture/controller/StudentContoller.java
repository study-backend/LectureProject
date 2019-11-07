package edu.kosta.lecture.controller;

import java.util.List;

import edu.kosta.lecture.biz.StudentBiz;
import edu.kosta.lecture.model.Student;
import edu.kosta.lecture.service.StudentService;

public class StudentContoller implements StudentBiz {

	private static StudentService service = new StudentService();
	// ������ �޼ҵ� ȣ��
	public static List<Student> selectAll() throws Exception {
		List<Student> list = service.selectAll();
		return list;
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

	@Override
	public List<Student>  selectLectureMap(int studentId) throws Exception {
		List<Student> list = service.selectLectureMap(studentId);
		return list;
	}

	@Override
	public void insertLectureMap(List<Student> list) throws Exception {
		service.insertLectureMap(list);
		
	}
}
