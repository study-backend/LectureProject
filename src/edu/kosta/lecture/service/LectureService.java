package edu.kosta.lecture.service;

import java.util.List;

import edu.kosta.lecture.biz.LectureBiz;
import edu.kosta.lecture.dao.LectureDAO;
import edu.kosta.lecture.model.Lecture;
import edu.kosta.lecture.model.Student;

public class LectureService implements LectureBiz {
	private LectureDAO dao = new LectureDAO();
	
	public List<Lecture> selectAll() throws Exception {
		List<Lecture> list = dao.selectAll();
		return list;
	}
	

	public void insert(List<Lecture> list) throws Exception {
		
		this.dao.insert(list);
	}
	//

	public void update(Lecture lecture) throws Exception {
		
		this.dao.update(lecture);
	}

	
	public void delete(List<String> ids) throws Exception {
			
		this.dao.delete(ids);
	}


	@Override
	public void selectStudentMap(int lectureId) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void selectTeacherMap(int lectureId) {
		// TODO Auto-generated method stub
		
	}


	

}
