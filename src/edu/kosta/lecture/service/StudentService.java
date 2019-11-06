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
	

	public void insert(List<Student> list) {
		
		this.dao.insert(list);
	}
	//

	public void update(Student student) {
		
		this.dao.update(student);
	}

	
	public void delete(List<String> ids) {
			
		this.dao.delete(ids);
	}
		
	
	@Override
	public void SelectLectureMap(int studentId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertLectureMap(List<Student> list) throws SQLException {
		UnitOfScope uos = new UnitOfScopeImpl();
		
		try {
			String sql = "INSERT INTO Student(RoomCode, Capacity, CreateDate, UpdateDate) VALUES(?, ?, ?, ? )";
			dao.bulkInsert(list, uos.beginTransaction(sql));
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
