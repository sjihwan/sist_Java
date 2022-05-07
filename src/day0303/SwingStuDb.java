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
	AddFrame addFrame = new AddFrame("�����߰�");
	UpdateFrame updateFrame = new UpdateFrame("��������");
	
	public SwingStuDb(String title) {
		super(title);
		cp = this.getContentPane();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(200, 100, 400, 300);
		cp.setBackground(new Color(255, 255, 200));
		this.initDesign();
		this.setVisible(true);
	}
	//������
	public void initDesign() {
		String[] title = {"��ȣ","�̸�","��","Java","Jsp","Spring","����","���"};
		
		model = new DefaultTableModel(title, 0);
		table = new JTable(model);
		this.add("Center", new JScrollPane(table));
		
		//���̺� DB������ ���
		tableWrite();
		
		JPanel pTop = new JPanel();
		this.add("North", pTop);
		
		btnAdd = new JButton("�߰�");
		btnAdd.addActionListener(this);
		pTop.add(btnAdd);
		
		btnDel = new JButton("����");
		btnDel.addActionListener(this);
		pTop.add(btnDel);
		
		btnUpdate = new JButton("����");
		btnUpdate.addActionListener(this);
		pTop.add(btnUpdate);
		
		//���� ������ �������� ��ư...�̺�Ʈ �޼��� ����
		addFrame.btnAdd.addActionListener(this);
		updateFrame.btnMod.addActionListener(this);
	}
	//insert...addFrame.btnAdd�� Ŭ����
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
	//�����޼���
	public void deleteData(String num) {
		System.out.println("num=" + num);
		String sql = "delete from studentinfo where num=" + num;
		
		//sql�� ������ �ش��ȣ�� ������ �޼���..�����Ǹ� ���ΰ�ħ
		//���ΰ�ħ�� �ǹ̴� tableWrite()ȣ��
		
		Connection conn = db.getOracle();
		Statement stmt = null;
		
		try {
			stmt = conn.createStatement();
			int a = stmt.executeUpdate(sql);
			
			if(a==0)
				JOptionPane.showMessageDialog(this, "���� ������ ��ȣ �Դϴ�");
			else
				tableWrite();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//���̺� ����ϴ� �޼���
	public void tableWrite() {
		//���̺��ʱ�ȭ
		model.setRowCount(0);
		
		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		//������ ��������
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
				
				//���̺� �߰�
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
			String num = JOptionPane.showInputDialog("������ ������ ��ȣ�� �Է����ּ���");
			deleteData(num);
		}
		else if(ob==btnUpdate) {
//			System.out.println("update");
//			updateFrame.setVisible(true);		
			String num = JOptionPane.showInputDialog("������ �������� ��ȣ�� �Է��ϼ���");
			
			String sql = "select * from studentinfo where num=" + num;
			
			Connection conn = db.getOracle();
			Statement stmt = null;
			ResultSet rs = null;
			
			try {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				
				if(rs.next()) {
					updateFrame.num = num; //hidden���� num�� �ѱ��
					updateFrame.tfName.setText(rs.getString("name"));
					updateFrame.tfJava.setText(rs.getString("java"));
					updateFrame.tfJsp.setText(rs.getString("jsp"));
					updateFrame.tfSpring.setText(rs.getString("spring"));
					updateFrame.cbBan.setSelectedItem(rs.getString("ban"));
					updateFrame.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(this, "�ش��ȣ�� ���� ��ȣ�Դϴ�");
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			} finally {
				db.dbClose(rs, stmt, conn);
			}			
		}
		else if(ob==addFrame.btnAdd) {
//			System.out.println("�߰������� �׼��׽�Ʈ");
			//�Էµ����� �о�ͼ� db�߰�
			insertData();
			//���̺��� �ٽ� ���
			tableWrite();
			
			//�ʱ�ȭ
			addFrame.tfName.setText("");
			addFrame.tfJava.setText("");
			addFrame.tfJsp.setText("");
			addFrame.tfSpring.setText("");
			addFrame.tfName.requestFocus();
			addFrame.cbBan.setSelectedIndex(0);
			
			//�߰������� �������
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

		new SwingStuDb("��������DB");
		
	}

}
