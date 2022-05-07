package day0225;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SawonAdd_03 {
	
	DbConnect db = new DbConnect();
	Scanner sc = new Scanner(System.in);
	
	//������ �߰�
	public void InsertSawon() {
		System.out.println("**����߰��ϱ�**");
		System.out.println("�����?");
		String name = sc.nextLine();
		System.out.println("�μ���?");
		String buseo = sc.nextLine();
		System.out.println("����(����/����)");
		String gender = sc.nextLine();
		System.out.println("���޿�?");
		int pay = Integer.parseInt(sc.nextLine());
		
		//�ڹٿ��� �ۼ��Ѱ� db�� �������� Connection,Statement...�ϼ��� sql
		String sql = "insert into sawon values(seq_sawon.nextval,'"+name+"','"+gender+"','"+buseo+"',"+pay+")";
		//insert into sawon values(seq_sawon.nextval,'����','����','ȫ����',3460000)
		//System.out.println(sql);
		
		//����Ŭ�� ����
		Connection conn = db.getOracle();
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			stmt.execute(sql);	//sql�� ����(insert,delete,update..execute() or executeUpdate() �����ϳ� ���)
			
			//int a = stmt.executeUpdate(sql); //������ �������� ����
			//System.out.println(a);
			
			System.out.println("DB�� �߰��Ǿ����ϴ�");			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(stmt, conn);
		}
	}
	
	//������ ��ȸ
	public void writeSawon() {
		//��ü ������
		//�����ȣ ����� ���� �μ��� ���޿�
		String sql = "select * from sawon";
		
		Connection conn = db.getOracle();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			System.out.println("�����ȣ\t�����\t����\t�μ���\t���޿�");
			while(rs.next()) {
				int num = rs.getInt("num");
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				String buseo = rs.getString("buseo");
				int pay = rs.getInt("pay");
				System.out.println(num+"\t"+name+"\t"+gender+"\t"+buseo+"\t"+pay);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(rs,stmt, conn);
		}
	}
	
	//����..������� �Է��ϸ� ����
	public void deleteSawon() {
		System.out.println("������ ������� �Է����ּ���");
		String name = sc.nextLine();
		
		//delete from sawon where name='�輱ȣ'..�̷��� sql�� �ۼ�
		String sql="delete from sawon where name='"+name+"'";
		
		Connection conn = db.getOracle();
		Statement stmt = null;
		
		try {
			stmt = conn.createStatement();
			//stmt.execute(sql);
			
			//�̸��� ���� ��� 0��ȯ
			int n = stmt.executeUpdate(sql);
			if(n==0) {
				System.out.println(name+"���� �����ܿ� �����ϴ�");
			}
			else
				System.out.println(name+"���� ��ܿ��� �����߽��ϴ�");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(stmt, conn);
		}
	}
	
	//����..update(�����ȣ �Է��� �̸�,�μ�,�޿� ���氡��)
	public void updateSawon() {
		System.out.println("������ �����ȣ��?");
		int num = Integer.parseInt(sc.nextLine());
		System.out.println("������ �̸� �Է�");
		String name = sc.nextLine();
		System.out.println("������ �μ� �Է�");
		String buseo = sc.nextLine();
		System.out.println("������ �޿� �Է�");
		int pay = Integer.parseInt(sc.nextLine());
		
		String sql = "update sawon set name='"+name+"',buseo='"+buseo+"',pay="+pay+" where num="+num;
		
		//db����
		Connection conn = db.getOracle();
		Statement stmt = null;
		
		try {
			stmt = conn.createStatement();
			
			int n = stmt.executeUpdate(sql);
			
			if(n==0)
				System.out.println("������ �����Ͱ� �������� �����ϴ�");
			else
				System.out.println(num+"���� �����Ͱ� �����Ǿ����ϴ�");			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void searchSawon() {
		System.out.println("�˻��� ����� �����Դϱ�(�Ϻε� ����)");
		String s = sc.nextLine();
		
		String sql = "select num,name,gender,buseo,to_char(pay,'L999,999,999') pay from sawon where name like '%"+s+"%'";
		
		Connection conn = db.getOracle();
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			int n = stmt.executeUpdate(sql);
			
			if(n==0)
				System.out.println("�˻��� ����� �����Ϳ� �����ϴ�");
			else {
				rs = stmt.executeQuery(sql);
				System.out.println("�����ȣ\t�����\t����\t�μ���\t���޿�");
				while(rs.next()) {
					int num = rs.getInt("num");
					String name = rs.getString("name");
					String gender = rs.getString("gender");
					String buseo = rs.getString("buseo");
					String pay = rs.getString("pay");
					System.out.println(num+"\t"+name+"\t"+gender+"\t"+buseo+"\t"+pay);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		SawonAdd_03 addS = new SawonAdd_03();
		Scanner sc = new Scanner(System.in);
		
		int n = 0;
		
		while(true) {
			System.out.println("**Oracle Db ��������**");
			System.out.println("1.insert  2.select  3.update  4.delete  5.����˻�  9.exit");
			n=Integer.parseInt(sc.nextLine());
			
			if(n==1)
				addS.InsertSawon();
			else if(n==2) {
				addS.writeSawon();
			}
			else if(n==3) {
				addS.updateSawon();
			}
			else if(n==4) {
				addS.deleteSawon();
			}
			else if(n==5) {
				addS.searchSawon();
			}
			else {
				System.out.println("�����մϴ�");
				break;
			}
		}
	}

}
