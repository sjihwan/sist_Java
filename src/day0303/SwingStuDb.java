package day0303;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import day0225.DbConnect;

public class SwingStuDb extends JFrame implements ActionListener{
	DbConnect db = new DbConnect();
	Container cp;
	DefaultTableModel model;
	JTable table;
	JButton btnAdd,btnDel,btnUpdate;
	
	//AddFrame,UpdateFrame
	AddFrame addFrame = new AddFrame("성적추가");
	UpdateFrame updateFrame = new UpdateFrame("성적수정");
	
	public SwingStuDb(String title) {
		super(title);
		cp = this.getContentPane();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(200, 100, 400, 300);
		cp.setBackground(new Color(255, 255, 200));
		this.initDesign();
		this.setVisible(true);
	}
	//디자인
	public void initDesign() {
		String[] title = {"번호","이름","반","Java","Jsp","Spring","총점","평균"};
		
		model = new DefaultTableModel(title, 0);
		table = new JTable(model);
		this.add("Center", new JScrollPane(table));
		
		//테이블에 DB데이터 출력
		tableWrite();
		
		JPanel pTop = new JPanel();
		this.add("North", pTop);
		
		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		pTop.add(btnAdd);
		
		btnDel = new JButton("삭제");
		btnDel.addActionListener(this);
		pTop.add(btnDel);
		
		btnUpdate = new JButton("수정");
		btnUpdate.addActionListener(this);
		pTop.add(btnUpdate);
		
		//새로 생성된 프레임의 버튼...이벤트 메서드 연결
		addFrame.btnAdd.addActionListener(this);
		updateFrame.btnMod.addActionListener(this);
	}
	//insert...addFrame.btnAdd를 클릭시
	public void insertData() {
		String name = addFrame.tfName.getText();
		String java = addFrame.tfJava.getText();
		String jsp = addFrame.tfJsp.getText();
		String spring = addFrame.tfSpring.getText();
		String ban = (String)addFrame.cbBan.getSelectedItem();
		
		int tot = Integer.parseInt(java) + Integer.parseInt(jsp) + Integer.parseInt(spring);
		double avg = tot/3.0;
		
		String sql = "insert into studentinfo values(seq_test.nextval,?,?,?,?,?,?,?)";
		
		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, name);
			pstmt.setString(2, java);
			pstmt.setString(3, jsp);
			pstmt.setString(4, spring);
			pstmt.setInt(5, tot);
			pstmt.setDouble(6, avg);
			pstmt.setString(7, ban);
			
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	//삭제메서드
	public void deleteData(String num) {
		System.out.println("num=" + num);
		String sql = "delete from studentinfo where num=" + num;
		
		//sql문 실행후 해당번호가 없으면 메세지..삭제되면 새로고침
		//새로고침의 의미는 tableWrite()호출
		
		Connection conn = db.getOracle();
		Statement stmt = null;
		
		try {
			stmt = conn.createStatement();
			int a = stmt.executeUpdate(sql);
			
			if(a==0)
				JOptionPane.showMessageDialog(this, "없는 데이터 번호 입니다");
			else
				tableWrite();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//테이블에 출력하는 메서드
	public void tableWrite() {
		//테이블초기화
		model.setRowCount(0);
		
		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		//시퀀스 오름차순
		String sql = "select * from studentinfo order by num asc";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Vector<String> data = new Vector<String>();
				data.add(rs.getString("num"));
				data.add(rs.getString("name"));
				data.add(rs.getString("ban"));
				data.add(rs.getString("java"));
				data.add(rs.getString("jsp"));
				data.add(rs.getString("spring"));
				data.add(rs.getString("total"));
				data.add(rs.getString("average"));
				
				//테이블에 추가
				model.addRow(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {

		Object ob = e.getSource();
		
		if(ob==btnAdd) {
//			System.out.println("add");
			addFrame.setVisible(true);
		}
		else if(ob==btnDel) {
//			System.out.println("del");
			String num = JOptionPane.showInputDialog("삭제할 데이터 번호를 입력해주세요");
			deleteData(num);
		}
		else if(ob==btnUpdate) {
//			System.out.println("update");
//			updateFrame.setVisible(true);		
			String num = JOptionPane.showInputDialog("수정할 데이터의 번호를 입력하세여");
			
			String sql = "select * from studentinfo where num=" + num;
			
			Connection conn = db.getOracle();
			Statement stmt = null;
			ResultSet rs = null;
			
			try {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				
				if(rs.next()) {
					updateFrame.num = num; //hidden으로 num값 넘긴다
					updateFrame.tfName.setText(rs.getString("name"));
					updateFrame.tfJava.setText(rs.getString("java"));
					updateFrame.tfJsp.setText(rs.getString("jsp"));
					updateFrame.tfSpring.setText(rs.getString("spring"));
					updateFrame.cbBan.setSelectedItem(rs.getString("ban"));
					updateFrame.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(this, "해당번호는 없는 번호입니다");
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			} finally {
				db.dbClose(rs, stmt, conn);
			}			
		}
		else if(ob==addFrame.btnAdd) {
//			System.out.println("추가프레임 액션테스트");
			//입력데이터 읽어와서 db추가
			insertData();
			//테이블을 다시 출력
			tableWrite();
			
			//초기화
			addFrame.tfName.setText("");
			addFrame.tfJava.setText("");
			addFrame.tfJsp.setText("");
			addFrame.tfSpring.setText("");
			addFrame.tfName.requestFocus();
			addFrame.cbBan.setSelectedIndex(0);
			
			//추가프레임 사라지게
			addFrame.setVisible(false);
		}
		else if(ob==updateFrame.btnMod) {
			
			updateData();
			tableWrite();
			updateFrame.setVisible(false);
			
		}
		
	}
	
	public void updateData() {
		
		String num = updateFrame.num;
		String name = updateFrame.tfName.getText();
		String java = updateFrame.tfJava.getText();
		String jsp = updateFrame.tfJsp.getText();
		String spring = updateFrame.tfSpring.getText();
		String ban = (String)updateFrame.cbBan.getSelectedItem();
		
		int tot = Integer.parseInt(java) + Integer.parseInt(jsp) + Integer.parseInt(spring);
		double avg = tot/3.0;
		
		String sql = "update studentinfo set name=?, java=?, jsp=?, spring=?, ban=?, total=?, average=? where num=?";
		
		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, name);
			pstmt.setString(2, java);
			pstmt.setString(3, jsp);
			pstmt.setString(4, spring);
			pstmt.setString(5, ban);
			pstmt.setInt(6, tot);
			pstmt.setDouble(7, avg);
			pstmt.setString(8,num);
			
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
		
	}
	
	public static void main(String[] args) {

		new SwingStuDb("성적관리DB");
		
	}

}
