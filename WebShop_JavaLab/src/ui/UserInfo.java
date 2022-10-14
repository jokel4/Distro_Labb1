package ui;

import java.sql.SQLException;

import db.UserDB;

public class UserInfo {

	private int userID;
	private String userName;
	private String userPassword;
	
	
	public UserInfo(int userID, String userName, String userPassword) {
		this.userID = userID;
		this.userName = userName;
		this.userPassword = userPassword;
	}
	
	public UserInfo() {}
	public UserInfo(String userName, String userPassword) {
		this.userName = userName;
		this.userPassword = userPassword;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	
	
}
