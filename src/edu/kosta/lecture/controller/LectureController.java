package edu.kosta.lecture.controller;

import java.util.List;

import edu.kosta.lecture.model.Lecture;
import edu.kosta.lecture.service.LectureService;

public class LectureController {

	private static LectureService service = new LectureService();

	// 서비스에서 가져올 데이터를 담을 객체 생성
	public static void selectAll() {
		List<Lecture> list = service.selectAll();

	}
}
