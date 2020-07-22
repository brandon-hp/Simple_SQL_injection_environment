package bean;


public class Useritem {
	private int user_id;
	private  String username;
	private String password="1";
	private String realname;
	private String major;
	public int getUserID() {
		return user_id;
	}
	public void setUserID(int id) {
		this.user_id=id;
	}
	public String getUserName()
	{
		return username;
	}
	public void setUserName(String name)
	{
		this.username=name;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String pd)
	{
		this.password=pd;
	}
	public String getRealname()
	{
		return realname;
	}
	public void setRealname(String name)
	{
		this.realname=name;
	}
	public String getMajor()
	{
		return major;
	}
	public void setMajor(String mj)
	{
		this.major=mj;
	}
}

