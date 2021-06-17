package TestS;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.*;
public class Admin extends JFrame implements ActionListener{
	
		 private JLabel lblTitle=new JLabel("管理员登陆：");
		 private JLabel lblOption=new JLabel("选项：");
		 private JButton btnTestShow=new JButton("试题查看");
		 private JButton btnStuInfo=new JButton("考生信息查看");
		 private JButton btnTestEdit=new JButton("试题修改");	 
		 private JButton btnQuit=new JButton("返回");
		  public Admin() { 
		    JPanel jp=(JPanel)this.getContentPane();//获取当前JFrame的内容面板
		    jp.setLayout(new GridLayout(6,4));//设置布局
		    jp.add(lblTitle);jp.add(lblOption);
		    jp.add(btnTestShow);jp.add(btnStuInfo);	
		    jp.add(btnTestEdit);
		    jp.add(btnQuit);
		    this.setTitle("管理员");
		    this.setSize(400,300);
		    this.setVisible(true);
		    btnTestShow.addActionListener(this);
		    btnTestEdit.addActionListener(this);
		    btnQuit.addActionListener(this);
		    //btnSearch.addActionListener(this);
		    btnStuInfo.addActionListener(this);
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  }
		  @Override
		  public void actionPerformed(ActionEvent e) {
		    if(e.getSource()==btnTestShow) {
		        try {
					new AdminTestShow();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    }
		    else if(e.getSource()==btnQuit) {
		      if(JOptionPane.showConfirmDialog(this, "确认返回前一窗口吗？",
		                                    "关闭窗口",JOptionPane.OK_CANCEL_OPTION)
		          ==JOptionPane.OK_OPTION) {
		        this.dispose();
		        new LoginFrm();
		      }
		    }
		    else if(e.getSource()==btnTestEdit) {
		    	try {
					new AdminTestEdit();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    }
		    else if(e.getSource()==btnStuInfo) {
		    	try {
					new AdminStuShow();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    }
		    
		  }
		  public static void main(String[] args) {
			  new Admin();
		  }
		  
		
		
		
}
