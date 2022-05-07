package day0225;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReviewJdbc_01 {
	//���÷� ����Ŭ ����
	static final String ORACLE_LOCAL="jdbc:oracle:thin:@localhost:1521:XE";
	
	public void connectShop() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		//�ֹ���ȣ ��ǰ��ȣ ��ǰ�� ���� ���԰��� ��������
		String sql = "select idx, s.num, sangpum, color, cnt, guipday from shop s, cart1 where s.num=cart1.num";
		
		try {
			//����Ŭ�� ����
			conn=DriverManager.getConnection(ORACLE_LOCAL, "shin", "a1234");
			System.out.println("����Ŭ ���� ���� ����!!");
			
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);	//sql�� ����
			
			System.out.println("**SHOP-CART1**");
			System.out.println("�ֹ���ȣ\t��ǰ��ȣ\t��ǰ��\t����\t���԰���\t��������");
			System.out.println("------------------------------------------------");
			
			while(rs.next()) {
				int idx = rs.getInt("idx");
				int num = rs.getInt("num");
				String sang = rs.getString("sangpum");
				String color = rs.getString("color");
				int cnt = rs.getInt("cnt");
				String guipday = rs.getString("guipday");
				
				System.out.println(idx+"\t"+num+"\t"+sang+"\t"+color+"\t"+cnt+"\t"+guipday+"\t");
			}			
		} catch (SQLException e) {
			System.out.println("����Ŭ ���� ����!!");
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	public static void main(String[] args) {
		ReviewJdbc_01 jdbc = new ReviewJdbc_01();
		jdbc.connectShop();
	}

}
