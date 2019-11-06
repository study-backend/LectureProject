package edu.kosta.lecture.service;

import java.util.List;

import edu.kosta.lecture.dao.TeacherDAO;
import edu.kosta.lecture.model.Teacher;

public class TeacherService {

	private TeacherDAO dao = new TeacherDAO();

	public List<Teacher> selectAll() {
		List<Teacher> list = dao.selectAll();

		return list;
	}
}
