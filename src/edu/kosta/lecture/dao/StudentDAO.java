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

// Date ��ȯ
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

		String sql = "INSERT INTO Student(StudentId, StudentName, RegistrationNumber, PhoneNumber, Address, Email, CreateDate, UpdateDate) "
						+ "VALUES(?, ?, ?, ? ,? ,? , ?, ?)";

		try {
			con = DbUtil.getConnection();
			con.setAutoCommit(false); // �ڵ� commit ��

			ps = con.prepareStatement(sql);

// bulk insert ó��
			for (Student r : list) {
				ps.setLong(1, r.getStudentId());
				ps.setString(2, r.getStudentName());
				ps.setString(3, r.getRegistrationNumber());
				ps.setString(4, r.getPhoneNumber());
				ps.setString(5, r.getAddress());
				ps.setString(6, r.getEmail());
				ps.setDate(7, sqlDate); // ���� �ð�
				ps.setDate(8, sqlDate); // ���� �ð�

				ps.addBatch(); // OraclePreparedStatement�� batch�� �ϼ��� SQL �߰�?
				ps.clearParameters(); // OraclePreparedStatement�� ������ Parameter�� �ʱ�ȭ?
			}

			ps.executeBatch(); // ������ batch ����
			ps.clearBatch(); // ������ batch �ʱ�ȭ
			con.commit(); // Commit�Ͽ� ����

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
