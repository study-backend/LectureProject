package edu.kosta.lecture.service;

import java.util.List;

import edu.kosta.lecture.biz.LectureBiz;
import edu.kosta.lecture.dao.LectureDAO;
import edu.kosta.lecture.model.Lecture;

public class LectureService implements LectureBiz {

	private LectureDAO dao = new LectureDAO(); //DAOÀÇ  
	
	public List<Lecture> selectAll() {
		List<Lecture> list = dao.selectAll();
		
		return list;
		
	}
	
	@Override
	public void SelectStudentMap(int lectureId) {
		// TODO Auto-generated method stub
		
	}
	
}
