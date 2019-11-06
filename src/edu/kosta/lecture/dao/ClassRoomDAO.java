package edu.kosta.lecture.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.kosta.lecture.model.ClassRoom;
import edu.kosta.lecture.util.DbUtil;

public class ClassRoomDAO {

	public List<ClassRoom> selectAll() {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ClassRoom> list = new ArrayList<ClassRoom>();
		String sql = "select * from ClassRoom";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				ClassRoom classroom = new ClassRoom();
				classroom.setRoomCode(rs.getInt("RoomCode"));
				classroom.setCapacity(rs.getInt("Capacity"));
				classroom.setCreateDate(rs.getDate("CreateDate"));
				classroom.setUpdateDate(rs.getDate("UpdateDate"));

				list.add(classroom);

			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			DbUtil.dbClose(con, ps, rs);
		}

		return list;

	}
	
	public void insert(List<ClassRoom> list) {
		Connection con = null;
		PreparedStatement ps = null;
		
		// Date 변환
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		
		String sql = "INSERT INTO ClassRoom(RoomCode, Capacity, CreateDate, UpdateDate) VALUES(?, ?, ?, ? )";

		try {
			con = DbUtil.getConnection();
			con.setAutoCommit(false);                    // 자동 commit 끔
			
			ps = con.prepareStatement(sql);
			
			// bulk insert 처리
			for (ClassRoom r : list) {
				ps.setInt(1, r.getRoomCode());
				ps.setInt(2, r.getCapacity());
				ps.setDate(3, sqlDate);
				ps.setDate(4, sqlDate);

				ps.addBatch(); // OraclePreparedStatement에 batch로 완성된 SQL 추가
				ps.clearParameters(); // OraclePreparedStatement에 지정된 Parameter값 초기화
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

}
