package edu.kosta.lecture.service;

import java.sql.SQLException;
import java.util.List;

import edu.kosta.lecture.biz.StudentBiz;
import edu.kosta.lecture.dao.StudentDAO;
import edu.kosta.lecture.model.Lecture;
import edu.kosta.lecture.model.Student;
import edu.kosta.lecture.util.UnitOfScope;
import edu.kosta.lecture.util.UnitOfScopeImpl;

public class StudentService implements StudentBiz {
	private StudentDAO dao = new StudentDAO();
	
	public List<Student> selectAll() {
		List<Student> list = dao.selectAll();
		return list;
	}
	

	@Override
	public void selectLectureMap(int studentId) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertLectureMap(List<Student> list) throws SQLException {
		UnitOfScope uos = new UnitOfScopeImpl();
		
		try {
			String sql = "INSERT INTO Student(RoomCode, Capacity, CreateDate, UpdateDate) VALUES(?, ?, ?, ? )";
			dao.insert(list, uos.beginTransaction(sql));
			for(Student s : list) {
				List<Lecture> lectures = s.getLectureList();
				sql = "INSERT INTO Student(RoomCode, Capacity, CreateDate, UpdateDate) VALUES(?, ?, ?, ? )";
				dao.insertLectureMap(lectures, uos.beginTransaction(sql));
			}
			
			uos.commit();
			
		} catch(Exception e) {
			uos.rollback();
			
		} finally {
			uos.endTransaction();
		}

	}
}
