package edu.kosta.lecture.service;

import java.util.List;

import edu.kosta.lecture.dao.ClassRoomDAO;
import edu.kosta.lecture.model.ClassRoom;

public class ClassRoomService {
	private ClassRoomDAO dao = new ClassRoomDAO();
	
	public List<ClassRoom> SelectAll() {
		List<ClassRoom> list = dao.selectAll();
		return list;
	}

}
