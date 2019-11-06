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
		String sql = "select * from Student";

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
//////////////////////insert
	public void insert(Student student) throws Exception { {
		Connection con = null;
		PreparedStatement ps = null;

// Date 변환
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
			ps.setDate(7, sqlDate); // 생성 시간
			ps.setDate(8, sqlDate); // 수정 시간

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

// Date 변환
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

		String sql = "UPDATE Student SET  StudentName= ?, RegistrationNumber = ?, PhoneNumber = ?, Address = ? , "
						+ "Email = ?, UpdateDate = ? WHERE StudentId = ?";
// 수강 아이디가 "" 일 때 강의실,과목,시간 변경

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

		// Date 변환
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

		try {

			// bulk insert 처리
			for (Student s : list) {
				ps.setLong(1, s.getStudentId());
				ps.setString(2, s.getStudentName());
				ps.setString(3, s.getRegistrationNumber());
				ps.setString(4, s.getPhoneNumber());
				ps.setString(5, s.getAddress());
				ps.setString(6, s.getEmail());
				ps.setDate(7, sqlDate); // 생성 시간
				ps.setDate(8, sqlDate); // 수정 시간

				ps.addBatch(); // OraclePreparedStatement에 batch로 완성된 SQL 추가
				ps.clearParameters(); // OraclePreparedStatement에 지정된 Parameter값 초기화
			}

			ps.executeBatch(); // 누적된 batch 실행
			ps.clearBatch(); // 누적된 batch 초기화

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void insertLectureMap(List<Lecture> list, int studentId, PreparedStatement ps) {

		// Date 변환
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

		try {

			// bulk insert 처리
			for (Lecture l : list) {
		        ps.setInt(1, studentId);
		        ps.setInt(2, l.getLectureId());
				ps.setDate(3, sqlDate);
				ps.setDate(4, sqlDate);

				ps.addBatch(); // OraclePreparedStatement에 batch로 완성된 SQL 추가
				ps.clearParameters(); // OraclePreparedStatement에 지정된 Parameter값 초기화
			}

			ps.executeBatch(); // 누적된 batch 실행
			ps.clearBatch(); // 누적된 batch 초기화

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
