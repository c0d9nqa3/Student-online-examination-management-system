package entity;

public class Student {
	private String id,pwd;
	public Student() {
		
	}
	public  Student(String id,String pwd) {
		super();
		this.id=id;
		this.pwd=pwd;
		
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id=id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd=pwd;
	}
	
}
