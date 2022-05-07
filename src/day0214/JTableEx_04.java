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
	
	//������
	public JTableEx_04(String title) {
		super(title);
		
		this.setBounds(100, 100, 400, 400);						//������â(this) ũ��,��ġ
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//������â �ݾ����� ����
		
		cp = this.getContentPane();								//������ ����Ʈ�г�
		cp.setBackground(new Color(255, 255, 155));				//����Ʈ�г� ���� ����
		
		setDesign();											//�����θ޼��� ȣ��
		
		this.setVisible(true);									
	}
	
	//�����θ޼���
	public void setDesign() {
		String [][] data = {									//2���� �迭
				{"������","����","010-7777-8888"},
				{"��ȣ��","����","010-8888-5264"},
				{"����","��õ","010-1111-2222"}
		};
		String [] title = {"�̸�","�ּ�","����ó"};
		
		//�� ����
		lblTitle = new JLabel("JTable����", JLabel.CENTER);
		lblOut = new JLabel("��� ������ ��", JLabel.CENTER);
		
		table = new JTable(data, title);
		JScrollPane pane = new JScrollPane(table);
		
		//���̺� ���콺 �̺�Ʈ �߰�
		table.addMouseListener(new TableEvent());
		
		this.add("North",lblTitle);
		this.add("Center",pane);
		this.add("South",lblOut);
	}
	
	//���콺 �̺�Ʈ<=���̺� Ŭ����
	class TableEvent extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			//System.out.println("���̺� Ŭ��!!");
			
			//������ ���ȣ ���
			int rowNum = table.getSelectedRow();			
			//JOptionPane.showMessageDialog(JTableEx_04.this, "���ȣ: "+rowNum);			
			String str = "�̸�: "+table.getValueAt(rowNum, 0)
			+", �ּ�: "+table.getValueAt(rowNum, 1)
			+", �ڵ���: "+table.getValueAt(rowNum, 2);
			
			lblOut.setText(str);
		}
	}
	
	public static void main(String[] args) {
		new JTableEx_04("JTable_01");
	}

}