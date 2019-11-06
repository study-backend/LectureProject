package edu.kosta.lecture.service;

import java.util.List;

import edu.kosta.lecture.biz.LectureBiz;
import edu.kosta.lecture.dao.LectureDAO;
import edu.kosta.lecture.model.Lecture;

public class LectureService implements LectureBiz {
	private LectureDAO dao = new LectureDAO();
	@Override
	public void SelectStudentMap(int lectureId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void SelectTeacherMap(int lectureId) {
		// TODO Auto-generated method stub
		
	}

	
	public List<Lecture> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
