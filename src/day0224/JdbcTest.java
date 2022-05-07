package day0224;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest {
	
	//로컬로 오라클 연결
	static final String ORACLE_LOCAL="jdbc:oracle:thin:@localhost:1521:XE";
	//cloud 오라클 연결
//	static final String ORACLE_CLOUD="jdbc:oracle:thin:@db202202172315_high?TNS_ADMIN=C:/sist..";

	//sawon_oracle_sawon
	public void connectSawon() {
		//connection->statement->resultset
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;  //반드시 ResultSet객체를 얻어야 한다
		
		String sql = "select * from sawon order by num";
		
		try {
			conn=DriverManager.getConnection(ORACLE_LOCAL, "shin", "a1234");
			System.out.println("오라클 서버 연결 성공!!!");
			
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			System.out.println("**사원리스트**");
			System.out.println("사원번호\t사원명\t성별\t부서명\t급여");
			System.out.println("------------------------------------------------");
			
			//여러줄을 읽어와야 하므로 while문으로 가져온다
			//rs.next():
			while(rs.next()) {
				//db로부터 데이터 가져오기
				int num=rs.getInt("num");
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				String buseo = rs.getString("buseo");
				int pay = rs.getInt("pay");
				System.out.println(num+"\t"+name+"\t"+gender+"\t"+buseo+"\t");
			}			
		} catch (SQLException e) {
			System.out.println("오라클 연결 실패!!!");
		} finally {
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	//food+jumun
	//주문번호 주문자 음식명 가격 배달지주소
	public void connectionBaedal() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "select f.fno, name, food, price, addr from food f, jumun j where f.fno=j.fno";
		try {
			conn=DriverManager.getConnection(ORACLE_LOCAL, "shin", "a1234");
			System.out.println("오라클 서버 연결 성공!!!");
			
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			System.out.println("**배달리스트**");
			System.out.println("주문번호\t주문자\t음식명\t가격\t배달지주소");
			System.out.println("------------------------------------------------");
			
			while(rs.next()) {
				//db로부터 데이터 가져오기
				int num=rs.getInt("fno");  //""안은 실제 db컬럼명 //f.fno는 안됨
				String name = rs.getString("name");
				String food = rs.getString("food");
				int price = rs.getInt("price");
				String addr = rs.getString("addr");
				System.out.println(num+"\t"+name+"\t"+food+"\t"+price+"\t"+addr);
			}			
		} catch (SQLException e) {
			System.out.println("오라클 연결 실패!!");
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		JdbcTest ex=new JdbcTest();
		ex.connectSawon();
		ex.connectionBaedal();
	}

}
