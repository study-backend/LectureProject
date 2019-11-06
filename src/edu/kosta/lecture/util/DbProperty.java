package edu.kosta.lecture.util;

/**
 * DB설정 정보를 상수필드로 관리
 * */
public interface DbProperty {
	public static final String DRIVER_NAME="oracle.jdbc.driver.OracleDriver";
	public static final String URL="jdbc:oracle:thin:@localhost:1521:xe";
	public static final String USER="scott";
	public static final String PASSWORD="TIGER";
}
