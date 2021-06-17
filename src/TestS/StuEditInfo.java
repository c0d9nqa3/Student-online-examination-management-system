package TestS;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import dao.StuDao;
import java.util.*;
import dbutil.SQLHelper;
public class StuEditInfo extends JFrame implements ActionListener {
private JLabel lblId=new JLabel("输入原密码：");
	 private JPasswordField txtOldPwd=new JPasswordField();
	 private JLabel lblPwd=new JLabel("输入新密码：");
	 private JPasswordField txtNewPwd=new JPasswordField();
	 private JButton btnOk=new JButton("确认");
	 private JButton btnCancel=new JButton("关闭");	 
	 private StuDao studao=new StuDao();
	  public StuEditInfo() {    
	    //设置布局,网格布局 3 X 2
	    JPanel jp=(JPanel)this.getContentPane();//获取当前JFrame的内容面板
	    jp.setLayout(new GridLayout(4,3));//设置布局
	    jp.add(lblId);jp.add(txtOldPwd);
	    jp.add(lblPwd);jp.add(txtNewPwd);	    
	    //jp.add(lblIdOption);jp.add(IdOption);
	    jp.add(btnOk);jp.add(btnCancel);
	    this.setTitle("修改密码！");
	    this.setSize(400, 300);
	    this.setVisible(true);
	    btnOk.addActionListener(this);
	    btnCancel.addActionListener(this);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnOk) {
			try {
				btnOK_Clicked();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==btnCancel) {
			if(JOptionPane.showConfirmDialog(this, "确认关闭当前窗口吗？",
                    "关闭窗口",JOptionPane.OK_CANCEL_OPTION)
					==JOptionPane.OK_OPTION) {
				this.dispose();
			}
		}
	}
	public void btnOK_Clicked() throws SQLException {
		String oldp=txtOldPwd.getText();
		String newp=txtNewPwd.getText();
		String sql="select * from Temp";
		String sid = null;
		ResultSet rs=SQLHelper.executeQuery(sql);
		if(rs!=null && rs.next()) {
			sid=rs.getString(1);
		}
		if(studao.EditStuInfo(oldp, sid, newp)) {
	    	JOptionPane.showMessageDialog(this, "修改成功！");

		}
		else {
	    	JOptionPane.showMessageDialog(this, "原密码与输入密码不一致！");

		}	
	}  
}


