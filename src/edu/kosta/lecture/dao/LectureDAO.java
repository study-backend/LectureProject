package edu.kosta.lecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.kosta.lecture.model.Lecture;
import edu.kosta.lecture.util.DbUtil;

public class LectureDAO {

	public List<Lecture> selectAll() {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Lecture> list = new ArrayList<Lecture>();
		String sql = "select * from Lecture";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				Lecture lecture = new Lecture();
				lecture.setLectureId(rs.getLong("lectureId"));
				lecture.setRoomCode(rs.getInt("RoomCode"));
				lecture.setSubjectCode(rs.getInt("SubjectCode"));
				lecture.setTime(rs.getInt("Time"));
				lecture.setCreateDate(rs.getDate("CreateDate"));
				lecture.setUpdateDate(rs.getDate("UpdateDate"));

				list.add(lecture);

			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}
}