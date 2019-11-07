package edu.kosta.lecture.controller;

import java.util.List;

import edu.kosta.lecture.model.Lecture;
import edu.kosta.lecture.service.LectureService;

public class LectureController {

	private static LectureService service = new LectureService();

	// ���񽺿��� ������ �����͸� ���� ��ü ����
	public static List<Lecture> selectAll() throws Exception {
		List<Lecture> list = service.selectAll();
		return list;
	}
	
	public static void insert(List<Lecture> list) throws Exception {
		service.insert(list);
	}
	
	public static void update(Lecture lecture) throws Exception {
		service.update(lecture);
	}

	public static void delete(List<String> ids) throws Exception {
		service.delete(ids);
	}
}
