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
		
		//사원번호 사원명 부서 직급 성별 월급여 보너스
		System.out.println("사원명은?");
		String name = sc.nextLine();
		System.out.println("부서는?");
		String buseo = sc.nextLine();
		System.out.println("직급은?");
		String position = sc.nextLine();
		System.out.println("성별은?");
		String gender = sc.nextLine();
		System.out.println("월급여는?");
		int pay = Integer.parseInt(sc.nextLine());
		System.out.println("보너스는?");
		int bonus = Integer.parseInt(sc.nextLine());
		
		String sql = "insert into mymember values(seq_mem.nextval, '" + name + "', '" + buseo + "', '"
				+ position + "', '" + gender + "', " + pay + ", " + bonus + ")";
		
		try {
			stmt = conn.createStatement();
			int n = stmt.executeUpdate(sql);
			if(n==1)
				System.out.println("사원정보 입력완료!!");
			else
				System.out.println("사원정보 입력실패!!");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(stmt, conn);
		}
		
	}
	
	//delete
	//삭제할 사원번호 입력후 삭제할것
	public void deleteMember() {
		
		Connection conn = db.getOracle();
		Statement stmt = null;
		
		System.out.println("삭제할 사원번호를 입력하세요");
		int sno = Integer.parseInt(sc.nextLine());
		
		String sql = "delete from mymember where sno=" + sno;
		
		try {
			stmt = conn.createStatement();
			int n = stmt.executeUpdate(sql);
			if(n==1)
				System.out.println(sno + "번 데이터 삭제완료!!");
			else
				System.out.println(sno + "번 데이터는 존재하지 않습니다!!");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(stmt, conn);
		}
		
	}
	
	//update
	//수정할 사원번호 입력후 부서,직위,급여,보너스 수정
	public void updateMember() {
		
		Connection conn = db.getOracle();
		Statement stmt = null;
		
		System.out.println("수정할 사원번호는?");
		int sno = Integer.parseInt(sc.nextLine());
		System.out.println("수정할 부서는?");
		String buseo = sc.nextLine();
		System.out.println("수정할 직위는?");
		String position = sc.nextLine();
		System.out.println("수정할 월급여는?");
		int pay = Integer.parseInt(sc.nextLine());
		System.out.println("수정할 보너스는?");
		int bonus = Integer.parseInt(sc.nextLine());
		
		String sql = "update mymember set buseo='" + buseo + "', porition='"
				+ position + "', pay=" + pay + ", bonus=" + bonus + " where sno=" + sno;
		
		int n;
		try {
			stmt = conn.createStatement();
			n = stmt.executeUpdate(sql);
			
			if(n==1)
				System.out.println(sno + "번 데이터가 수정되었습니다!!");
			else
				System.out.println(sno + "번 데이터는 존재하지 않습니다!!");			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(stmt, conn);
		}
		
	}	
	
	//write
	//사원번호 사원명 부서 직급 성별 월급여 보너스(화폐단위와 천단위 구분기호)
	public void writeMember() {
		
		Connection conn = db.getOracle();
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "select sno,name,buseo,porition,gender,to_char(pay,'999,999,999L') pay,to_char(bonus,'999,999,999L') bonus from mymember";
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			System.out.println("[사원정보]");
			System.out.println("사원번호\t사원명\t부서\t직급\t성별\t월급여\t보너스");
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
		
		System.out.println("검색할 데이터의 사원명을 입력하세요!!");
		String s = sc.nextLine();
		
		String sql = "select * from mymember where name like '%"
		+ s + "%'";
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			System.out.println("[검색결과]");
			
			System.out.println("사원번호\t사원명\t부서\t직급\t성별\t월급여\t보너스");
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
	
	//처리
	//while,switch
	public void process() {
		
		while(true) {
			System.out.println("**MyMember**");
			System.out.println("1.사원정보입력 2.전체사원출력 3.사원삭제 4.사원수정 5.이름검색 0.시스템종료");
			int n = Integer.parseInt(sc.nextLine());
			
			if(n==0) {
				System.out.println("시스템을 종료합니다");
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
