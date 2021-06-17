package TestS;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import dao.StuDao;
import java.util.*;
public class StuTest extends JFrame implements ActionListener{
	private JLabel lblTitle=new JLabel("在线考试系统");
	private StuDao studao=new StuDao();
	private JButton[] btnTestNum=new JButton[10];
	private JLabel lblName=new JLabel("姓名：");
	private JLabel lblname=new JLabel(studao.ReturnName(studao.Returnid()));
	private JLabel lblNum=new JLabel("学号：");
	private JLabel lblnum=new JLabel(studao.Returnid()+"");
	private JLabel lblTestTime=new JLabel("考试时间：");
	private JLabel lbltesttime=new JLabel("10min");
	private JLabel lbllasttime=new JLabel();
	private JTextArea Questarea = new JTextArea(10,10);
	private JRadioButton btnA=new JRadioButton("A");
	private JRadioButton btnB=new JRadioButton("B");
	private JRadioButton btnC=new JRadioButton("C");
	private JRadioButton btnD=new JRadioButton("D");
	private ButtonGroup bg=new ButtonGroup();
	private JLabel lblCurnum=new JLabel("当前是第");
	private JButton btnUp=new JButton("交卷");
	private static String[] answer=new String[10];
	public StuTest() {
		 JPanel jp=(JPanel)this.getContentPane(); 
		 jp.setLayout(new BorderLayout());//设置底层布局
		 JPanel jp1=new JPanel();
		 JPanel jp2=new JPanel();
		 JPanel jp3=new JPanel();
		 JPanel jp4=new JPanel();
		 JPanel jp5=new JPanel();
		 JPanel jp6=new JPanel();
		 for(int i=0;i<10;i++) {
			 btnTestNum[i]=new JButton(i+1+"");
		 }
		 bg.add(btnA);bg.add(btnB);bg.add(btnC);bg.add(btnD);
		 jp1.setLayout(new GridLayout(1,8));
		 jp1.add(lblName);jp1.add(lblname);
		 jp1.add(lblNum);jp1.add(lblnum);
		 jp1.add(lblTestTime);jp1.add(lbltesttime);
		jp1.add(lbllasttime);
		 jp2.add(Questarea);
		 jp3.setLayout(new GridLayout(1,4));
		 jp3.add(btnA);jp3.add(btnB);jp3.add(btnC);jp3.add(btnD);
		 jp3.add(btnUp);
		 
		 jp4.setLayout(new GridLayout(1,2));
		 jp5.add(lblCurnum);
		 jp6.setLayout(new GridLayout(2,5));
		 for(int i=0;i<10;i++) {
			 jp6.add(btnTestNum[i]);
		 }
		 jp.add(jp1,BorderLayout.NORTH);
		 jp.add(jp2,BorderLayout.CENTER);
		 jp.add(jp3,BorderLayout.SOUTH);
		 jp.add(jp5,BorderLayout.WEST);
		 jp.add(jp6,BorderLayout.EAST);
		 this.setTitle("在线考试系统！");
		 this.setSize(850,300);
		 for(int i=0;i<10;i++) {
			 btnTestNum[i].addActionListener(this);
		 }
		 btnUp.addActionListener(this);
		 this.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnUp) {

			JOptionPane.showMessageDialog(this, "交卷成功！！");
			studao.countScore(answer, studao.Returnid());
		}
		for(int i=0;i<10;i++) {
			if(e.getSource()==btnTestNum[i]) {
			//btnTestNum[0].setContentAreaFilled(false);
			
			btnTestNum[i].setBackground(Color.red);
			if(btnA.isSelected()) {
				answer[i]="A";
				
			}
			else if(btnB.isSelected()) {
				answer[i]="B";
				
			}
			else if(btnC.isSelected()) {
				answer[i]="C";
				
			}
			else if(btnD.isSelected()) {
				answer[i]="D";
				
			}
			bg.clearSelection();
			Questarea.setText("");
			Questarea.append(studao.ReturnQuestion(1+i)+"\n");
			Questarea.append(studao.ReturnOption(1+i)+"\n");
			}
		}
	}	
	
	public static void main(String[] args) {
		new StuTest();
	}
}
	

