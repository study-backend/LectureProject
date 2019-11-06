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
}
