package day0225;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
 * 1.DbConnect..Connect,dbClose
 * 2.mainŬ����..DbConnect����_connect,dbclose�� ���Ѱ� �޼��� ȣ���ؼ� ����Ѵ�
 * 3.mainŬ����
 * -insert (������,�̸�,�ڵ���,����,���糯¥ �Է�)_�ƹ� ������
 * -write (������,�̸�,�ڵ���,����,���糯¥)
 * -delete �������� �Է��Ͽ� ������ ����
 * -update �������� �Է��Ͽ� ������ �ڵ���,���� ����
 * 
 * ���θ޼��忡�� ���
 * **�л�����**
 * **1.�Է� 2.��� 3.���� 4.���� 5.����**
 */

public class JdbcMyStudent {
	
	DbConnect db = new DbConnect();
	Scanner sc = new Scanner(System.in);
	
	//insert
	public void insertMystudent() {
		
		String name,hp,sql;
		int age;
		
		System.out.print("Your Name?");
		name = sc.nextLine();
		System.out.print("Your Hp?");
		hp = sc.nextLine();
		System.out.print("Your Age?");
		age = Integer.parseInt(sc.nextLine());
		
		sql = "insert into mystudent values(seq1.nextval, '" + name + "', '" + hp + "', " + age + ", sysdate)";
//		System.out.println(sql);  //sql�� �Է�Ȯ��
		
		//Connection
		//Statement...execute
		
		Connection conn = db.getOracle();
		Statement stmt = null;
		
		try {
			stmt = conn.createStatement();
			int n = stmt.executeUpdate(sql); //���ϰ��� ������=>1,������=>0
			
			if(n==1)
				System.out.println("insert����!!");
			else
				System.out.println("insert����!!");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(stmt, conn);
		}
		
	}	
	
	//write
	//������	�̸�	�ڵ���	����	���Գ�¥
	public void writeMystudent() {
		
		Connection conn = db.getOracle();
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "select * from mystudent";
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			System.out.println("������\t�̸�\t�ڵ���\t����\t���Գ�¥");
			while(rs.next()) {
				System.out.println(rs.getInt("num") + "\t"
						+ rs.getString("name") + "\t"
						+ rs.getString("hp") + "\t"
						+ rs.getInt("age") + "\t"
						+ rs.getDate("sdate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(rs, stmt, conn);
		}
		
	}
	
	//update
	public void updateMystudent() {
		
		Connection conn = db.getOracle();
		Statement stmt = null;
		
		String hp,sql;
		int num,age;
		
		System.out.println("������ ��ȣ��?");
		num = Integer.parseInt(sc.nextLine());
		System.out.println("������ �ڵ��� ��ȣ��?");
		hp = sc.nextLine();
		System.out.println("������ ���̴�?");
		age = Integer.parseInt(sc.nextLine());

		sql = "update mystudent set hp='" + hp + "', age=" + age + " where num=" + num;
		
		try {
			stmt = conn.createStatement();
			int n = stmt.executeUpdate(sql);
			
			if(n==1)
				System.out.println(num + "�� �����Ͱ� �����Ǿ����ϴ�!!");
			else
				System.out.println("������ " + num + "�� �����Ͱ� �����ϴ�!!");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(stmt, conn);
		}
		
	}
	
	//delete
	public void deleteMystudent() {
		
		Connection conn = db.getOracle();
		Statement stmt = null;
		
		System.out.println("������ ��ȣ��?");
		int num = Integer.parseInt(sc.nextLine());
		
		String sql = "delete from mystudent where num=" + num;
		
		try {
			stmt = conn.createStatement();
			int n = stmt.executeUpdate(sql);
			
			if(n>0)
				System.out.println(num + "�� ��������!!");
			else
				System.out.println(num + "���� ���� �������Դϴ�");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(stmt, conn);
		}
		
	}
	
	public static void main(String[] args) {

		JdbcMyStudent my = new JdbcMyStudent();
		Scanner sc = new Scanner(System.in);		
		
		//while,switch
		while(true) {
			System.out.println("**�л�����**");
			System.out.println("**1.�Է� 2.��� 3.���� 4.���� 5.����**");
			int n = sc.nextInt();
			
			if(n==5) {
				System.out.println("���α׷� ����");
				break;
			}				
			
			switch(n) {
			case 1:
				my.insertMystudent();
				break;
			case 2:
				my.writeMystudent();
				break;
			case 3:
				my.updateMystudent();
				break;
			case 4:
				my.deleteMystudent();
				break;
			}
		}
		
	}

}
