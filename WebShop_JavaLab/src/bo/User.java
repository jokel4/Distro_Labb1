package bo;

import java.sql.SQLException;

import db.UserDB;
/**
 * Represent a User in the system. This is a representations of the User tabel that exist in DB.
 * 
 * @author jonatanKelati & gergoTarchech
 *
 */
public class User {

	private int userID;
	private String userName;
	private String userPassword;
	
	
	public User(int userID, String userName, String userPassword) {
		this.userID = userID;
		this.userName = userName;
		this.userPassword = userPassword;
	}
	
	public User() {}
	public User(String userName, String userPassword) {
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
