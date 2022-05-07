package day0225;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnect {
	
	//url ����Ŭ���
	static final String ORACLE_LOCAL="jdbc:oracle:thin:@localhost:1521:XE";
	
	//Connection ��ȯŸ��
	public Connection getOracle() {
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(ORACLE_LOCAL, "shin", "a1234");
		} catch (SQLException e) {
			System.out.println("����Ŭ ���� ����: " + e.getMessage());
		}
		
		return conn;
	}
	
	//close..(select..�ϼ���sql(statement))
	public void dbClose(ResultSet rs,Statement stmt,Connection conn) {
		try {
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			if(conn!=null)conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//close..�ϼ���sql(Statement)
	public void dbClose(Statement stmt,Connection conn) {
		try {
			if(stmt!=null)stmt.close();
			if(conn!=null)conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//close...select...�̿ϼ���sql(PrepareStatement)
	public void dbClose(ResultSet rs, PreparedStatement pstmt,Connection conn) {
		try {
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//close...�ϼ���sql(PrepareStatement)
	public void dbClose(PreparedStatement pstmt,Connection conn) {
		try {
			if(pstmt!=null)pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	

}
