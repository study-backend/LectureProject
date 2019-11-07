package edu.kosta.lecture.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.kosta.lecture.model.Lecture;
import edu.kosta.lecture.model.Student;
import edu.kosta.lecture.util.DbUtil;

public class StudentDAO {

	public List<Student> selectAll() throws Exception {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Student> list = new ArrayList<Student>();
		String sql = "SELECT StudentId, StudentName, RegistrationNumber, PhoneNumber, Adress, Email, "
						+ "CreateDate, UpdateDate FROM Student";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				Student student = new Student();
				student.setStudentId(rs.getLong("StudentId"));
				student.setStudentName(rs.getString("StudentName"));
				student.setRegistrationNumber(rs.getString("RegistrationNumber"));
				student.setPhoneNumber(rs.getString("PhoneNumber"));
				student.setAddress(rs.getString("Adress"));
				student.setEmail(rs.getString("Email"));
				student.setCreateDate(rs.getDate("CreateDate"));
				student.setUpdateDate(rs.getDate("UpdateDate"));

				list.add(student);

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}
	
	public Student selectById(long studentId) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Student s = null;
		String sql = "SELECT StudentId, StudentName, RegistrationNumber, PhoneNumber, Adress, Email, "
						+ "CreateDate, UpdateDate FROM Student WHERE StudentId = ?";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setLong(1, studentId);
			rs = ps.executeQuery();

			while (rs.next()) {
				s = new Student();
				s.setStudentId(rs.getLong("StudentId"));
				s.setStudentName(rs.getString("StudentName"));
				s.setRegistrationNumber(rs.getString("RegistrationNumber"));
				s.setPhoneNumber(rs.getString("PhoneNumber"));
				s.setAddress(rs.getString("Adress"));
				s.setEmail(rs.getString("Email"));
				s.setCreateDate(rs.getDate("CreateDate"));
				s.setUpdateDate(rs.getDate("UpdateDate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return s;
	}
	
//////////////////////insert
	public void insert(Student student) throws Exception { 
		Connection con = null;
		PreparedStatement ps = null;

// Date ��ȯ
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

		String sql = "INSERT INTO Student(StudentId, StudentName, RegistrationNumber, PhoneNumber, Address, Email, CreateDate, UpdateDate) "
						+ "VALUES(?, ?, ?, ? ,? ,? , ?, ?)";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setLong(1, student.getStudentId());
			ps.setString(2, student.getStudentName());
			ps.setString(3, student.getRegistrationNumber());
			ps.setString(4, student.getPhoneNumber());
			ps.setString(5, student.getAddress());
			ps.setString(6, student.getEmail());
			ps.setDate(7, sqlDate); // ���� �ð�
			ps.setDate(8, sqlDate); // ���� �ð�

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		} finally {
			DbUtil.dbClose(con, ps);
		}
	}
	
//////////////////////update
	public void update(Student student) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;

// Date ��ȯ
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

		String sql = "UPDATE Student SET  StudentName= ?, RegistrationNumber = ?, PhoneNumber = ?, Address = ? , "
						+ "Email = ?, UpdateDate = ? WHERE StudentId = ?";
// ���� ���̵� "" �� �� ���ǽ�,����,�ð� ����

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);

			ps.setString(1, student.getStudentName());
			ps.setString(2, student.getRegistrationNumber());
			ps.setString(3, student.getPhoneNumber());
			ps.setString(4, student.getAddress());
			ps.setString(5, student.getEmail());
			ps.setDate(6, sqlDate);
			ps.setLong(7, student.getStudentId());

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		} finally {
			DbUtil.dbClose(con, ps);
		}
	}
	
//////////////////////delete
	public void delete(List<String> ids) throws Exception  {
		Connection con = null;
		PreparedStatement ps = null;

		String sql = "DELETE FROM Student  WHERE StudentId in (?)";
		String param = "";
		for (int i = 0; i < ids.size(); i++) {
			if ((i + 1) == ids.size())
				param = param + ids.get(i);
			else
				param = param + ids.get(i) + ",";
		}

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);

			ps.setString(1, param);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		} finally {
			DbUtil.dbClose(con, ps);
		}
	}

	public void bulkInsert(List<Student> list, PreparedStatement ps) {

		// Date ��ȯ
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

		try {

			// bulk insert ó��
			for (Student s : list) {
				ps.setLong(1, s.getStudentId());
				ps.setString(2, s.getStudentName());
				ps.setString(3, s.getRegistrationNumber());
				ps.setString(4, s.getPhoneNumber());
				ps.setString(5, s.getAddress());
				ps.setString(6, s.getEmail());
				ps.setDate(7, sqlDate); // ���� �ð�
				ps.setDate(8, sqlDate); // ���� �ð�

				ps.addBatch(); // OraclePreparedStatement�� batch�� �ϼ��� SQL �߰�
				ps.clearParameters(); // OraclePreparedStatement�� ������ Parameter�� �ʱ�ȭ
			}

			ps.executeBatch(); // ������ batch ����
			ps.clearBatch(); // ������ batch �ʱ�ȭ

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void insertLectureMap(List<Lecture> list, long studentId, PreparedStatement ps) throws Exception {

		// Date ��ȯ
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

		try {

			// bulk insert ó��
			for (Lecture r : list) {
				ps.setLong(1, r.getLectureId());
				ps.setInt(2, r.getRoomCode());
				ps.setInt(3, r.getSubjectCode());
				ps.setInt(4, r.getTime());
				ps.setDate(5, sqlDate); // ���� �ð�
				ps.setDate(6, sqlDate); // ���� �ð�

				ps.addBatch(); // OraclePreparedStatement�� batch�� �ϼ��� SQL �߰�
				ps.clearParameters(); // OraclePreparedStatement�� ������ Parameter�� �ʱ�ȭ
			}

			ps.executeBatch(); // ������ batch ����
			ps.clearBatch(); // ������ batch �ʱ�ȭ

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
	}
	public List<Lecture> selectMap(long studentId) throws Exception {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Lecture> list = new ArrayList<Lecture>();
		String sql = "SELECT StudentId, StudentName, RegistrationNumber, PhoneNumber, Adress, Email, S.CreateDate, S.UpdateDate, "
				+ "L.LectureId, RoomCode, SubjectCode, Time, L.CreateDate, L.UpdateDate FROM Student S "
				+ "INNER JOIN StudentMap SM ON S.StudentId = SM.StudentId "
				+ "INNER JOIN Lecture L ON SM.LectureId = L.LectureId WHERE S.StudentId = ?";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setLong(1, studentId);
			rs = ps.executeQuery();

			while (rs.next()) {
				Lecture lecture = new Lecture();
				lecture.setLectureId(rs.getLong("LectureId"));
				lecture.setRoomCode(rs.getInt("RoomCode"));
				lecture.setSubjectCode(rs.getInt("SubjectCode"));
				lecture.setTime(rs.getInt("Time"));
				lecture.setCreateDate(rs.getDate("CreateDate"));
				lecture.setUpdateDate(rs.getDate("UpdateDate"));
				
				list.add(lecture);

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

}


