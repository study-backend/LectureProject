package edu.kosta.lecture.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.kosta.lecture.model.Lecture;
import edu.kosta.lecture.model.Teacher;
import edu.kosta.lecture.util.DbUtil;

public class TeacherDAO {

	public List<Teacher> selectAll() throws Exception {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Teacher> list = new ArrayList<Teacher>();
		String sql = "select * from Teacher";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				Teacher teacher = new Teacher();

				teacher.setTeacherId(rs.getLong("TeacherId"));
				teacher.setTeacherName(rs.getString("TeacherName"));
				teacher.setRegistrationNumber(rs.getString("RegistrationNumber"));
				teacher.setPhoneNumber(rs.getString("PhoneNumber"));
				teacher.setAddress(rs.getString("Adress"));
				teacher.setEmail(rs.getString("Email"));
				teacher.setCreateDate(rs.getDate("CreateDate"));
				teacher.setUpdateDate(rs.getDate("UpdateDate"));

				list.add(teacher);

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
	public void insert(Teacher teacher) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;

		//Date ��ȯ
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

		String sql = "INSERT INTO Teacher(TeacherId, TeacherName, RegistrationNumber, PhoneNumber, Address, Email, CreateDate, UpdateDate) "
				+ "VALUES(?, ?, ?, ? ,? ,? , ?, ?)";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);


			ps.setLong(1, teacher.getTeacherId());
			ps.setString(2, teacher.getTeacherName());
			ps.setString(3, teacher.getRegistrationNumber());
			ps.setString(4, teacher.getPhoneNumber());
			ps.setString(5, teacher.getAddress());
			ps.setString(6, teacher.getEmail());
			ps.setDate(7, sqlDate); // ���� �ð�
			ps.setDate(8, sqlDate); // ���� �ð�

			ps.executeBatch(); // ������ batch ����

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		} finally {
			DbUtil.dbClose(con, ps);
		}
	}

//////////////////////update
	public void update(Teacher teacher) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;

		//Date ��ȯ
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

		String sql = "UPDATE Teacher SET  TeacherName= ?, RegistrationNumber = ?, PhoneNumber = ?, Address = ? , "
				+ "Email = ?, UpdateDate = ? WHERE TeacherId = ?";
		//����  ���̵� "" �� �� ��� ���� ����

		try {
			con = DbUtil.getConnection(); // ����
			ps = con.prepareStatement(sql); // SQL�� �غ�

			ps.setString(1, teacher.getTeacherName());
			ps.setString(2, teacher.getRegistrationNumber());
			ps.setString(3, teacher.getPhoneNumber());
			ps.setString(4, teacher.getAddress());
			ps.setString(5, teacher.getEmail());
			ps.setDate(6, sqlDate);
			ps.setLong(7, teacher.getTeacherId());

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		} finally {
			DbUtil.dbClose(con, ps);
		}
	}

//////////////////////delete
	public void delete(List<String> ids) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;

		String sql = "DELETE FROM Teacher  WHERE TeacherId in (?)";
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


	public void bulkinsert(List<Teacher> list, PreparedStatement ps) {
		
		// Date ��ȯ
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		
		try {
			
			// bulk insert ó��
			for (Teacher r : list) {
				ps.setInt(1, r());
				ps.setInt(2, r.getCapacity());
				ps.setDate(3, sqlDate);
				ps.setDate(4, sqlDate);

				ps.addBatch(); // OraclePreparedStatement�� batch�� �ϼ��� SQL �߰�
				ps.clearParameters(); // OraclePreparedStatement�� ������ Parameter�� �ʱ�ȭ
			}
			
			ps.executeBatch(); // ������ batch ����
			ps.clearBatch(); // ������ batch �ʱ�ȭ
			
		} catch (Exception e) {
			e.printStackTrace();

		} 
	}

	public void insertLectureMap(List<Lecture> list, PreparedStatement ps) {
		
		// Date ��ȯ
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		
		

		try {
			
			// bulk insert ó��
			for (Lecture r : list) {
				//ps.setInt(1, r());
				//ps.setInt(2, r.getCapacity());
				ps.setDate(3, sqlDate);
				ps.setDate(4, sqlDate);

				ps.addBatch(); // OraclePreparedStatement�� batch�� �ϼ��� SQL �߰�
				ps.clearParameters(); // OraclePreparedStatement�� ������ Parameter�� �ʱ�ȭ
			}
			
			ps.executeBatch(); // ������ batch ����
			ps.clearBatch(); // ������ batch �ʱ�ȭ
			
		} catch (Exception e) {
			e.printStackTrace();

		} 
	}
}
