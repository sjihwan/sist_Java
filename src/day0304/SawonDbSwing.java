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
    //생성자
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
    //디자인
    public void initDesign() {
        this.setLayout(null);

        String [] title= {"NO.", "ID", "사원명", "부서명", "성별", "월급여"};
        model=new DefaultTableModel(title, 0);
        table=new JTable(model);
        JScrollPane js=new JScrollPane(table);
        js.setBounds(10, 100, 670, 350);
        this.add(js);

        //삭제버튼
        int xpos=250;
        btnDel=new JButton("삭제");
        btnDel.setBounds(xpos, 10, 60, 30);
        btnDel.addActionListener(this);
        this.add(btnDel);
        //추가버튼
        xpos=320;
        btnIns=new JButton("추가");
        btnIns.setBounds(xpos, 10, 60, 30);
        btnIns.addActionListener(this);
        this.add(btnIns);
        
        //라디오버튼 추가
        ButtonGroup bg=new ButtonGroup();

        //1.전체사원 2.여자 3.남자 4.개발부 5.홍보부 6.교육부 
        String [] rb_label={"전체", "여자", "남자", "개발부", "홍보부", "교육부"};
        
        xpos=10;
        
        for(int i=0;i<rb.length;i++) {
            //라디오버튼 생성
            rb[i]=new JRadioButton(rb_label[i], i==0?true:false);
            rb[i].setBounds(xpos, 50, 90, 30);
            rb[i].setOpaque(false);

            //이벤트 추가
            rb[i].addItemListener(this);
            bg.add(rb[i]);
            this.add(rb[i]);
            xpos+=100;
        }
    }
    //db조회해서 테이블에 추가하기
    //1.전체사원 2.여자 3.남자 4.개발부 5.홍보부 6.교육부 
    public void sawonTableWrite(int select) {
        String sql="";
        if(select==1)
            sql="select ROWNUM no,num id,name,buseo,gender,to_char(pay,'L999,999,999') pay from sawon";
        else if(select==2)
        	sql="select ROWNUM no,num id,name,buseo,gender,to_char(pay,'L999,999,999') pay from sawon where gender='여자'";
        else if(select==3)
        	sql="select ROWNUM no,num id,name,buseo,gender,to_char(pay,'L999,999,999') pay from sawon where gender='남자'";
        else if(select==4)
        	sql="select ROWNUM no,num id,name,buseo,gender,to_char(pay,'L999,999,999') pay from sawon where buseo='개발부'";
        else if(select==5)
        	sql="select ROWNUM no,num id,name,buseo,gender,to_char(pay,'L999,999,999') pay from sawon where buseo='홍보부'";
        else if(select==6)
        	sql="select ROWNUM no,num id,name,buseo,gender,to_char(pay,'L999,999,999') pay from sawon where buseo='교육부'";

        Connection conn=db.getOracle();
        Statement stmt=null;
        ResultSet rs=null;

        try {
            stmt=conn.createStatement();
            rs=stmt.executeQuery(sql);

            //기존의 데이터 삭제후 가져오기
            model.setRowCount(0);
            while(rs.next()) {
                //테이블에 추가할 벡터 선언후 데이터 추가
                Vector<String> data=new Vector<String>();

                data.add(rs.getString("no"));
                data.add(rs.getString("id"));
                data.add(rs.getString("name"));
                data.add(rs.getString("buseo"));
                data.add(rs.getString("gender"));
                data.add(rs.getString("pay"));

                //벡터를 데이터 행으로 추가
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
    		//행번호 얻기...선택안할시 -1
    		int row = table.getSelectedRow();
    		System.out.println(row);
    		
    		if(row==-1) {
    			JOptionPane.showMessageDialog(this, "삭제할 행을 선택해주세여");
    			return;
    		}
    		
    		//선택한 행의 id(num)값 얻기
    		String num=(String)model.getValueAt(row, 1);
    		
    		//num에 해당하는 db데이터 삭제...테이블 다시 출력
    		sql="delete from sawon where num=?";
    		
    		try {
				pstmt=conn.prepareStatement(sql);
				
				pstmt.setString(1, num);
				
				pstmt.execute();
				
				//데이터 다시불러오기
				this.sawonTableWrite(1);
				
				JOptionPane.showMessageDialog(this, "선택한 행의 데이터가 삭제되었습니다!!");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally {
				db.dbClose(pstmt, conn);
			}
    	}else if(ob==btnIns) {
    		//이름,성별,부서,급여
    		String name=JOptionPane.showInputDialog("학생명을 입력해주세요");
    		String gender=JOptionPane.showInputDialog("성별을 입력해주세요");
    		String buseo=JOptionPane.showInputDialog("부서를 입력해주세요");
    		int pay=Integer.parseInt(JOptionPane.showInputDialog("월급여를 입력해주세요"));
    		
    		sql="insert into sawon values(seq_sawon.nextval, '"+name+"', '"+gender+"', '"+buseo+"', "+pay+")";
    		
    		try {
				stmt=conn.createStatement();
				stmt.execute(sql);
				
				this.sawonTableWrite(1);
				
				JOptionPane.showMessageDialog(this, "입력한 데이터가 추가되었습니다!!");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally {
				db.dbClose(stmt, conn);
			}
    	}
	}
    public static void main(String[] args) {
        new SawonDbSwing("사원조회테이블");
    }
	

}
