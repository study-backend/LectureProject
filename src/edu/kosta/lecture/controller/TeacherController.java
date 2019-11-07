package edu.kosta.lecture.controller;

import java.util.List;

import edu.kosta.lecture.biz.TeacherBiz;
import edu.kosta.lecture.model.Teacher;
import edu.kosta.lecture.service.TeacherService;

public class TeacherController implements TeacherBiz {

	private static TeacherService service = new TeacherService();
	
	public static List<Teacher> selectAll() throws Exception {
		List<Teacher> list = service.selectAll();
		return list;
	}
	
	public static void insert(Teacher teacher) throws Exception {
		service.insert(teacher);
	}
	
	public static void update(Teacher teacher) throws Exception {
		service.update(teacher);
	}

	public static void delete(List<String> ids) throws Exception {
		service.delete(ids);
	}

	@Override
	public List<Teacher>  selectLectureMap(int teacherId) throws Exception {
		List<Teacher> list = service.selectLectureMap(teacherId);
		return list;
	}

	@Override
	public void insertLectureMap(List<Teacher> list) throws Exception {
		service.insertLectureMap(list);
		
	}
}
