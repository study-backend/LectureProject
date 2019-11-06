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
	
}
