package edu.kosta.lecture.service;

import java.util.List;

import edu.kosta.lecture.biz.TeacherBiz;
import edu.kosta.lecture.dao.TeacherDAO;
import edu.kosta.lecture.model.Teacher;

public class TeacherService implements TeacherBiz {

	private TeacherDAO dao = new TeacherDAO();

	public List<Teacher> selectAll() {
		List<Teacher> list = dao.selectAll();

		return list;
	}
	
	@Override
	public void SelectLectureMap(int teacherId) {
		// TODO Auto-generated method stub
		
	}
}
