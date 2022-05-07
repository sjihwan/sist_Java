package day0225;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExSawonGroup {
	
	DbConnect db = new DbConnect();
	
	public void writeSawonGroup() {
		//����Ŭ ����
		Connection conn = db.getOracle();
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "select buseo,count(buseo) count,round(avg(pay),0) avgpay,max(pay) maxpay,"
				+ "min(pay) minpay from sawon group by buseo";
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			//�������
			System.out.println("�μ���\t�ο���\t��ձ޿�\t�ְ�޿�\t�����޿�");
			System.out.println("-------------------------------------------");
			
			//rs.next()...���������
			while(rs.next()) {
				String buseo = rs.getString("buseo");
				int cnt = rs.getInt("count");
				int avgpay = rs.getInt("avgpay");
				int maxpay = rs.getInt("maxpay");
				int minpay = rs.getInt("minpay");
				
				System.out.println(buseo+"\t"+cnt+"\t"+avgpay+"\t"+maxpay+"\t"+minpay);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(rs, stmt, conn);
		}
	}

	public static void main(String[] args) {
		ExSawonGroup ex = new ExSawonGroup();
		ex.writeSawonGroup();
	}

}
