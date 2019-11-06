package edu.kosta.lecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.kosta.lecture.model.ClassRoom;
import edu.kosta.lecture.util.DbUtil;

public class ClassRoomDAO {


	public List<ClassRoom> selectAll() {

			Connection con = null;
			PreparedStatement ps  = null;
			ResultSet rs = null;
			List<ClassRoom> list = new ArrayList<ClassRoom>();
			String sql = "select * from ClassRoom";
			
			try {
				con = DbUtil.getConnection();
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				
				while(rs.next()) {
				  ClassRoom classroom = new ClassRoom();
				  	classroom.setRoomCode(rs.getInt("RoomCode"));
				  	classroom.setCapacity(rs.getInt("Capacity"));
				  	classroom.setCreateDate(rs.getDate("CreateDate"));
				  	classroom.setUpdateDate(rs.getDate("UpdateDate"));
				  	
				list.add(classroom);
				
				}catch (Exception e) {
				    e.printStackTrace();
				
				}finally {
					DbUtil.dbClose(con, ps, rs);
				} return list;

			}
			
		}
	}

		
	}
}
