package ui;

import java.util.ArrayList;
import java.util.Collections;

import bo.Cart;
import bo.Item;
import bo.User;

public class CartInfo {
	private int cartId;
	private User user;
	private int cartCount;
	private ArrayList<Item> itemList;
	
	public CartInfo(int cartId, User user, int cartCount, Item item) {
		this.cartId = cartId;
		this.user = new User(user.getUserID(),user.getUserName(),user.getUserPassword());
		this.cartCount = cartCount;
		this.itemList = new ArrayList<Item>(); 
	}
	
	public CartInfo(Cart cart) {
		this.cartId = cart.getCartId();
		this.cartCount = cart.getCartCount();
		this.itemList = new ArrayList<Item>();
		this.itemList = cart.getItemList();
	}
	public CartInfo() {
		this.cartId = 0;
		this.cartCount = 0;
		this.itemList = new ArrayList<Item>(10);
		
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getCartCount() {
		return cartCount;
	}

	public void setCartCount(int cartCount) {
		this.cartCount = cartCount;
	}

	public ArrayList<Item> getItemList() {
		return itemList;
	}

	public void setItemList(ArrayList<Item> itemList) {
		this.itemList = itemList;
	}
	
	
}
