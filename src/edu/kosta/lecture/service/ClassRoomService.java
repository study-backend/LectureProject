package edu.kosta.lecture.service;


import java.util.List;

import edu.kosta.lecture.dao.ClassRoomDAO;
import edu.kosta.lecture.model.ClassRoom;

public class ClassRoomService {
	private ClassRoomDAO dao = new ClassRoomDAO();
	
	public List<ClassRoom> selectAll() {
		List<ClassRoom> list = dao.selectAll();
		return list;
	}
	
	
	public void insert(List<ClassRoom> list) {
		
		this.dao.insert(list);
	}
	//

	public void update(ClassRoom room) {
		
		this.dao.update(room);
	}

	
	public void delete(List<String> ids) {
			
		this.dao.delete(ids);
	}
		
		
	
	}


