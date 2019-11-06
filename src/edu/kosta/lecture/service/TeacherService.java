package edu.kosta.lecture.service;

import java.sql.SQLException;
import java.util.List;

import edu.kosta.lecture.biz.TeacherBiz;
import edu.kosta.lecture.dao.TeacherDAO;
import edu.kosta.lecture.model.Lecture;
import edu.kosta.lecture.model.Student;
import edu.kosta.lecture.model.Teacher;
import edu.kosta.lecture.util.UnitOfScope;
import edu.kosta.lecture.util.UnitOfScopeImpl;

public class TeacherService implements TeacherBiz {

	private TeacherDAO dao = new TeacherDAO();

	public List<Teacher> selectAll() {
		List<Teacher> list = dao.selectAll();

		return list;
	}

	@Override
	public void selectLectureMap(int teacherId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertLectureMap(List<Teacher> list) throws SQLException {
		UnitOfScope uos = new UnitOfScopeImpl();
		
		try {
			String sql = "INSERT INTO Student(RoomCode, Capacity, CreateDate, UpdateDate) VALUES(?, ?, ?, ? )";
			dao.insert(list, uos.beginTransaction(sql));
			for(Teacher s : list) {
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
