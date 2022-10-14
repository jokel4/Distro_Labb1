package bo;

import java.sql.SQLException;
import java.util.ArrayList;

import db.UserDB;
import ui.UserInfo;

public class UserHandler {

	private User user;
	private UserDB userDB ;
	public void registerUser(UserInfo userInfo) throws ClassNotFoundException, SQLException {
		user = new User(userInfo.getUserName(),userInfo.getUserPassword());
		userDB = new UserDB();
		userDB.setUser(user);
	}
	
	/**
	 * gets a list of user from db.
	 * the users i checked and if username and password of the one that has been given from input is the same as one of the exsisting users in db. If so then the give users
	 * id is returnd
	 * @param userInfo
	 * @return 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public int loginUser(UserInfo userInfo) throws ClassNotFoundException, SQLException {
		userDB = new UserDB();
		String userName = userInfo.getUserName();
		String userPassword = userInfo.getUserPassword();
		ArrayList<User> collection = userDB.getUsers();
		
		for(User usr : collection) {
			if(userName.equals(usr.getUserName()) && userPassword.equals(usr.getUserPassword())) {
				return usr.getUserID();
			}
		}
		return 0;
	}
	

	
	
}
