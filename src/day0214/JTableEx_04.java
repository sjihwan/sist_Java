package day0214;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JTableEx_04 extends JFrame{
	Container cp;
	JTable table;
	JLabel lblTitle,lblOut;
	
	//생성자
	public JTableEx_04(String title) {
		super(title);
		
		this.setBounds(100, 100, 400, 400);						//윈도우창(this) 크기,위치
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//윈도우창 닫았을때 종료
		
		cp = this.getContentPane();								//윈도우 컨텐트패널
		cp.setBackground(new Color(255, 255, 155));				//컨텐트패널 배경색 지정
		
		setDesign();											//디자인메서드 호출
		
		this.setVisible(true);									
	}
	
	//디자인메서드
	public void setDesign() {
		String [][] data = {									//2차원 배열
				{"송혜교","서울","010-7777-8888"},
				{"강호동","제주","010-8888-5264"},
				{"하하","인천","010-1111-2222"}
		};
		String [] title = {"이름","주소","연락처"};
		
		//라벨 생성
		lblTitle = new JLabel("JTable연습", JLabel.CENTER);
		lblOut = new JLabel("결과 나오는 곳", JLabel.CENTER);
		
		table = new JTable(data, title);
		JScrollPane pane = new JScrollPane(table);
		
		//테이블에 마우스 이벤트 추가
		table.addMouseListener(new TableEvent());
		
		this.add("North",lblTitle);
		this.add("Center",pane);
		this.add("South",lblOut);
	}
	
	//마우스 이벤트<=테이블 클릭시
	class TableEvent extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			//System.out.println("테이블 클릭!!");
			
			//선택한 행번호 얻기
			int rowNum = table.getSelectedRow();			
			//JOptionPane.showMessageDialog(JTableEx_04.this, "행번호: "+rowNum);			
			String str = "이름: "+table.getValueAt(rowNum, 0)
			+", 주소: "+table.getValueAt(rowNum, 1)
			+", 핸드폰: "+table.getValueAt(rowNum, 2);
			
			lblOut.setText(str);
		}
	}
	
	public static void main(String[] args) {
		new JTableEx_04("JTable_01");
	}

}