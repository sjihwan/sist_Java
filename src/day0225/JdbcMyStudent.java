package day0225;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
 * 1.DbConnect..Connect,dbClose
 * 2.main클래스..DbConnect생성_connect,dbclose에 관한건 메서드 호출해서 사용한다
 * 3.main클래스
 * -insert (시퀀스,이름,핸드폰,나이,현재날짜 입력)_아무 시퀀스
 * -write (시퀀스,이름,핸드폰,나이,현재날짜)
 * -delete 시퀀스를 입력하여 있으면 삭제
 * -update 시퀀스를 입력하여 있으면 핸드폰,나이 수정
 * 
 * 메인메서드에서 출력
 * **학생정보**
 * **1.입력 2.출력 3.수정 4.삭제 5.종료**
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
//		System.out.println(sql);  //sql문 입력확인
		
		//Connection
		//Statement...execute
		
		Connection conn = db.getOracle();
		Statement stmt = null;
		
		try {
			stmt = conn.createStatement();
			int n = stmt.executeUpdate(sql); //리턴값이 있으면=>1,없으면=>0
			
			if(n==1)
				System.out.println("insert성공!!");
			else
				System.out.println("insert실패!!");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(stmt, conn);
		}
		
	}	
	
	//write
	//시퀀스	이름	핸드폰	나이	가입날짜
	public void writeMystudent() {
		
		Connection conn = db.getOracle();
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "select * from mystudent";
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			System.out.println("시퀀스\t이름\t핸드폰\t나이\t가입날짜");
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
		
		System.out.println("수정할 번호는?");
		num = Integer.parseInt(sc.nextLine());
		System.out.println("수정할 핸드폰 번호는?");
		hp = sc.nextLine();
		System.out.println("수정할 나이는?");
		age = Integer.parseInt(sc.nextLine());

		sql = "update mystudent set hp='" + hp + "', age=" + age + " where num=" + num;
		
		try {
			stmt = conn.createStatement();
			int n = stmt.executeUpdate(sql);
			
			if(n==1)
				System.out.println(num + "번 데이터가 수정되었습니다!!");
			else
				System.out.println("수정할 " + num + "번 데이터가 없습니다!!");
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
		
		System.out.println("삭제할 번호는?");
		int num = Integer.parseInt(sc.nextLine());
		
		String sql = "delete from mystudent where num=" + num;
		
		try {
			stmt = conn.createStatement();
			int n = stmt.executeUpdate(sql);
			
			if(n>0)
				System.out.println(num + "번 삭제성공!!");
			else
				System.out.println(num + "번은 없는 데이터입니다");
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
			System.out.println("**학생정보**");
			System.out.println("**1.입력 2.출력 3.수정 4.삭제 5.종료**");
			int n = sc.nextInt();
			
			if(n==5) {
				System.out.println("프로그램 종료");
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
