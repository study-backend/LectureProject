package edu.kosta.lecture.service;

import java.util.List;

import edu.kosta.lecture.biz.TeacherBiz;
import edu.kosta.lecture.dao.TeacherDAO;
import edu.kosta.lecture.model.Lecture;
import edu.kosta.lecture.model.Teacher;
import edu.kosta.lecture.util.UnitOfWork;
import edu.kosta.lecture.util.UnitOfWorkImpl;

public class TeacherService implements TeacherBiz {

	private TeacherDAO dao = new TeacherDAO();

	public List<Teacher> selectAll() throws Exception {
		List<Teacher> list = dao.selectAll();

		return list;
	}

	public void insert(Teacher teacher) throws Exception {

		this.dao.insert(teacher);
	}

	public void update(Teacher teacher) throws Exception {

		this.dao.update(teacher);
	}

	public void delete(List<String> ids) throws Exception {

		this.dao.delete(ids);
	}

	@Override
	public void selectLectureMap(int teacherId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertLectureMap(List<Teacher> list) throws Exception {
		UnitOfWork uow = new UnitOfWorkImpl();

		try {

			String sql = "INSERT INTO Teacher(TeacherId, TeacherName, RegistrationNumber, Address, PhoneNumber, Email, CreateDate, UpdateDate) VALUES(?, ?, ?, ?, ?, ?, ? )";
			dao.bulkInsert(list, uow.beginTransaction(sql));

			for (Teacher s : list) {
				List<Lecture> lectures = s.getLectureList();
				sql = "INSERT INTO (RoomCode, Capacity, CreateDate, UpdateDate) VALUES(?, ?, ?, ? )";
				dao.insertLectureMap(lectures, uow.beginTransaction(sql));
			}
			uow.commit();
		} catch (Exception e) {
			uow.rollback();
			throw e;
		} finally {
			uow.endTransaction();
		}

	}

}
