package edu.kosta.lecture.biz;


import java.util.List;

import edu.kosta.lecture.model.Student;

public interface StudentBiz {

	void selectLectureMap(int studentId) throws Exception;
	
	void insertLectureMap(List<Student> list ) throws Exception;


}
