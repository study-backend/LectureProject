package edu.kosta.lecture.service;

import java.util.List;

import edu.kosta.lecture.dao.StudentDAO;
import edu.kosta.lecture.model.Student;

public class StudentService {
	private StudentDAO dao = new StudentDAO();
	
	public List<Student> selectAll() {
		List<Student> list = dao.selectAll();
		return list;
	}
}
