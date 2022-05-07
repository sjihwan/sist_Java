package day0225;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcHello {
	//��ü ȣ��
	DbConnect db = new DbConnect();
	Scanner sc = new Scanner(System.in);
	
	//�߰�����
	//��������ȣ �̸� �ּ� ��¥
	public void insertHello() {
		System.out.println("�̸���?");
		String name = sc.nextLine();
		System.out.println("�ּҴ�?");
		String addr = sc.nextLine();
		
		String sql = "Insert into hello values(seq_hello.nextval,'"+name+"','"+addr+"',sysdate)";
		
		//����Ŭdb�� ����
		Connection conn = db.getOracle();
		//sql�� �ۼ��غ�1
		Statement stmt = null;
		try {
			stmt = conn.createStatement(); //sql�� �ۼ��غ�
			stmt.execute(sql);			
			System.out.println("DB�� �߰��Ǿ����ϴ�");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.dbClose(stmt, conn);
		}
	}
	
	//��ȸ
	public void selectHello() {
		String sql = "select * from hello";
		
		Connection conn = db.getOracle();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			System.out.println("��ü �����͸� ��ȸ�մϴ�");
			System.out.println("��ȣ\t�̸�\t�ּ�\t��¥");
			while(rs.next()) {
				int num = rs.getInt("num");
				String name = rs.getString("name");
				String addr = rs.getString("addr");
				String sdate = rs.getString("sdate");
				
				System.out.println(num+"\t"+name+"\t"+addr+"\t"+sdate);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.dbClose(rs, stmt, conn);
		}
		
	}
	
	//����
	//num�� �Է��� �����Ұ�!!
	public void deleteHello() {
		System.out.println("������ �������� ��ȣ�� �Է��ϼ���");
		int num = Integer.parseInt(sc.nextLine());
		
		String sql = "delete from hello where num="+num;
		
		Connection conn = db.getOracle();
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			int n = stmt.executeUpdate(sql);
			if(n==0)
				System.out.println(num+"���� �����ʹ� �������� �ʽ��ϴ�");
			else
				System.out.println(num+"���� �����͸� �����߽��ϴ�");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.dbClose(stmt, conn);
		}
	}
	
	//����
	//num�� �Է��� �̸�,�ּ� �����Ұ�!!
	public void updateHello() {
		System.out.println("������ �������� ��ȣ�� �Է��ϼ���");
		int num = Integer.parseInt(sc.nextLine());
		System.out.println("������ �̸��� �Է��ϼ���");
		String name = sc.nextLine();
		System.out.println("������ �ּҸ� �Է��ϼ���");
		String addr = sc.nextLine();
		System.out.println("������ ��¥�� �Է��ϼ���");
		String sdate = sc.nextLine();
		
		Connection conn = db.getOracle();
		Statement stmt = null;
		
		String sql = "update hello set name ='"+name+"',addr='"+addr+"',sdate='"+sdate+"' where num="+num;
		
		try {
			stmt=conn.createStatement();
			
			int n = stmt.executeUpdate(sql);
			
			if(n==0) {
				System.out.println("������ �����͹�ȣ�� �������� �ʽ��ϴ�");
			}
			else
				System.out.println(num+"���� �����Ͱ� �����Ǿ����ϴ�");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	//DB���� �޼��带 ��������ִ� �޼���?
	public void process() {
		while(true) {
			System.out.println("1.insert  2.select  3.delete  4.update  9.exit");
			int n = Integer.parseInt(sc.nextLine());
			if(n==1) {
				insertHello();
			}
			else if(n==2) {
				selectHello();
			}
			else if(n==3) {
				deleteHello();
			}
			else if(n==4) {
				updateHello();
			}
			else {
				System.out.println("�����մϴ�");
				return;
			}
		}
	}

	public static void main(String[] args) {
		//process() ȣ���Ͽ� Ȯ���Ұ�!!
		//�Ʊ�ó�� ���ο��� Scanner�� ���� ȣ���ص� �˴ϴ�
		JdbcHello hello = new JdbcHello();
		hello.process();
	}

}
