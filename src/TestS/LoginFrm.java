package TestS;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;
import dao.AdminDao;
import dao.StuDao;
import java.util.*;
public class LoginFrm extends JFrame implements ActionListener{
	 private JLabel lblId=new JLabel("用户名：");
	 private JTextField txtId=new JTextField("");
	 private JLabel lblPwd=new JLabel("密码：");
	 private JPasswordField txtPwd=new JPasswordField();
	 private JLabel lblIdOption=new JLabel("登陆身份选择");
	 private JButton btnOk=new JButton("确认");
	 private JButton btnCancel=new JButton("关闭");	 
	 private JComboBox IdOption=new JComboBox(new String[] {"学生","管理员"});
	 private StuDao studao=new StuDao();
	 private AdminDao admindao=new AdminDao();
	  public LoginFrm() {    
	    //设置布局,网格布局 3 X 2
	    JPanel jp=(JPanel)this.getContentPane();//获取当前JFrame的内容面板
	    jp.setLayout(new GridLayout(4,3));//设置布局
	    jp.add(lblId);jp.add(txtId);
	    jp.add(lblPwd);jp.add(txtPwd);	    
	    jp.add(lblIdOption);jp.add(IdOption);
	    jp.add(btnOk);jp.add(btnCancel);
	    this.setTitle("用户登录");
	    this.setSize(400, 300);
	    this.setVisible(true);
	    btnOk.addActionListener(this);
	    btnCancel.addActionListener(this);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  }
	  @Override
	  public void actionPerformed(ActionEvent e) {
	    if(e.getSource()==btnOk) {
	        btnOK_Clicked();
	    }
	    else if(e.getSource()==btnCancel) {
	      if(JOptionPane.showConfirmDialog(this, "确认关闭当前窗口吗？",
	                                    "关闭窗口",JOptionPane.OK_CANCEL_OPTION)
	          ==JOptionPane.OK_OPTION) {
	        this.dispose();
	      }
	    }
	  }
	  private void btnOK_Clicked() {
		Object selectId=IdOption.getSelectedItem();
		String stuId=txtId.getText();
	    String stuPwd=txtPwd.getText();
	    String adminId=txtId.getText();
	    String adminPwd=txtPwd.getText();
	    if("学生".equals(selectId)&&studao.judgeLogin(stuId, stuPwd)) {
	      JOptionPane.showMessageDialog(this, "欢迎您，学生"+stuId+"登陆!");
	      setVisible(false);
	      new StuPage1().setVisible(true);;
	    }
	    else if("管理员".equals(selectId)&&admindao.judgeLogin(adminId, adminPwd)) {
	    	JOptionPane.showMessageDialog(this, "欢迎您，管理员登陆!");
		      setVisible(false);
		      new Admin().setVisible(true);;
	    }
	    else {
	    	JOptionPane.showMessageDialog(this, "用户名或密码错误！");
	    }
	  }
	  public static void main(String[] args)throws Exception {
		  new LoginFrm();
	  }
}
