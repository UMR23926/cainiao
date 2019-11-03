package com.example.project;//用户信息

public class UserData{
	private String userId;
	private String userName;
	private String userPassword;
	private int userState;
	public String getUserName(){
		return userName;
	}
	public void setUserName(String userName){
		this.userName=userName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public int getUserState() {
		return userState;
	}
	public void setUserState(int userState) {
		this.userState = userState;
	}
	
	public UserData(String userId,String userName,String userPassword,int userstate){
		super();
		this.userName=userName;
		this.userId=userId;
		this.userPassword=userPassword;
		this.userState = userState;
	}
}
