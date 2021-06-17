package TestS;

import java.awt.*;
import dbutil.SQLHelper;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.sql.*;
import dao.AdminDao;

public class AdminTestShow extends JFrame implements ActionListener {
	Scanner input = new Scanner(System.in);
	private JLabel lblTitle = new JLabel("试题显示");
	private JLabel lblEnter = new JLabel("试题信息：");
	private JButton btnClose = new JButton("关闭窗口");
	private JTable table = null;
	private AdminDao admindao = new AdminDao();
	private void initTable() throws Exception {
		String[] cols = { "QuestionId", "Question", "OptionA", "OptionB", "OptionC", "OptionD", "Answer" };
		String[][] rows = DownloadTable();
		table = new JTable(rows, cols);
	}

	public AdminTestShow() throws Exception {
		JPanel jp = (JPanel) this.getContentPane();// 获取当前JFrame的内容面板
		jp.setLayout(new BorderLayout(3, 5));// 设置布局
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		jp1.setLayout(new GridLayout(2, 1));
		jp1.add(lblTitle);
		jp1.add(lblEnter);
		jp.add(jp1, BorderLayout.NORTH);
		initTable();
		JScrollPane jspTable = new JScrollPane(table);
		jp.add(jspTable, BorderLayout.CENTER);
		jp2.setLayout(new GridLayout(1, 3));
		jp2.add(btnClose);
		jp.add(jp2, BorderLayout.SOUTH);
		this.setTitle("试题维护");
		this.setSize(800, 500);
		this.setVisible(true);
		btnClose.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnClose) {
			if (JOptionPane.showConfirmDialog(this, "确认关闭窗口吗？", "关闭窗口",
					JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
				this.dispose();
			}

		}
	}
	public String[][] DownloadTable()throws Exception{
		String[][] rows=new String[10][7];
		int count=0;
		String sql="select * from Question";
		ResultSet rs=SQLHelper.executeQuery(sql);
		while(rs.next()) {
			int id=rs.getInt(1);
			String question=rs.getString(2);
			String optionA=rs.getString(3);
			String optionB=rs.getString(4);
			String optionC=rs.getString(5);
			String optionD=rs.getString(6);
			String answer=rs.getString(7);
			rows[count][0]=id+"";
			rows[count][1]=question;
			rows[count][2]=optionA;
			rows[count][3]=optionB;
			rows[count][4]=optionC;
			rows[count][5]=optionD;
			rows[count][6]=answer;
			count++;	
		}
		return rows;
	}
	public static void main(String[] args) throws Exception {
		new AdminTestShow();
	}
	
}
	
	

