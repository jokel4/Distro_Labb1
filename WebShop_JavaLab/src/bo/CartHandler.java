package bo;

import java.sql.SQLException;

import db.CartDB;
import ui.CartInfo;

public class CartHandler {

	private Cart cart;
	private static CartDB cartDB;
	
	public void updateCart(int itemId, int newCount, int userId, int cartId) throws ClassNotFoundException, SQLException {
		cartDB= new CartDB();
		cartDB.updateCart(itemId,newCount,userId, cartId);
	}

	public int loginCart(int userId) throws ClassNotFoundException, SQLException {
		cartDB = new CartDB();
		int cartId = cartDB.getLoginCart(userId);
		
		return cartId;
	}

	public CartInfo getCartItems(int cartId) throws SQLException {
		cartDB = new CartDB();
		cart = cartDB.getCartItems(cartId);
		CartInfo cartInfo = new CartInfo(cart);
		return cartInfo;
	}

}
