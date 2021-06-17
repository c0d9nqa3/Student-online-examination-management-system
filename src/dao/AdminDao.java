package dao;

import java.sql.ResultSet;

import dbutil.SQLHelper;

public class AdminDao {
	public boolean judgeLogin(String id,String pwd) {
		boolean flag=false;
		String sql="select Password from Admin where LoginID='"+id+"'";
		ResultSet rs=SQLHelper.executeQuery(sql);
		try {
			if(rs!=null && rs.next()) {
				String dbpwd=rs.getString(1);
				if(dbpwd.equals(pwd)) {
					flag=true;
				}
					
			}
			SQLHelper.closeConnection();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return flag;
	}
	
	public void uploadSql(int QuestionID,String Question,String Answer,String OptionA,String OptionB,String OptionC,String OptionD) {
		String sql="update Question set Question='"+Question+"',Answer='"+Answer+"',OptionA='"+OptionA+"',OptionB='"+OptionB+",OptionC='"
	+OptionC+"',OptionD='"+OptionD+"'where QustionID="+QuestionID;
		try {
			SQLHelper.executeUpdate(sql);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public String[][] DownloadStudentTable()throws Exception{
		String[][] rows=new String[11][4];
		int count=0;
		String sql="select * from Student";
		ResultSet rs=SQLHelper.executeQuery(sql);
		while(rs.next()) {
			int Studentid=rs.getInt(1);
			String Password=rs.getString(2);
			String Score=rs.getString(3);
			String Name=rs.getString(4);
			
			rows[count][0]=Studentid+"";
			rows[count][1]=Password;
			rows[count][2]=Name;
			rows[count][3]=Score;
			//rows[count][4]=optionC;
	
			count++;	
		}
		return rows;
	}
	
	public void updateQuestion(int
			QuestionID,String Question,String Answer,String OptionA,String OptionB,String OptionC,String OptionD) {
		String sql="update Question set Question='"+Question+"',Answer='"+Answer+"',OptionA='"+OptionA+"',OptionB='"+OptionB+"',OptionC='"
				+OptionC+"',OptionD='"+OptionD+"'where QuestionID='"+QuestionID+"'";
		try {
			SQLHelper.executeUpdate(sql);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
}
