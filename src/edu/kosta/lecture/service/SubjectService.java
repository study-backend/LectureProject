package edu.kosta.lecture.service;

import java.util.List;

import edu.kosta.lecture.dao.SubjectDAO;
import edu.kosta.lecture.model.Subject;

public class SubjectService {

	private SubjectDAO dao = new SubjectDAO();
	
	public List<Subject> selectAll() {
		List<Subject> list = dao.selectAll();
		return list; //controller�� ����Ʈ�� ������ ����
	}
	
	public void insert(List<Subject> list) {
		
		this.dao.insert(list);
	}
	//

	public void update(Subject subject) {
		
		this.dao.update(subject);
	}

	
	public void delete(List<String> ids) {
			
		this.dao.delete(ids);
	}
		
	
}
