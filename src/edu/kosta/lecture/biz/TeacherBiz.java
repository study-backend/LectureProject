package edu.kosta.lecture.biz;

import java.sql.SQLException;
import java.util.List;

import edu.kosta.lecture.model.Teacher;

public interface TeacherBiz {
	
	public void selectLectureMap(int teacherId);
	
	public void insertLectureMap(List<Teacher> list) throws SQLException;

}
