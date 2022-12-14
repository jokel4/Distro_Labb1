package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bo.Cart;
import bo.Item;
import bo.User;

/**
 * 
 * Connection to database for getting data for cart
 * 
 * @author jonatankelati & gergotarchech
 *
 */

public class CartDB {
	private static final UserDB userDb = null;
	static Connection connection = null;
	static Statement statement = null;
	static ResultSet resultSet = null;
	
	/**
	 * Returns the cartId for the specific user who is logging in
	 * @param userId
	 * @return cartId
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public int getLoginCart(int userId) throws SQLException, ClassNotFoundException {
		int cartId = 0;
		try {
			connection = DBManager.getConnection();
			statement = connection.createStatement();
			PreparedStatement statement = connection.prepareStatement("select * from cart WHERE user_id=?");
			statement.setInt(1, userId);
			resultSet = statement.executeQuery();
			if(resultSet.next()) {
				cartId = resultSet.getInt("cart_id");
				return cartId;
				
			}else {
				String INSERT_NEW_CART = "INSERT INTO cart (user_id) VALUES (?)";
				try {
					PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_CART);
					preparedStatement.setInt(1, userId);
					preparedStatement.executeUpdate();
					return getLoginCart(userId);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}finally {
			resultSet.close();
			statement.close();
			connection.close();
			
		}
		return cartId;
		
	}
	
	/**
	 * If item that is going be updated to cart already exist in cart the edit the count of item in cart. If item dont already exists in cart the insert into cart
	 * @param itemId
	 * @param newCount
	 * @param userId
	 * @param cartId
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void updateCart(int itemId, int newCount, int userId, int cartId) throws ClassNotFoundException, SQLException {
		try {
			connection = DBManager.getConnection();
			PreparedStatement statement = connection.prepareStatement("select * from cart_item WHERE item_id=?");
			statement.setInt(1, itemId);
			resultSet = statement.executeQuery();
			if(resultSet.next()) {
				System.out.println("F??RSTA");
				if(resultSet.getInt("item_id") == itemId) {
					int newValue = resultSet.getInt("item_count") + newCount;
					System.out.println("ITEEEEMM NY: "+ newValue);
					updateItemInCart(cartId,itemId, newValue);
				}
			}else {
				System.out.println("ANDRA");
				insrtIntoCart(cartId,newCount,itemId);
			}
		}catch(SQLException s) {
			s.printStackTrace();
		}
		finally {
			resultSet.close();
			connection.close();
		}
		
	}

	/**
	 * inserts item into cart
	 * @param cartId
	 * @param newCount
	 * @param itemId
	 * @throws ClassNotFoundException
	 */

	private void insrtIntoCart(int cartId, int newCount, int itemId) throws ClassNotFoundException {
		String INSERT_ITEM_IN_CART = "INSERT INTO cart_item" + "(cart_id, item_id,item_count) VALUES"+"(?,?,?)";
		
		
		try {
			connection = DBManager.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ITEM_IN_CART);
			preparedStatement.setInt(1, cartId);
			preparedStatement.setInt(2,itemId);
			preparedStatement.setInt(3,newCount);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	/**
	 * updates item in cart
	 * @param cartId
	 * @param itemId
	 * @param newValue
	 * @throws ClassNotFoundException
	 */

	private void updateItemInCart(int cartId,int itemId, int newValue) throws ClassNotFoundException {
		String INSERT_NEW_COUNT_ITEM_CART = "UPDATE cart_item SET item_count=? WHERE cart_id=? AND item_id=?";
		
	
		try {
			connection = DBManager.getConnection();
			PreparedStatement statement = connection.prepareStatement(INSERT_NEW_COUNT_ITEM_CART);
			statement.setInt(1,newValue);
			statement.setInt(2,cartId);
			statement.setInt(3,itemId);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Return a cart that is filled with items
	 * @param cartId
	 * @return
	 * @throws SQLException
	 */

	public Cart getCartItems(int cartId) throws SQLException {
		Cart cart = new Cart();
		ItemDB itemDB = new ItemDB();
		int count = 0;
		try {
			connection = DBManager.getConnection();
			PreparedStatement statement = connection.prepareStatement("select * from cart_item WHERE cart_id=?");
			statement.setInt(1, cartId);
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				cart.addItemToList(itemDB.getItem(resultSet.getInt("item_id")));
				cart.getItem(count).setCount(resultSet.getInt("item_count"));
				count++;	
			}	
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			resultSet.close();
			connection.close();
		}
		
		return cart;
	}
	
}
