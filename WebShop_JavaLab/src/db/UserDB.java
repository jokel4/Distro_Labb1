package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bo.User;

public class UserDB {
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	
	
	public User getUser(int userId) throws SQLException, ClassNotFoundException {
		User user = new User();
		try {
			connection = DBManager.getConnection();
			PreparedStatement statement = connection.prepareStatement("select * from user WHERE user_id=?");
			statement.setInt(1,userId);
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				user.setUserID(resultSet.getInt("user_id"));
				user.setUserName(resultSet.getString("user_name"));
				user.setUserPassword(resultSet.getString("user_password"));
				
			}
		}catch(SQLException s) {
			s.printStackTrace();
		}
		finally {
			resultSet.close();
			statement.close();
			connection.close();
		}
		
		return user;
	}
	
	public ArrayList<User> getUsers() throws SQLException, ClassNotFoundException {
		User user;
		ArrayList<User> users = new ArrayList<>();
		try {
			
			connection = DBManager.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from user");
			
			while(resultSet.next()) {
				int userId = resultSet.getInt("user_id");
				String username = resultSet.getString("user_name");
				String userPassword = resultSet.getString("user_password");
				user = new User(userId,username, userPassword); 
				users.add(user);
			}
		}catch(SQLException s) {
			s.printStackTrace();
		}
		finally {
			resultSet.close();
			statement.close();
			connection.close();
		}
		
		return users;
	}
	
	public void setUser(User user) throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String INSERT_USERS_SQL = "INSERT INTO user" + "(user_name, user_password) VALUES"+"(?,?)";
		try {
			connection = DBManager.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setString(2, user.getUserPassword());
			preparedStatement.executeUpdate();
		}catch(SQLException s) {
			s.printStackTrace();

		}
	}
}
