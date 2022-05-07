package day0224;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest {
	
	//���÷� ����Ŭ ����
	static final String ORACLE_LOCAL="jdbc:oracle:thin:@localhost:1521:XE";
	//cloud ����Ŭ ����
//	static final String ORACLE_CLOUD="jdbc:oracle:thin:@db202202172315_high?TNS_ADMIN=C:/sist..";

	//sawon_oracle_sawon
	public void connectSawon() {
		//connection->statement->resultset
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;  //�ݵ�� ResultSet��ü�� ���� �Ѵ�
		
		String sql = "select * from sawon order by num";
		
		try {
			conn=DriverManager.getConnection(ORACLE_LOCAL, "shin", "a1234");
			System.out.println("����Ŭ ���� ���� ����!!!");
			
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			System.out.println("**�������Ʈ**");
			System.out.println("�����ȣ\t�����\t����\t�μ���\t�޿�");
			System.out.println("------------------------------------------------");
			
			//�������� �о�;� �ϹǷ� while������ �����´�
			//rs.next():
			while(rs.next()) {
				//db�κ��� ������ ��������
				int num=rs.getInt("num");
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				String buseo = rs.getString("buseo");
				int pay = rs.getInt("pay");
				System.out.println(num+"\t"+name+"\t"+gender+"\t"+buseo+"\t");
			}			
		} catch (SQLException e) {
			System.out.println("����Ŭ ���� ����!!!");
		} finally {
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	//food+jumun
	//�ֹ���ȣ �ֹ��� ���ĸ� ���� ������ּ�
	public void connectionBaedal() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "select f.fno, name, food, price, addr from food f, jumun j where f.fno=j.fno";
		try {
			conn=DriverManager.getConnection(ORACLE_LOCAL, "shin", "a1234");
			System.out.println("����Ŭ ���� ���� ����!!!");
			
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			System.out.println("**��޸���Ʈ**");
			System.out.println("�ֹ���ȣ\t�ֹ���\t���ĸ�\t����\t������ּ�");
			System.out.println("------------------------------------------------");
			
			while(rs.next()) {
				//db�κ��� ������ ��������
				int num=rs.getInt("fno");  //""���� ���� db�÷��� //f.fno�� �ȵ�
				String name = rs.getString("name");
				String food = rs.getString("food");
				int price = rs.getInt("price");
				String addr = rs.getString("addr");
				System.out.println(num+"\t"+name+"\t"+food+"\t"+price+"\t"+addr);
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
		JdbcTest ex=new JdbcTest();
		ex.connectSawon();
		ex.connectionBaedal();
	}

}
