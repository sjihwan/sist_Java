package day0214;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class TextLable_07 extends JFrame{
	//컨테이너 클래스 호출(참조변수 선언)
	Container cp;	
	JButton btn1;
	//텍스트 필드, 라벨
	JTextField text1,text2;
	JLabel label1,label2,label3,label4,lbResult;
	
	Icon icon1 = new ImageIcon("C:\\sist0117\\swingimage\\an07.gif");
	Icon icon2 = new ImageIcon("C:\\sist0117\\swingimage\\an08.gif");
	
	public TextLable_07(String title) {
		super(title);
		cp = this.getContentPane();
		this.setBounds(200,100,500,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cp.setBackground(new Color(255,200,155));
		initDesign();
		this.setVisible(true);
	}
	
	//디자인 메서드
	public void initDesign() {
		this.setLayout(null);
		
		text1 = new JTextField();
		text1.setBounds(10,20,90,30);
		this.add(text1);
		
		text2 = new JTextField("Have a Nice Day!!");
		text2.setBounds(10,60,150,30);
		this.add(text2);
		
		label1 = new JLabel("안녕하세요", JLabel.CENTER);
		label1.setBounds(10,100,200,30);
		label1.setBackground(Color.gray);
		label1.setOpaque(true);	//불투명모드..라벨에서 적용
		this.add(label1);
		
		label2 = new JLabel("Today", icon1, JLabel.RIGHT);
		label2.setBounds(10,150,200,30);
		
		//Border인터페이스 구현한 LineBorder,TitleBorder
		label2.setBorder(new LineBorder(Color.red));
		this.add(label2);
		
		label3 = new JLabel("스윙공부중", icon2, JLabel.CENTER);
		label3.setBounds(10,210,200,50);
		label3.setBorder(new TitledBorder("SIST"));
		this.add(label3);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분");
		
		label4 = new JLabel(sdf.format(new Date()), icon1, JLabel.CENTER);
		label4.setBounds(10, 260, 300, 50);
		label4.setBorder(new LineBorder(Color.pink, 5));
		this.add(label4);
		
		/*
		 * title 결과확인
		 * 밑에 버튼
		 */
		lbResult = new JLabel("결과 나오는 곳",icon1,JLabel.CENTER);
		lbResult.setBounds(250, 100, 200, 70);
//		lbResult.setBorder(new TitledBorder("결과확인"));
		TitledBorder border = new TitledBorder("결과 확인");
		border.setBorder(new LineBorder(Color.blue));
		lbResult.setBorder(border);
		this.add(lbResult);
		
		btn1 = new JButton("클릭");
		btn1.setBounds(300, 200, 70, 30);
		this.add(btn1);
		
		//확인버튼 누를 이벤트..익명내부 클래스
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String s = text1.getText();
				String s1 = text2.getText();
				lbResult.setText(s1);
			}
		});
	}
	
	public static void main(String[] args) {
		new TextLable_07("텍스트 라벨");
	}

}
