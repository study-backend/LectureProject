package edu.kosta.lecture.util;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface UnitOfScope {
	
	PreparedStatement beginTransaction(String sql) throws SQLException;
	
    void commit() throws SQLException;
    
    void rollback() throws SQLException;

	void endTransaction() throws SQLException;


    
}
