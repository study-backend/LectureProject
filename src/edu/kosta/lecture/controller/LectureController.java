package edu.kosta.lecture.controller;

import java.util.List;

import edu.kosta.lecture.model.Lecture;
import edu.kosta.lecture.service.LectureService;

public class LectureController {

	private static LectureService service = new LectureService();

	// ���񽺿��� ������ �����͸� ���� ��ü ����
	public static void selectAll() {
		List<Lecture> list = service.selectAll();

	}
}
