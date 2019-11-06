package edu.kosta.lecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.kosta.lecture.model.Subject;
import edu.kosta.lecture.util.DbUtil;

public class SubjectDAO {

	public List<Subject> selectAll() {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Subject> list = new ArrayList<Subject>();
		String sql = "select * from Subject";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				Subject subject = new Subject();
				subject.setSubjectCode(rs.getInt("SubjectCode"));
				subject.setSubjectName(rs.getString("SubjectName"));
				subject.setCreateDate(rs.getDate("CreateDate"));
				subject.setUpdateDate(rs.getDate("UpdateDate"));

				list.add(subject);

			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;

	}
	
//////////////////////insert
	public void insert(List<Subject> list) {
		Connection con  = null;
		PreparedStatement ps = null;
		
		//Date ��ȯ 
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		
		String sql =  "INSERT INTO Subject(SubjectCode, SubjectName, CreateDate, UpdateDate)"
				+ "VALUES(?, ?, ?, ?)";
		
		try {
			con = DbUtil.getConnection();
			con.setAutoCommit(false); // �ڵ� commit ��
			
			ps = con.prepareStatement(sql);
			
			//bulk insert ó��
			for (Subject r : list) {
				ps.setInt(1,  r.getSubjectCode());
				ps.setString(2, r.getSubjectName());
				ps.setDate(3, sqlDate);
				ps.setDate(4, sqlDate);
				
				ps.addBatch();
				ps.clearParameters();
			}
			ps.executeBatch(); // ������ batch ����
			ps.clearBatch(); // �������� batch �ʱ�ȭ
			con.commit(); // Commit�Ͽ� ����
		
		} catch(Exception e) {
			e.printStackTrace();
			
		} finally {
			DbUtil.dbClose(con,  ps);
		}
	}
	////////////////////// update
	public void update(Subject subject) {
		Connection con = null;
		PreparedStatement ps = null;

		// Date ��ȯ
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

		String sql = "UPDATE Subject SET SubjectName = ?, UpdateDate = ?" + " WHERE SubjectCode = ?";
		// ���� ���̵� "" �� �� ��� ���� ����

		try {
			con = DbUtil.getConnection(); // ����
			ps = con.prepareStatement(sql); // SQL�� �غ�

			ps.setString(1, subject.getSubjectName());
			ps.setDate(2, sqlDate);
			ps.setInt(3, subject.getSubjectCode());

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

		String sql = "DELETE FROM Subject  WHERE SubjectCode in (?)";
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
