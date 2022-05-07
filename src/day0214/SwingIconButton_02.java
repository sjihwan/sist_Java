package day0214;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingIconButton_02 extends JFrame{
	ImageIcon icon1 = new ImageIcon("C:\\sist0117\\jquery_img\\01.png");
	ImageIcon icon2 = new ImageIcon("C:\\sist0117\\jquery_img\\02.png");
	ImageIcon icon3 = new ImageIcon("C:\\sist0117\\jquery_img\\03.png");
	ImageIcon icon4 = new ImageIcon("C:\\sist0117\\swingimage\\leftDown.gif");
	ImageIcon icon5 = new ImageIcon("C:\\sist0117\\swingimage\\LEFT.gif");
	ImageIcon icon6 = new ImageIcon("C:\\sist0117\\swingimage\\chick.gif");
	
	JButton btn1,btn2,btn3,btn4;
	
	public SwingIconButton_02(String title) {
		super(title);
		this.setBounds(200,100,400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(new Color(255,200,155));
		
		//디자인메서드 호출
		initDesign();
		
		this.setVisible(true);
	}
	
	public void initDesign() {
		this.setLayout(new GridLayout(2, 2));  //버튼을 2행 2열로 배치
		
		btn1 = new JButton("hello", icon1);
		btn1.setHorizontalTextPosition(JButton.CENTER);
		btn1.setVerticalTextPosition(JButton.TOP);
		
		this.add(btn1);
		
		btn1.setRolloverIcon(icon4);  //마우스 올릴때 아이콘
		btn1.setPressedIcon(icon5);  //클릭시 아이콘
		
		btn2 = new JButton(icon2);
		this.add(btn2);
		
		btn3 = new JButton(icon3);
		this.add(btn3);
		
		btn4 = new JButton("Hi", icon6);
		this.add(btn4);
	}
	
	public static void main(String[] args) {
		new SwingIconButton_02("버튼 아이콘 연습");
	}
}
