package edu.kosta.lecture.biz;


import java.util.List;

import edu.kosta.lecture.model.Teacher;

public interface TeacherBiz {
	
	List<Teacher> selectLectureMap(int teacherId) throws Exception;
	
	void insertLectureMap(List<Teacher> list) throws Exception;

}
