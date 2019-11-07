package edu.kosta.lecture.controller;

import java.util.List;

import edu.kosta.lecture.model.ClassRoom;
import edu.kosta.lecture.service.ClassRoomService;

public class ClassRoomController {
	private static ClassRoomService service = new ClassRoomService();

	public static List<ClassRoom> selectAll() throws Exception {
		List<ClassRoom> list = service.selectAll();
		return list;
	}
	
	public static void insert(List<ClassRoom> list) throws Exception {
		service.insert(list);
	}
	
	public static void update(ClassRoom room) throws Exception {
		service.update(room);
	}

	public static void delete(List<String> ids) throws Exception {
		service.delete(ids);
	}
}
