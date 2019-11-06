package edu.kosta.lecture.biz;

import java.sql.SQLException;
import java.util.List;

import edu.kosta.lecture.model.Student;

public interface StudentBiz {

	void selectLectureMap(int studentId) throws SQLException;
	
	void insertLectureMap(List<Student> list ) throws SQLException;
}
