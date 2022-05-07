package day0225;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SawonAdd_03 {
	
	DbConnect db = new DbConnect();
	Scanner sc = new Scanner(System.in);
	
	//데이터 추가
	public void InsertSawon() {
		System.out.println("**사원추가하기**");
		System.out.println("사원명?");
		String name = sc.nextLine();
		System.out.println("부서명?");
		String buseo = sc.nextLine();
		System.out.println("성별(남자/여자)");
		String gender = sc.nextLine();
		System.out.println("월급여?");
		int pay = Integer.parseInt(sc.nextLine());
		
		//자바에서 작성한걸 db에 담으려면 Connection,Statement...완성형 sql
		String sql = "insert into sawon values(seq_sawon.nextval,'"+name+"','"+gender+"','"+buseo+"',"+pay+")";
		//insert into sawon values(seq_sawon.nextval,'수지','여자','홍보부',3460000)
		//System.out.println(sql);
		
		//오라클에 연결
		Connection conn = db.getOracle();
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			stmt.execute(sql);	//sql문 실행(insert,delete,update..execute() or executeUpdate() 둘중하나 사용)
			
			//int a = stmt.executeUpdate(sql); //성공한 데이터의 갯수
			//System.out.println(a);
			
			System.out.println("DB에 추가되었습니다");			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(stmt, conn);
		}
	}
	
	//데이터 조회
	public void writeSawon() {
		//전체 사원명단
		//사원번호 사원명 성별 부서명 월급여
		String sql = "select * from sawon";
		
		Connection conn = db.getOracle();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			System.out.println("사원번호\t사원명\t성별\t부서명\t월급여");
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
	
	//삭제..사원명을 입력하면 삭제
	public void deleteSawon() {
		System.out.println("삭제할 사원명을 입력해주세요");
		String name = sc.nextLine();
		
		//delete from sawon where name='김선호'..이렇게 sql문 작성
		String sql="delete from sawon where name='"+name+"'";
		
		Connection conn = db.getOracle();
		Statement stmt = null;
		
		try {
			stmt = conn.createStatement();
			//stmt.execute(sql);
			
			//이름이 없을 경우 0반환
			int n = stmt.executeUpdate(sql);
			if(n==0) {
				System.out.println(name+"님은 사원명단에 없습니다");
			}
			else
				System.out.println(name+"님을 명단에서 삭제했습니다");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(stmt, conn);
		}
	}
	
	//수정..update(사원번호 입력후 이름,부서,급여 변경가능)
	public void updateSawon() {
		System.out.println("수정할 사원번호는?");
		int num = Integer.parseInt(sc.nextLine());
		System.out.println("수정할 이름 입력");
		String name = sc.nextLine();
		System.out.println("수정할 부서 입력");
		String buseo = sc.nextLine();
		System.out.println("수정할 급여 입력");
		int pay = Integer.parseInt(sc.nextLine());
		
		String sql = "update sawon set name='"+name+"',buseo='"+buseo+"',pay="+pay+" where num="+num;
		
		//db연결
		Connection conn = db.getOracle();
		Statement stmt = null;
		
		try {
			stmt = conn.createStatement();
			
			int n = stmt.executeUpdate(sql);
			
			if(n==0)
				System.out.println("수정할 데이터가 존재하지 없습니다");
			else
				System.out.println(num+"번의 데이터가 수정되었습니다");			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void searchSawon() {
		System.out.println("검색할 사원은 누구입니까(일부도 가능)");
		String s = sc.nextLine();
		
		String sql = "select num,name,gender,buseo,to_char(pay,'L999,999,999') pay from sawon where name like '%"+s+"%'";
		
		Connection conn = db.getOracle();
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			int n = stmt.executeUpdate(sql);
			
			if(n==0)
				System.out.println("검색한 사원은 데이터에 없습니다");
			else {
				rs = stmt.executeQuery(sql);
				System.out.println("사원번호\t사원명\t성별\t부서명\t월급여");
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
			System.out.println("**Oracle Db 연습문제**");
			System.out.println("1.insert  2.select  3.update  4.delete  5.사원검색  9.exit");
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
				System.out.println("종료합니다");
				break;
			}
		}
	}

}
