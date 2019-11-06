package edu.kosta.lecture.controller;

import java.util.List;

import edu.kosta.lecture.model.ClassRoom;
import edu.kosta.lecture.service.ClassRoomService;

public class ClassRoomController {
	private static ClassRoomService service = new ClassRoomService();

	public static void SelectAll() {
		List<ClassRoom> list = service.SelectAll();
		
	}

	
	
}
