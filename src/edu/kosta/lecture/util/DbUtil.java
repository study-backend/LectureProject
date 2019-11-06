package edu.kosta.lecture.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * DB 연동을 위한 로드, 연결, 실행
 * */
public class DbUtil {
	/**
	 * 로드
	 * https://kyun2.tistory.com/23 
	 * 이 부분이 있어 DriverManager를 통한 연결에 대한 사전작업니다
	 * */
	static {
		try{
			Class.forName(DbProperty.DRIVER_NAME);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 연결
	 * */
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(
				DbProperty.URL, 
				DbProperty.USER, 
				DbProperty.PASSWORD);
	}
	
	/**
	 * 닫기(DB관련 사용된 객체를 close()한다)
	 * (INSERT, UPDATE, DELETE인 경우)
	 * */
	public static void dbClose(Connection con, Statement stmt){
		try{
			if(stmt != null) stmt.close();
			if(con != null) con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 닫기(DB관련 사용된 객체를 close()한다)
	 * (SELECT인 경우)
	 * */
	public static void dbClose(Connection con, Statement stmt, ResultSet rs){
		try{
			if(rs != null) rs.close();
			dbClose(con, stmt);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
