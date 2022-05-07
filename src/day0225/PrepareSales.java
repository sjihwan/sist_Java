package day0225;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PrepareSales {
	
	DbConnect db = new DbConnect();
	Scanner sc= new Scanner(System.in);
	
	public void insertSangpum() {
		
		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;
		
		System.out.println("1.����  2.���� �� ����?");
		int type=Integer.parseInt(sc.nextLine());
		System.out.println("��ǰ��?");
		String sang = sc.nextLine();
		System.out.println("����?");
		int su = Integer.parseInt(sc.nextLine());
		System.out.println("�ܰ�?");
		int dan = Integer.parseInt(sc.nextLine());
		
		//preparedStatement��ü�� �̿��� sql���� �ۼ��Ҽ��ִ� ������ ?ó��
		String sql = "insert into sales values(seq1.nextval,?,?,?,?,sysdate)";
		//������� ?�� ���ε��Ͽ��� �Ѵ�
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, type==1?"����":"����");
			pstmt.setString(2, sang);
			pstmt.setInt(3, su);
			pstmt.setInt(4, dan);
			
			int n = pstmt.executeUpdate();
			if(n==1) {
				System.out.println("��ǰ�߰� ����!!");
			}
			else {
				System.out.println("��ǰ�߰� ����!!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
		
	}
	
	public void writeSangpum() {
		
		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from sales order by num asc";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			System.out.println("������\tŸ��\t��ǰ��\t����\t�ܰ�\t�԰���");
			System.out.println("-------------------------------------------");
			
			while(rs.next()) {
				System.out.println(rs.getInt("num") + "\t"
						+ rs.getString("type") + "\t"
						+ rs.getString("sangpum") + "\t"
						+ rs.getInt("su") + "\t"
						+ rs.getInt("dan") + "\t"
						+ rs.getDate("ipgo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
		
	}
	
	//����...��������ȣ�� ����
	public void deleteSangpum() {
		
		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;  //�̿��� sql�� �ۼ���,PreparedStatement �ʿ�
		
		System.out.println("������ ��ȣ��?");
		int num = Integer.parseInt(sc.nextLine());
		
		String sql = "delete from sales where num=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);  //?���ε�..��������
			
			int n = pstmt.executeUpdate();
			
			if(n==1)
				System.out.println("��������!!!");
			else
				System.out.println("��������!!!");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("delete ����: " + e.getMessage());
		} finally {
			db.dbClose(pstmt, conn);
		}
		
	}
	
	//����...������ �Է��� �����Ҽ��ְ�
	public void updateSangpum() {
		
		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;
		
		System.out.println("������ ������ ��ȣ��?");
		int num = Integer.parseInt(sc.nextLine());
		
		System.out.println("**������ ������ �Է�**");
		System.out.println("1.����  2.����  ����?");
		int type = Integer.parseInt(sc.nextLine());
		
		System.out.println("������ ��ǰ����?");
		String sang = sc.nextLine();
		System.out.println("������ ������?");
		int su = Integer.parseInt(sc.nextLine());
		System.out.println("������ �ܰ���?");
		int dan = Integer.parseInt(sc.nextLine());
		
		String sql = "update sales set type=?, sangpum=?, su=?, dan=? where num=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, type==1? "����":"����");
			pstmt.setString(2, sang);
			pstmt.setInt(3, su);
			pstmt.setInt(4, dan);
			pstmt.setInt(5, num);
			
			int n = pstmt.executeUpdate();
			
			if(n==1)
				System.out.println("��ǰ��������!!");
			else
				System.out.println("��ǰ��������!!");
		} catch (SQLException e) {
			System.out.println("update����: " + e.getMessage());
		} finally {
			db.dbClose(pstmt, conn);
		}
		
	}

	public static void main(String[] args) {
		
		PrepareSales preS = new PrepareSales();
		Scanner sc = new Scanner(System.in);
		
		int n;
		
		while(true) {
			System.out.println("**���ø޴�**");
			System.out.println("1. �߰�  2.����  3.����  4.��ü���  0.����");
			System.out.print("���ù�ȣ: ");
			
			n = Integer.parseInt(sc.nextLine());
			
			if(n==0) {
				System.out.println("���α׷� ����");
				break;
			}
			
			switch(n) {
			case 1:
				preS.insertSangpum();
				break;
			case 2:
				preS.deleteSangpum();
				break;
			case 3:
				preS.updateSangpum();
				break;
			case 4:
				preS.writeSangpum();
				break;
			}
		}
		
	}

}
