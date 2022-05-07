package day0304;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import day0303.DbConnect;

public class SawonDbSwing extends JFrame implements ItemListener,ActionListener{
    DbConnect db=new DbConnect();
    Container cp;
    DefaultTableModel model;
    JTable table;
    JRadioButton [] rb=new JRadioButton[6];
    JButton btnDel,btnIns;
    //������
    public SawonDbSwing(String title) {
        super(title);
        cp=this.getContentPane();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(800, 100, 700, 500);
        cp.setBackground(new Color(255,255,155));
        this.initDesign();
        
        this.sawonTableWrite(1);
        
        this.setVisible(true);
    }
    //������
    public void initDesign() {
        this.setLayout(null);

        String [] title= {"NO.", "ID", "�����", "�μ���", "����", "���޿�"};
        model=new DefaultTableModel(title, 0);
        table=new JTable(model);
        JScrollPane js=new JScrollPane(table);
        js.setBounds(10, 100, 670, 350);
        this.add(js);

        //������ư
        int xpos=250;
        btnDel=new JButton("����");
        btnDel.setBounds(xpos, 10, 60, 30);
        btnDel.addActionListener(this);
        this.add(btnDel);
        //�߰���ư
        xpos=320;
        btnIns=new JButton("�߰�");
        btnIns.setBounds(xpos, 10, 60, 30);
        btnIns.addActionListener(this);
        this.add(btnIns);
        
        //������ư �߰�
        ButtonGroup bg=new ButtonGroup();

        //1.��ü��� 2.���� 3.���� 4.���ߺ� 5.ȫ���� 6.������ 
        String [] rb_label={"��ü", "����", "����", "���ߺ�", "ȫ����", "������"};
        
        xpos=10;
        
        for(int i=0;i<rb.length;i++) {
            //������ư ����
            rb[i]=new JRadioButton(rb_label[i], i==0?true:false);
            rb[i].setBounds(xpos, 50, 90, 30);
            rb[i].setOpaque(false);

            //�̺�Ʈ �߰�
            rb[i].addItemListener(this);
            bg.add(rb[i]);
            this.add(rb[i]);
            xpos+=100;
        }
    }
    //db��ȸ�ؼ� ���̺� �߰��ϱ�
    //1.��ü��� 2.���� 3.���� 4.���ߺ� 5.ȫ���� 6.������ 
    public void sawonTableWrite(int select) {
        String sql="";
        if(select==1)
            sql="select ROWNUM no,num id,name,buseo,gender,to_char(pay,'L999,999,999') pay from sawon";
        else if(select==2)
        	sql="select ROWNUM no,num id,name,buseo,gender,to_char(pay,'L999,999,999') pay from sawon where gender='����'";
        else if(select==3)
        	sql="select ROWNUM no,num id,name,buseo,gender,to_char(pay,'L999,999,999') pay from sawon where gender='����'";
        else if(select==4)
        	sql="select ROWNUM no,num id,name,buseo,gender,to_char(pay,'L999,999,999') pay from sawon where buseo='���ߺ�'";
        else if(select==5)
        	sql="select ROWNUM no,num id,name,buseo,gender,to_char(pay,'L999,999,999') pay from sawon where buseo='ȫ����'";
        else if(select==6)
        	sql="select ROWNUM no,num id,name,buseo,gender,to_char(pay,'L999,999,999') pay from sawon where buseo='������'";

        Connection conn=db.getOracle();
        Statement stmt=null;
        ResultSet rs=null;

        try {
            stmt=conn.createStatement();
            rs=stmt.executeQuery(sql);

            //������ ������ ������ ��������
            model.setRowCount(0);
            while(rs.next()) {
                //���̺� �߰��� ���� ������ ������ �߰�
                Vector<String> data=new Vector<String>();

                data.add(rs.getString("no"));
                data.add(rs.getString("id"));
                data.add(rs.getString("name"));
                data.add(rs.getString("buseo"));
                data.add(rs.getString("gender"));
                data.add(rs.getString("pay"));

                //���͸� ������ ������ �߰�
                model.addRow(data);
            }
        } catch (SQLException e) {
            // TODO: handle exception
        }finally {
        	db.dbClose(rs, stmt, conn);
        }

    }
    @Override
    public void itemStateChanged(ItemEvent e) {
    	Object ob=e.getItem();
    	
    	for(int i=0; i<rb.length; i++) {
    		if(rb[i]==ob)
    			this.sawonTableWrite(i+1);
    	}
//    	if(ob==rb[0])
//    		sawonTableWrite(1);
//    	else if(ob==rb[1])
//    		sawonTableWrite(2);
//    	else if(ob==rb[2])
//    		sawonTableWrite(3);
//    	else if(ob==rb[3])
//    		sawonTableWrite(4);
//    	else if(ob==rb[4])
//    		sawonTableWrite(5);
//    	else
//    		sawonTableWrite(6);
    }
    @Override
	public void actionPerformed(ActionEvent e) {
    	Object ob = e.getSource();
    	
    	Connection conn = db.getOracle();
		PreparedStatement pstmt = null;
		Statement stmt = null;
		
    	String sql="";
    	if(ob==btnDel) {
    		//���ȣ ���...���þ��ҽ� -1
    		int row = table.getSelectedRow();
    		System.out.println(row);
    		
    		if(row==-1) {
    			JOptionPane.showMessageDialog(this, "������ ���� �������ּ���");
    			return;
    		}
    		
    		//������ ���� id(num)�� ���
    		String num=(String)model.getValueAt(row, 1);
    		
    		//num�� �ش��ϴ� db������ ����...���̺� �ٽ� ���
    		sql="delete from sawon where num=?";
    		
    		try {
				pstmt=conn.prepareStatement(sql);
				
				pstmt.setString(1, num);
				
				pstmt.execute();
				
				//������ �ٽúҷ�����
				this.sawonTableWrite(1);
				
				JOptionPane.showMessageDialog(this, "������ ���� �����Ͱ� �����Ǿ����ϴ�!!");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally {
				db.dbClose(pstmt, conn);
			}
    	}else if(ob==btnIns) {
    		//�̸�,����,�μ�,�޿�
    		String name=JOptionPane.showInputDialog("�л����� �Է����ּ���");
    		String gender=JOptionPane.showInputDialog("������ �Է����ּ���");
    		String buseo=JOptionPane.showInputDialog("�μ��� �Է����ּ���");
    		int pay=Integer.parseInt(JOptionPane.showInputDialog("���޿��� �Է����ּ���"));
    		
    		sql="insert into sawon values(seq_sawon.nextval, '"+name+"', '"+gender+"', '"+buseo+"', "+pay+")";
    		
    		try {
				stmt=conn.createStatement();
				stmt.execute(sql);
				
				this.sawonTableWrite(1);
				
				JOptionPane.showMessageDialog(this, "�Է��� �����Ͱ� �߰��Ǿ����ϴ�!!");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally {
				db.dbClose(stmt, conn);
			}
    	}
	}
    public static void main(String[] args) {
        new SawonDbSwing("�����ȸ���̺�");
    }
	

}
