package bo;

/**
 * @author jonatankelati & gergotarchech
 */

import java.sql.SQLException;

import db.CartDB;
import ui.CartInfo;

public class CartHandler {

	private Cart cart;
	private static CartDB cartDB;
	
	/**
	 * Insert a item to the cart or update the Carts when some changes is occured
	 * @param itemId
	 * @param newCount
	 * @param userId
	 * @param cartId
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void updateCart(int itemId, int newCount, int userId, int cartId) throws ClassNotFoundException, SQLException {
		cartDB= new CartDB();
		cartDB.updateCart(itemId,newCount,userId, cartId);
	}

	/**
	 * Gets the cart that belongs to the user who is logging in
	 * @param userId
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public int loginCart(int userId) throws ClassNotFoundException, SQLException {
		cartDB = new CartDB();
		int cartId = cartDB.getLoginCart(userId);
		
		return cartId;
	}

	/**
	 * when showing the cart this method is called
	 * @param cartId
	 * @return
	 * @throws SQLException
	 */
	public CartInfo getCartItems(int cartId) throws SQLException {
		cartDB = new CartDB();
		cart = cartDB.getCartItems(cartId);
		CartInfo cartInfo = new CartInfo(cart);
		return cartInfo;
	}

}
