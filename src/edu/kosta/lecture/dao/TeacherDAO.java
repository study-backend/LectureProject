package edu.kosta.Teacher.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.kosta.lecture.model.Teacher;
import edu.kosta.lecture.util.DbUtil;

public class TeacherDAO {

	public List<Teacher> selectAll() {
		
		public List<Teacher> selectAll() {
			
			Connection con = null;
			PreparedStatement ps  = null;
			ResultSet rs = null;
			List<Teacher> list = new ArrayList<Teacher>();
			String sql = "select * from Teacher";
			
			try {
				con = DbUtil.getConnection();
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				
				while(rs.next()) {
				  Teacher teacher = new Teacher();
				  
				  teacher.setTeacherId(rs.getLong("TeacherId"));
				  teacher.setTeacherName(rs.getString("TeacherName"));
				  teacher.setRegistrationNumber(rs.getString("RegistrationNumber"));
				  teacher.setPhoneNumber(rs.getString("PhoneNumber"));
				  teacher.setAddress(rs.getString("Adress"));
				  teacher.setEmail(rs.getString("Email"));
				  teacher.setCreateDate(rs.getDate("CreateDate"));	
				  teacher.setUpdateDate(rs.getDate("UpdateDate"));
				
				list.add(Teacher);
				
				} catch (Exception e) {
				    e.printStackTrace();
				
				} finally {
					DbUtil.dbClose(con, ps, rs);
				} return list;
		
	}
	
}
