package day0225;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcHello {
	//객체 호출
	DbConnect db = new DbConnect();
	Scanner sc = new Scanner(System.in);
	
	//추가삽입
	//시퀀스번호 이름 주소 날짜
	public void insertHello() {
		System.out.println("이름은?");
		String name = sc.nextLine();
		System.out.println("주소는?");
		String addr = sc.nextLine();
		
		String sql = "Insert into hello values(seq_hello.nextval,'"+name+"','"+addr+"',sysdate)";
		
		//오라클db에 연결
		Connection conn = db.getOracle();
		//sql문 작성준비1
		Statement stmt = null;
		try {
			stmt = conn.createStatement(); //sql문 작성준비
			stmt.execute(sql);			
			System.out.println("DB에 추가되었습니다");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.dbClose(stmt, conn);
		}
	}
	
	//조회
	public void selectHello() {
		String sql = "select * from hello";
		
		Connection conn = db.getOracle();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			System.out.println("전체 데이터를 조회합니다");
			System.out.println("번호\t이름\t주소\t날짜");
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
	
	//삭제
	//num을 입력후 삭제할것!!
	public void deleteHello() {
		System.out.println("삭제할 데이터의 번호를 입력하세요");
		int num = Integer.parseInt(sc.nextLine());
		
		String sql = "delete from hello where num="+num;
		
		Connection conn = db.getOracle();
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			int n = stmt.executeUpdate(sql);
			if(n==0)
				System.out.println(num+"번의 데이터는 존재하지 않습니다");
			else
				System.out.println(num+"번의 데이터를 삭제했습니다");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.dbClose(stmt, conn);
		}
	}
	
	//수정
	//num을 입력후 이름,주소 수정할것!!
	public void updateHello() {
		System.out.println("수정할 데이터의 번호를 입력하세요");
		int num = Integer.parseInt(sc.nextLine());
		System.out.println("수정할 이름을 입력하세요");
		String name = sc.nextLine();
		System.out.println("수정할 주소를 입력하세요");
		String addr = sc.nextLine();
		System.out.println("수정할 날짜를 입력하세요");
		String sdate = sc.nextLine();
		
		Connection conn = db.getOracle();
		Statement stmt = null;
		
		String sql = "update hello set name ='"+name+"',addr='"+addr+"',sdate='"+sdate+"' where num="+num;
		
		try {
			stmt=conn.createStatement();
			
			int n = stmt.executeUpdate(sql);
			
			if(n==0) {
				System.out.println("수정할 데이터번호가 존재하지 않습니다");
			}
			else
				System.out.println(num+"번의 데이터가 수정되었습니다");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	//DB조작 메서드를 실행시켜주는 메서드?
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
				System.out.println("종료합니다");
				return;
			}
		}
	}

	public static void main(String[] args) {
		//process() 호출하여 확인할것!!
		//아까처럼 메인에서 Scanner로 각각 호출해도 됩니다
		JdbcHello hello = new JdbcHello();
		hello.process();
	}

}
