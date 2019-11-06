package edu.kosta.lecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.kosta.lecture.model.Lecture;
import edu.kosta.lecture.util.DbUtil;

public class LectureDAO {
//////////////////////selectAll
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
	
	
//////////////////////insert
	public void insert(List<Lecture> list) {
		Connection con = null;
		PreparedStatement ps = null;

		// Date 변환
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

		String sql = "INSERT INTO Lecture(LectureId, RoomCode, Subject, Time, CreateDate, UpdateDate) VALUES(?, ?, ?, ? ,? ,?)";

		try {
			con = DbUtil.getConnection();
			con.setAutoCommit(false); // 자동 commit 끔

			ps = con.prepareStatement(sql);

			// bulk insert 처리
			for (Lecture r : list) {
				ps.setLong(1, r.getLectureId());
				ps.setInt(2, r.getRoomCode());
				ps.setInt(3, r.getSubjectCode());
				ps.setInt(4, r.getTime());
				ps.setDate(3, sqlDate); // 생성 시간
				ps.setDate(4, sqlDate); // 수정 시간

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
	public void update(Lecture lecture) {
		Connection con = null;
		PreparedStatement ps = null;

		// Date 변환
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

		String sql = "UPDATE Lecture SET  RoomCode= ?, SubjectCode = ?, Time = ?, UpdateDate = ?  WHERE LectureId = ?";
		// 수강 아이디가 "" 일 때 강의실,과목,시간 변경

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);

			ps.setInt(1, lecture.getRoomCode());
			ps.setInt(2, lecture.getSubjectCode());
			ps.setInt(3, lecture.getTime());
			ps.setDate(4, sqlDate);
			ps.setLong(5, lecture.getLectureId());

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

		String sql = "DELETE FROM Lecture  WHERE RoomCode in (?)";
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