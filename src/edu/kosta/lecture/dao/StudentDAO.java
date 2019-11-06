package edu.kosta.lecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.kosta.lecture.model.Student;
import edu.kosta.lecture.util.DbUtil;

public class StudentDAO {

	public List<Student> selectAll() {

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

		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}
//////////////////////insert
	public void insert(List<Student> list) {
		Connection con = null;
		PreparedStatement ps = null;

// Date 변환
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

		String sql = "INSERT INTO Student(StudentId, StudentName, RegistrationNumber, PhoneNumber, Address, Email, CreateDate, UpdateDate) "
						+ "VALUES(?, ?, ?, ? ,? ,? , ?, ?)";

		try {
			con = DbUtil.getConnection();
			con.setAutoCommit(false); // 자동 commit 끔

			ps = con.prepareStatement(sql);

// bulk insert 처리
			for (Student r : list) {
				ps.setLong(1, r.getStudentId());
				ps.setString(2, r.getStudentName());
				ps.setString(3, r.getRegistrationNumber());
				ps.setString(4, r.getPhoneNumber());
				ps.setString(5, r.getAddress());
				ps.setString(6, r.getEmail());
				ps.setDate(7, sqlDate); // 생성 시간
				ps.setDate(8, sqlDate); // 수정 시간

				ps.addBatch(); // OraclePreparedStatement에 batch로 완성된 SQL 추가?
				ps.clearParameters(); // OraclePreparedStatement에 지정된 Parameter값 초기화?
			}

			ps.executeBatch(); // 누적된 batch 실행
			ps.clearBatch(); // 누적된 batch 초기화
			con.commit(); // Commit하여 적용

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			DbUtil.dbClose(con, ps);
		}
	}
	
//////////////////////update
	public void update(Student student) {
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

		} finally {
			DbUtil.dbClose(con, ps);
		}
	}
	
//////////////////////delete
	public void delete(List<String> ids) {
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

		} finally {
			DbUtil.dbClose(con, ps);
		}
	}
	
}
