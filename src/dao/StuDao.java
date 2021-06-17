package dao;
import java.sql.*;
import dbutil.SQLHelper;
import entity.Student;
public class StuDao {
	public boolean judgeLogin(String id,String pwd) {
		boolean flag=false;
		String sql="select Password from Student where StudentID='"+id+"'";
		String sql1="update Temp set tempID='"+id+"'";
		ResultSet rs=SQLHelper.executeQuery(sql);
		try {
			if(rs!=null && rs.next()) {
				String dbpwd=rs.getString(1);
				if(dbpwd.equals(pwd)) {
					flag=true;
					SQLHelper.executeUpdate(sql1);
				}
					
			}
			SQLHelper.closeConnection();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return flag;
	}
	
	//修改学生个人信息的函数
	public boolean EditStuInfo(String UsedPwd,String id,String NewPwd) {
		boolean flag=false;
		String sql="select Password from Student where StudentID='"+id+"'";
		ResultSet rs=SQLHelper.executeQuery(sql);
		try {
			if(rs!=null && rs.next()) {
				String dbpwd=rs.getString(1);
				if(dbpwd.equals(UsedPwd)) {
					String sql1="update Student set Password='"+NewPwd+"'"+" where StudenrID="+id;
					if(SQLHelper.executeQuery(sql) != null) {
						flag=true;
					}
				}
				else {
					flag=false;
				}
					
			}
			SQLHelper.closeConnection();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return flag;
	}
	
	
	
	//学生成绩查询的函数
	public String ReturnScore(String input_id) {
		//String sql="select tempid from temp";
		String sql1="select score from student where studentid="+input_id;
		String score = null;
		//ResultSet rs=SQLHelper.executeQuery(sql);
		ResultSet rs1=SQLHelper.executeQuery(sql1);
		try {
			//if(rs!=null && rs.next()) {
				//String temp_id=rs.getString(1);
				//if(temp_id.equals(input_id)){
					if(rs1!=null&& rs1.next())
						score=rs1.getString(1);
				//}
			//}
			else {
				return null;
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return score;
	}
	
	//根据题目序号返回题目文字
	public String ReturnQuestion(int question_id) {
		String sql="select Question from Question where QuestionID="+question_id;
		ResultSet rs=SQLHelper.executeQuery(sql);
		String question = null;
		try {
			if(rs!=null && rs.next()) {
				question=rs.getString(1);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return question;
		
	}
	
	//根据题目序号返回选项文字
	public String ReturnOption(int question_id) {
		String sqlA="select OptionA from Question where QuestionID="+question_id;
		String sqlB="select OptionB from Question where QuestionID="+question_id;
		String sqlC="select OptionC from Question where QuestionID="+question_id;
		String sqlD="select OptionD from Question where QuestionID="+question_id;
		ResultSet rsA=SQLHelper.executeQuery(sqlA);
		ResultSet rsB=SQLHelper.executeQuery(sqlB);
		ResultSet rsC=SQLHelper.executeQuery(sqlC);
		ResultSet rsD=SQLHelper.executeQuery(sqlD);
		String OptionA = null;
		String OptionB = null;
		String OptionC = null;
		String OptionD = null;
		
		try {
			if(rsA!=null && rsA.next() && rsB!=null && rsB.next() &&rsC!=null && rsC.next() && rsD!=null && rsD.next()) {
				OptionA=rsA.getString(1);
			
				OptionB=rsB.getString(1);
			
				OptionC=rsC.getString(1);
			
				OptionD=rsD.getString(1);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return "A."+OptionA+"  "+"B."+OptionB+"  "+"C."+OptionC+"  "+"D."+OptionD;
		
	}
	
	//考试界面开始时显示考生姓名
	public String ReturnName(int id) {
		String sql1="select name from Student where StudentID="+id;
		ResultSet rs=SQLHelper.executeQuery(sql1);
		String name = null;
		try {
			if(rs!=null && rs.next()) {
				name=rs.getString(1);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
		return name;
		
	}
	
	
	public int Returnid() {
		String sql="select tempid from temp";
		int id = 0;
		ResultSet rs=SQLHelper.executeQuery(sql);
		try {
			if(rs!=null && rs.next()) {
				id=rs.getInt(1);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return id;
	}
	
	
	
	//从数据库中读取题号与答案
	public String load(int qid) {
		String sql="select answer from Question where questionid="+qid;
		ResultSet rs=SQLHelper.executeQuery(sql);
		String answer=null;
		try {
			if(rs!=null && rs.next()) {
				answer=rs.getString(1);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return answer;
		
	}
	
	
	//计算出学生成绩并且update数据库表中的Score一栏
	public void countScore(String a[],int id) {
		int count=0,i=1;
		String[] b=new String[10];   //答案表中的数据
		for(int j=0;j<10;j++) {
			b[j]=load(j+1);
		}
		for(;i<10;i++) {
			if(b[i].equals(a[i])) {
				count++;
			}
		}
		
		String sql1="update Student set score="+count+" where StudentID="+id;
		SQLHelper.executeUpdate(sql1);
	}
	 
	
}
