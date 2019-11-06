package edu.kosta.lecture.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UnitOfScopeImpl implements UnitOfScope {
	Connection con = null;
	PreparedStatement ps = null;

	public UnitOfScopeImpl() throws SQLException {
		con = DbUtil.getConnection();
		con.setAutoCommit(false);                    // ÀÚµ¿ commit ²û
	}

	@Override
	public PreparedStatement beginTransaction(String sql) throws SQLException {
		
		ps = con.prepareStatement(sql);
		return ps;
	}

	@Override
	public void commit() throws SQLException {
		con.commit();

	}

	@Override
	public void rollback() throws SQLException {
		con.rollback();

	}

	@Override
	public void endTransaction() throws SQLException {
		// TODO Auto-generated method stub
		DbUtil.dbClose(con, ps);
	}

}
