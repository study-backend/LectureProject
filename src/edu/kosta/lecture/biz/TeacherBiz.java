package edu.kosta.lecture.biz;


import java.util.List;

import edu.kosta.lecture.model.Teacher;

public interface TeacherBiz {
	
	void selectLectureMap(int teacherId);
	
	void insertLectureMap(List<Teacher> list) throws Exception;

}
