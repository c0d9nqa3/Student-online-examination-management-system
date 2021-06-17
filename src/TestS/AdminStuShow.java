package TestS;
import java.awt.*;
import dao.AdminDao;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class AdminStuShow extends JFrame implements ActionListener{
	private JLabel lblTitle=new JLabel("考生信息");
	private JLabel lblEnter=new JLabel("学生信息");
	private JButton btnClose=new JButton("关闭窗口");
	private JTable table=null;
	private AdminDao admindao=new AdminDao();
	public AdminStuShow() throws Exception {
		JPanel jp=(JPanel)this.getContentPane();//获取当前JFrame的内容面板
		//JPanel jp2=(JPanel)this.getContentPane();
		jp.setLayout(new BorderLayout(3,5));//设置布局
		JPanel jp1=new JPanel();
		JPanel jp2=new JPanel();
		jp1.setLayout(new GridLayout(2,1));
		jp1.add(lblTitle);jp1.add(lblEnter);
		jp.add(jp1,BorderLayout.NORTH);
		initTable();
		JScrollPane jspTable=new JScrollPane(table);
		jp.add(jspTable,BorderLayout.CENTER);
		jp2.setLayout(new GridLayout(1,3));	
		jp2.add(btnClose);
		jp.add(jp2,BorderLayout.SOUTH);
		this.setTitle("学生信息管理");
		this.setSize(800, 500);
		this.setVisible(true);
		btnClose.addActionListener(this);
}
	private  void initTable() throws Exception {
		String[] cols= {"StudentId","LoginPwd","StudentName","Score"};
		String[][] rows=admindao.DownloadStudentTable();
		table=new JTable(rows,cols);
	}
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==btnClose) {
			if(JOptionPane.showConfirmDialog(this, "确认关闭窗口吗？",
                    "关闭窗口",JOptionPane.OK_CANCEL_OPTION)
					==JOptionPane.OK_OPTION) {
				this.dispose();	
		}
	}
	
}
	public static void main(String[] args) throws Exception {
		new AdminStuShow();
	}
}
	
	

