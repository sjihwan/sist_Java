package day0303;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SungjukJdbc {
	
	DbConnect db = new DbConnect();
	Scanner sc = new Scanner(System.in);
	
	public void insertSungjuk() {
		
		System.out.println("�л�����?");
		String name = sc.nextLine();
		System.out.println("JAVA ������?");
		int java = Integer.parseInt(sc.nextLine());
		System.out.println("ORACLE ������?");
		int oracle = Integer.parseInt(sc.nextLine());
		
		//Connection,Prepare
		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;
		
		//�Ϻθ� insert...������,�̸�,�ڹ�,����Ŭ
		String sql = "insert into sungjuk (num,name,java,oracle) "
				+ "values (seq_test.nextval,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			//���ε�
			pstmt.setString(1, name);
			pstmt.setInt(2, java);
			pstmt.setInt(3, oracle);
			
			//���ε� �� ����
			pstmt.execute();
			System.out.println("�߰���!");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
		
	}
	
	//����..num�Է¹޾Ƽ� �ش絥���� ������ '������'...5���л��� ������ '5���л��� �������� ����'
	public void deleteSungjuk() {
		
		System.out.println("������ ��ȣ �Է�");
		int num = Integer.parseInt(sc.nextLine());
		
		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;
		
		String sql = "delete from sungjuk where num=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			
			int n = pstmt.executeUpdate();
			
			if(n==0)
				System.out.println(num + "�� �л��� �������� ����");
			else
				System.out.println(num + "�� �л������� �����Ǿ���");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
		
	}
	
	//����..num�� ���� java,oracle���� ����
	public void updateSungjuk() {
		
		System.out.println("������ ��ȣ �Է�");
		int num = Integer.parseInt(sc.nextLine());
		
		System.out.println("������ JAVA������?");
		int java = Integer.parseInt(sc.nextLine());
		System.out.println("������ ORACLE������?");
		int oracle = Integer.parseInt(sc.nextLine());
		
		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;
		
		String sql = "update sungjuk set java=?, oracle=? where num=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, java);
			pstmt.setInt(2, oracle);
			pstmt.setInt(3, num);
			
			int n = pstmt.executeUpdate();
			
			if(n==1)
				System.out.println("������!!");
			else
				System.out.println(num + "�� �л��� �������� ����");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
		
	}
	
	//���
	public void writeAll() {
		
		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from Sungjuk order by num";
		
		System.out.println("**�л����� ���**");
		System.out.println();
		System.out.println("��ȣ\t�̸�\t�ڹ�\t����Ŭ\t����\t���");
		System.out.println("------------------------------------------");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getInt("num") + "\t"
						+ rs.getString("name") + "\t"
						+ rs.getInt("java") + "\t"
						+ rs.getInt("oracle") + "\t"
						+ rs.getInt("total") + "\t"
						+ rs.getDouble("average"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
		
	}
	
	//������ ��ո� �ٽ� ����ϴ� �޼���
	public void calcTotAvg() {
		
		Connection conn = db.getOracle();
		Statement stmt = null;
		
		//sql..update..total,average
		String sql = "update sungjuk set total=java+oracle,average=(java+oracle)/2";
		
		try {
			stmt = conn.createStatement();
			stmt.execute(sql);
			System.out.println("���հ� ����� ���ŵǾ����ϴ�!!");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(stmt, conn);
		}
		
	}
	
	//process
	public void process() {
		
		while(true) {
			System.out.println("1.�л������߰� 2.�л��������� 3.�л��������� 4.�л�������� 5.�л�������� 6.����");
			int num = Integer.parseInt(sc.nextLine());
			
			switch(num) {
			case 1:
				this.insertSungjuk();
				break;
			case 2:
				this.deleteSungjuk();
				break;
			case 3:
				this.updateSungjuk();
				break;
			case 4:
				this.writeAll();
				break;
			case 5:
				this.calcTotAvg();
				break;
			default:
				System.out.println("*�л��������α׷� ����**");
				return;
			}
		}
		
	}

	public static void main(String[] args) {

		SungjukJdbc sj = new SungjukJdbc();
		sj.process();
		
	}

}
