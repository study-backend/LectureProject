package edu.kosta.lecture.controller;

import java.util.List;

import edu.kosta.lecture.model.ClassRoom;
import edu.kosta.lecture.service.ClassRoomService;

public class ClassRoomController {
	private static ClassRoomService service = new ClassRoomService();

	public static void SelectAll() {
		List<ClassRoom> list = service.selectAll();

	}
	
	public static void insert(List<ClassRoom> list) {
		service.insert(list);
	}
	
	public static void update(ClassRoom room) {
		service.update(room);
	}

	public static void delete(List<String> ids) {
		service.delete(ids);
	}
}
