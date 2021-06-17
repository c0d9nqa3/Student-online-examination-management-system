package TestS;
import java.awt.*;
import dao.StuDao;
import dao.AdminDao;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class AdminTestEdit extends JFrame implements ActionListener{
	private JLabel lblTitle=new JLabel("考试试卷修改");
	private JLabel lblID=new JLabel("输入题目题号：");
	private JLabel lblQuestion=new JLabel("输入题目：");
	private JLabel lblOptionA=new JLabel("选项A：");
	private JLabel lblOptionB=new JLabel("选项B：");
	private JLabel lblOptionC=new JLabel("选项C：");
	private JLabel lblOptionD=new JLabel("选项D：");
	private JLabel lblAnswer=new JLabel("答案:");
	private JTextField ID=new JTextField();
	private JTextField Question=new JTextField();
	private JTextField OptionA=new JTextField();
	private JTextField OptionB=new JTextField();
	private JTextField OptionC=new JTextField();
	private JTextField OptionD=new JTextField();	
	private JTextField Answer=new JTextField();
	private JButton btnSave=new JButton("保存");
	private AdminDao admindao=new AdminDao();
	public AdminTestEdit() {
		JPanel jp=(JPanel)this.getContentPane();
		jp.setLayout(new BorderLayout(4,5));
		JPanel jp1=new JPanel();
		JPanel jp2=new JPanel();
		jp1.setLayout(new GridLayout(1,1));
		jp1.add(lblTitle);
		jp2.setLayout(new GridLayout(7,2));
		jp2.add(lblID);jp2.add(ID);
		jp2.add(lblQuestion);jp2.add(Question);
		jp2.add(lblOptionA);jp2.add(OptionA);
		jp2.add(lblOptionB);jp2.add(OptionB);
		jp2.add(lblOptionC);
		jp2.add(OptionC);
		jp2.add(lblOptionD);jp2.add(OptionD);
		jp2.add(lblAnswer);jp2.add(Answer);
		jp.add(jp1,BorderLayout.NORTH);
		jp.add(jp2,BorderLayout.CENTER);
		jp.add(btnSave,BorderLayout.SOUTH);
		this.setTitle("题目管理系统");
	    this.setSize(700,550);
	    this.setVisible(true);
		btnSave.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnSave) {
			btnSave_Clicked();
		}
	}
	public void btnSave_Clicked() {
		String temp=ID.getText();
		int in_id=Integer.parseInt(temp);   //将String的id值转换为int型的
		String Quest=Question.getText();
		String A=OptionA.getText();
		String B=OptionB.getText();
		String C=OptionC.getText();
		String D=OptionD.getText();
		String An=Answer.getText();
		if(Quest==null || A==null||B==null||C==null||D==null||temp.equals(null) ) {
			JOptionPane.showMessageDialog(this, "有输入栏为空！请输入");
		}
		else {
		admindao.updateQuestion(in_id, Quest, An, A, B, C, D);
		JOptionPane.showMessageDialog(this, "修改成功");
		
		}
	}
	public static void main(String args[]) {
		new AdminTestEdit();
	}
}
