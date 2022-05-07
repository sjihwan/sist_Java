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
		
		System.out.println("학생명은?");
		String name = sc.nextLine();
		System.out.println("JAVA 점수는?");
		int java = Integer.parseInt(sc.nextLine());
		System.out.println("ORACLE 점수는?");
		int oracle = Integer.parseInt(sc.nextLine());
		
		//Connection,Prepare
		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;
		
		//일부만 insert...시퀀스,이름,자바,오라클
		String sql = "insert into sungjuk (num,name,java,oracle) "
				+ "values (seq_test.nextval,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			//바인딩
			pstmt.setString(1, name);
			pstmt.setInt(2, java);
			pstmt.setInt(3, oracle);
			
			//바인딩 후 실행
			pstmt.execute();
			System.out.println("추가됨!");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
		
	}
	
	//삭제..num입력받아서 해당데이터 지운후 '삭제됨'...5번학생이 없으면 '5번학생은 존재하지 않음'
	public void deleteSungjuk() {
		
		System.out.println("삭제할 번호 입력");
		int num = Integer.parseInt(sc.nextLine());
		
		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;
		
		String sql = "delete from sungjuk where num=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			
			int n = pstmt.executeUpdate();
			
			if(n==0)
				System.out.println(num + "번 학생은 존재하지 않음");
			else
				System.out.println(num + "번 학생정보가 삭제되었음");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
		
	}
	
	//수정..num에 따른 java,oracle점수 수정
	public void updateSungjuk() {
		
		System.out.println("수정할 번호 입력");
		int num = Integer.parseInt(sc.nextLine());
		
		System.out.println("수정할 JAVA점수는?");
		int java = Integer.parseInt(sc.nextLine());
		System.out.println("수정할 ORACLE점수는?");
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
				System.out.println("수정됨!!");
			else
				System.out.println(num + "번 학생은 존재하지 않음");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
		
	}
	
	//출력
	public void writeAll() {
		
		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from Sungjuk order by num";
		
		System.out.println("**학생성적 출력**");
		System.out.println();
		System.out.println("번호\t이름\t자바\t오라클\t총점\t평균");
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
	
	//총점과 평균만 다시 계산하는 메서드
	public void calcTotAvg() {
		
		Connection conn = db.getOracle();
		Statement stmt = null;
		
		//sql..update..total,average
		String sql = "update sungjuk set total=java+oracle,average=(java+oracle)/2";
		
		try {
			stmt = conn.createStatement();
			stmt.execute(sql);
			System.out.println("총합과 평균이 갱신되었습니다!!");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(stmt, conn);
		}
		
	}
	
	//process
	public void process() {
		
		while(true) {
			System.out.println("1.학생성적추가 2.학생정보삭제 3.학생정보수정 4.학생정보출력 5.학생성적계산 6.종료");
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
				System.out.println("*학생성적프로그램 종료**");
				return;
			}
		}
		
	}

	public static void main(String[] args) {

		SungjukJdbc sj = new SungjukJdbc();
		sj.process();
		
	}

}
