package day0225;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCMember {
	
	DbConnect db = new DbConnect();
	Scanner sc = new Scanner(System.in);
	
	//insert
	public void insertMember() {
		
		Connection conn = db.getOracle();
		Statement stmt = null;
		
		//�����ȣ ����� �μ� ���� ���� ���޿� ���ʽ�
		System.out.println("�������?");
		String name = sc.nextLine();
		System.out.println("�μ���?");
		String buseo = sc.nextLine();
		System.out.println("������?");
		String position = sc.nextLine();
		System.out.println("������?");
		String gender = sc.nextLine();
		System.out.println("���޿���?");
		int pay = Integer.parseInt(sc.nextLine());
		System.out.println("���ʽ���?");
		int bonus = Integer.parseInt(sc.nextLine());
		
		String sql = "insert into mymember values(seq_mem.nextval, '" + name + "', '" + buseo + "', '"
				+ position + "', '" + gender + "', " + pay + ", " + bonus + ")";
		
		try {
			stmt = conn.createStatement();
			int n = stmt.executeUpdate(sql);
			if(n==1)
				System.out.println("������� �Է¿Ϸ�!!");
			else
				System.out.println("������� �Է½���!!");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(stmt, conn);
		}
		
	}
	
	//delete
	//������ �����ȣ �Է��� �����Ұ�
	public void deleteMember() {
		
		Connection conn = db.getOracle();
		Statement stmt = null;
		
		System.out.println("������ �����ȣ�� �Է��ϼ���");
		int sno = Integer.parseInt(sc.nextLine());
		
		String sql = "delete from mymember where sno=" + sno;
		
		try {
			stmt = conn.createStatement();
			int n = stmt.executeUpdate(sql);
			if(n==1)
				System.out.println(sno + "�� ������ �����Ϸ�!!");
			else
				System.out.println(sno + "�� �����ʹ� �������� �ʽ��ϴ�!!");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(stmt, conn);
		}
		
	}
	
	//update
	//������ �����ȣ �Է��� �μ�,����,�޿�,���ʽ� ����
	public void updateMember() {
		
		Connection conn = db.getOracle();
		Statement stmt = null;
		
		System.out.println("������ �����ȣ��?");
		int sno = Integer.parseInt(sc.nextLine());
		System.out.println("������ �μ���?");
		String buseo = sc.nextLine();
		System.out.println("������ ������?");
		String position = sc.nextLine();
		System.out.println("������ ���޿���?");
		int pay = Integer.parseInt(sc.nextLine());
		System.out.println("������ ���ʽ���?");
		int bonus = Integer.parseInt(sc.nextLine());
		
		String sql = "update mymember set buseo='" + buseo + "', porition='"
				+ position + "', pay=" + pay + ", bonus=" + bonus + " where sno=" + sno;
		
		int n;
		try {
			stmt = conn.createStatement();
			n = stmt.executeUpdate(sql);
			
			if(n==1)
				System.out.println(sno + "�� �����Ͱ� �����Ǿ����ϴ�!!");
			else
				System.out.println(sno + "�� �����ʹ� �������� �ʽ��ϴ�!!");			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(stmt, conn);
		}
		
	}	
	
	//write
	//�����ȣ ����� �μ� ���� ���� ���޿� ���ʽ�(ȭ������� õ���� ���б�ȣ)
	public void writeMember() {
		
		Connection conn = db.getOracle();
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "select sno,name,buseo,porition,gender,to_char(pay,'999,999,999L') pay,to_char(bonus,'999,999,999L') bonus from mymember";
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			System.out.println("[�������]");
			System.out.println("�����ȣ\t�����\t�μ�\t����\t����\t���޿�\t���ʽ�");
			while(rs.next()) {
				System.out.println(rs.getInt("sno") + "\t"
						+ rs.getString("name") + "\t"
						+ rs.getString("buseo") + "\t"
						+ rs.getString("porition") + "\t"
						+ rs.getString("gender") + "\t"
						+ rs.getString("pay") + "\t"
						+ rs.getString("bonus") + "\t");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(rs, stmt, conn);
		}
		
	}	
	
	//search
	public void searchName() {
		
		Connection conn = db.getOracle();
		Statement stmt = null;
		ResultSet rs = null;
		
		System.out.println("�˻��� �������� ������� �Է��ϼ���!!");
		String s = sc.nextLine();
		
		String sql = "select * from mymember where name like '%"
		+ s + "%'";
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			System.out.println("[�˻����]");
			
			System.out.println("�����ȣ\t�����\t�μ�\t����\t����\t���޿�\t���ʽ�");
			while(rs.next()) {
				System.out.println(rs.getInt("sno") + "\t"
						+ rs.getString("name") + "\t"
						+ rs.getString("buseo") + "\t"
						+ rs.getString("porition") + "\t"
						+ rs.getString("gender") + "\t"
						+ rs.getInt("pay") + "\t"
						+ rs.getInt("bonus") + "\t");		
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(rs, stmt, conn);
		}
		
	}
	
	//ó��
	//while,switch
	public void process() {
		
		while(true) {
			System.out.println("**MyMember**");
			System.out.println("1.��������Է� 2.��ü������ 3.������� 4.������� 5.�̸��˻� 0.�ý�������");
			int n = Integer.parseInt(sc.nextLine());
			
			if(n==0) {
				System.out.println("�ý����� �����մϴ�");
				break;
			}
			switch(n) {
			case 1:
				insertMember();
				break;
			case 2:
				writeMember();
				break;
			case 3:
				deleteMember();
				break;
			case 4:
				updateMember();
				break;
			case 5:
				searchName();
				break;
			}
		}
		
	}

	public static void main(String[] args) {

		JDBCMember mem = new JDBCMember();
		mem.process();
		
	}

}
