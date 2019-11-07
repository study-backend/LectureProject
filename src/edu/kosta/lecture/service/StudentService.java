package edu.kosta.lecture.service;

import java.util.ArrayList;
import java.util.List;

import edu.kosta.lecture.biz.StudentBiz;
import edu.kosta.lecture.dao.StudentDAO;
import edu.kosta.lecture.model.Lecture;
import edu.kosta.lecture.model.Student;
import edu.kosta.lecture.util.UnitOfWork;
import edu.kosta.lecture.util.UnitOfWorkImpl;

public class StudentService implements StudentBiz {
	private StudentDAO dao = new StudentDAO();
	
	public List<Student> selectAll() throws Exception {
		List<Student> list = dao.selectAll();
		return list;
	}

	public void insert(Student student) throws Exception {
		
		this.dao.insert(student);
	}
	//

	public void update(Student student) throws Exception {
		
		this.dao.update(student);
	}

	
	public void delete(List<String> ids) throws Exception {
			
		this.dao.delete(ids);
	}
		
	
	
	@Override
	public List<Student> selectLectureMap(int studentId) throws Exception {
		List<Student> list = new ArrayList<Student>();
		Student student = this.dao.selectById(studentId);
		if(student != null) {
			List<Lecture> lectures = this.dao.selectMap(studentId);
			student.setLectureList(lectures);
			list.add(student);
		}
		return list;
	}
	

	@Override
	public void insertLectureMap(List<Student> list) throws Exception {
		UnitOfWork uow = new UnitOfWorkImpl();
		
		try {
			String sql = "INSERT INTO Student(StudentId, StudentName, RegistrationNumber, PhoneNumber, Address, Email, CreateDate, UpdateDate) VALUES(?, ?, ?, ? ,? ,? , ?, ?)";
			dao.bulkInsert(list, uow.beginTransaction(sql));
			for(Student s : list) {
				List<Lecture> lectures = s.getLectureList();
				sql = "INSERT INTO StudentMap(LectureId, StudentId, CreateDate, UpdateDate) VALUES(?, ?, ?, ? )";
				dao.insertLectureMap(lectures, s.getStudentId(), uow.beginTransaction(sql));
			}
			
			uow.commit();
			
		} catch(Exception e) {
			uow.rollback();
			throw e;
			
		} finally {
			uow.endTransaction();
		}

	}
	
}
