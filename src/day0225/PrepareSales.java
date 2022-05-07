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
		
		System.out.println("1.음료  2.과일 중 택일?");
		int type=Integer.parseInt(sc.nextLine());
		System.out.println("상품명?");
		String sang = sc.nextLine();
		System.out.println("수량?");
		int su = Integer.parseInt(sc.nextLine());
		System.out.println("단가?");
		int dan = Integer.parseInt(sc.nextLine());
		
		//preparedStatement객체는 미완의 sql문을 작성할수있다 변수를 ?처리
		String sql = "insert into sales values(seq1.nextval,?,?,?,?,sysdate)";
		//순서대로 ?를 바인딩하여야 한다
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, type==1?"음료":"과일");
			pstmt.setString(2, sang);
			pstmt.setInt(3, su);
			pstmt.setInt(4, dan);
			
			int n = pstmt.executeUpdate();
			if(n==1) {
				System.out.println("상품추가 성공!!");
			}
			else {
				System.out.println("상품추가 실패!!");
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
			
			System.out.println("시퀀스\t타입\t상품명\t수량\t단가\t입고일");
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
	
	//삭제...시퀀스번호로 삭제
	public void deleteSangpum() {
		
		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;  //미완의 sql문 작성시,PreparedStatement 필요
		
		System.out.println("삭제할 번호는?");
		int num = Integer.parseInt(sc.nextLine());
		
		String sql = "delete from sales where num=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);  //?바인딩..순서별로
			
			int n = pstmt.executeUpdate();
			
			if(n==1)
				System.out.println("삭제성공!!!");
			else
				System.out.println("삭제실패!!!");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("delete 오류: " + e.getMessage());
		} finally {
			db.dbClose(pstmt, conn);
		}
		
	}
	
	//수정...시퀀스 입력후 수정할수있게
	public void updateSangpum() {
		
		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;
		
		System.out.println("수정할 시퀀스 번호는?");
		int num = Integer.parseInt(sc.nextLine());
		
		System.out.println("**수정할 데이터 입력**");
		System.out.println("1.음료  2.과일  택일?");
		int type = Integer.parseInt(sc.nextLine());
		
		System.out.println("수정할 상품명은?");
		String sang = sc.nextLine();
		System.out.println("수정할 수량은?");
		int su = Integer.parseInt(sc.nextLine());
		System.out.println("수정할 단가는?");
		int dan = Integer.parseInt(sc.nextLine());
		
		String sql = "update sales set type=?, sangpum=?, su=?, dan=? where num=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, type==1? "음료":"과일");
			pstmt.setString(2, sang);
			pstmt.setInt(3, su);
			pstmt.setInt(4, dan);
			pstmt.setInt(5, num);
			
			int n = pstmt.executeUpdate();
			
			if(n==1)
				System.out.println("상품수정성공!!");
			else
				System.out.println("상품수정실패!!");
		} catch (SQLException e) {
			System.out.println("update오류: " + e.getMessage());
		} finally {
			db.dbClose(pstmt, conn);
		}
		
	}

	public static void main(String[] args) {
		
		PrepareSales preS = new PrepareSales();
		Scanner sc = new Scanner(System.in);
		
		int n;
		
		while(true) {
			System.out.println("**선택메뉴**");
			System.out.println("1. 추가  2.삭제  3.수정  4.전체출력  0.종료");
			System.out.print("선택번호: ");
			
			n = Integer.parseInt(sc.nextLine());
			
			if(n==0) {
				System.out.println("프로그램 종료");
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
