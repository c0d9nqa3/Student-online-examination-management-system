package TestS;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class StuPage1 extends JFrame implements ActionListener {
	Scanner input=new Scanner(System.in);
	private JRadioButton OpEdit=new JRadioButton("修改个人信息");
	private JRadioButton OpEnter=new JRadioButton("进入考试系统");
	private JRadioButton OpSearch=new JRadioButton("学生成绩查询");
	private JButton btnOk=new JButton("确认");
	ButtonGroup button=new ButtonGroup();
	public StuPage1() {
		JPanel jp1=(JPanel)this.getContentPane();//获取当前JFrame的内容面板
	    jp1.setLayout(new GridLayout(4,1));//设置布局
	    jp1.add(OpEdit);
	    jp1.add(OpSearch);jp1.add(OpEnter);
	    jp1.add(btnOk);
	    button.add(OpEdit);button.add(OpEnter);button.add(OpSearch);
	    this.setTitle("选择");
	    this.setSize(400, 300);
	    this.setVisible(true);
	    btnOk.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==btnOk) {
			if(OpEdit.isSelected()) {
				new StuEditInfo();	
			}
			else if(OpEnter.isSelected()) {
				new StuTest();
				this.setVisible(false);
			}
			else if(OpSearch.isSelected()) {
				new StuSearch();
			}
			
		}
	}
}
