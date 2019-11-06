package edu.kosta.lecture.service;

import java.sql.SQLException;
import java.util.List;

import edu.kosta.lecture.biz.TeacherBiz;
import edu.kosta.lecture.dao.TeacherDAO;
import edu.kosta.lecture.model.Lecture;
import edu.kosta.lecture.model.Student;
import edu.kosta.lecture.model.Teacher;
import edu.kosta.lecture.util.UnitOfWork;
import edu.kosta.lecture.util.UnitOfWorkImpl;

public class TeacherService implements TeacherBiz {

	private TeacherDAO dao = new TeacherDAO();

	public List<Teacher> selectAll() {
		List<Teacher> list = dao.selectAll();

		return list;
	}
	
	public void insert(List<Teacher> list) {
		
		this.dao.insert(list);
	}
	//

	public void update(Teacher teacher) {
		
		this.dao.update(teacher);
	}

	
	public void delete(List<String> ids) {
			
		this.dao.delete(ids);
	}
		

	@Override
	public void selectLectureMap(int teacherId) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void insertLectureMap(List<Teacher> list) throws SQLException {
		UnitOfWork uow = new UnitOfWorkImpl();
		
		try {
			String sql = "INSERT INTO Teacher(TeacherId, TeacherName, RegistrationNumber, Address, PhoneNumber, Email, CreateDate, UpdateDate) VALUES(?, ?, ?, ?, ?, ?, ? )";
			dao.bulkinsert(list, uow.beginTransaction(sql));
			for(Teacher s : list) {
				List<Lecture> lectures = s.getLectureList();
				sql = "INSERT INTO (RoomCode, Capacity, CreateDate, UpdateDate) VALUES(?, ?, ?, ? )";
				dao.insertLectureMap(lectures, uow.beginTransaction(sql));
			}
			
			uow.commit();
			
		} catch(Exception e) {
			uow.rollback();
			
		} finally {
			uow.endTransaction();
		}
		
	}
}
