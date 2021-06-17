package TestS;
import java.awt.*;
import dao.StuDao;
import dao.AdminDao;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class StuSearch extends JFrame implements ActionListener{
	Scanner input=new Scanner(System.in);
	private JLabel lblTitle=new JLabel("学生成绩查询");
	private JLabel lblEnter=new JLabel("请输入你的学号：");
	private JTextField txtStuNum=new JTextField();
	private JButton btnSearch=new JButton("查询");
	private JButton btnClose=new JButton("关闭窗口");
	private StuDao studao=new StuDao();
	public StuSearch() {
		JPanel jp=(JPanel)this.getContentPane();//获取当前JFrame的内容面板
	    jp.setLayout(new BorderLayout(3,5));//设置布局
	    JPanel jp1=new JPanel();
	    JPanel jp2=new JPanel();
	    jp1.setLayout(new GridLayout(2,1));
	    jp1.add(lblTitle);jp1.add(lblEnter);
	    jp.add(jp1,BorderLayout.NORTH);
	    jp.add(txtStuNum,BorderLayout.CENTER);
	    jp2.setLayout(new GridLayout(1,2));
	  
	   jp2.add(btnSearch);jp2.add(btnClose);
	    jp.add(jp2,BorderLayout.SOUTH);
	    this.setTitle("学生成绩查询");
	    this.setSize(700,150);
	    this.setVisible(true);
	    btnSearch.addActionListener(this);
	    btnClose.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnSearch) {
			btnSearch_Clicked();
			}
		
		else if(e.getSource()==btnClose) {
			if(JOptionPane.showConfirmDialog(this, "确认关闭窗口吗？",
                    "关闭窗口",JOptionPane.OK_CANCEL_OPTION)
					==JOptionPane.OK_OPTION) {
				this.dispose();
			}
		}
	}
	private void btnSearch_Clicked() {
		// TODO Auto-generated method stub
		String input_id=txtStuNum.getText();
		if(studao.ReturnScore(input_id)!=null) {
			JOptionPane.showMessageDialog(this,"学生"+input_id+",您的成绩是："+studao.ReturnScore(input_id));
		}
		else if(studao.ReturnScore(input_id)==null){
			JOptionPane.showMessageDialog(this, "输入栏为空或您还没有考试");
		}
	}
	
	public static void main(String[] args) {
		new StuSearch();
	}
	
}
	
	

