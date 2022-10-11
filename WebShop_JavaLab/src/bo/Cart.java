package bo;

import java.util.ArrayList;

public class Cart {
	private int cartId;
	private int cartCount;
	private ArrayList<Item> itemList;
	
	public Cart(int cartId, int cartCount, Item item) {
		this.cartId = cartId;
		this.cartCount = cartCount;
		itemList = new ArrayList<Item>(); 
	}
	
	public Cart() {
		
		this.cartId = 0;
		this.cartCount = 0;
		itemList = new ArrayList<Item>(); 
		
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
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
	
	public void addItemToList(Item item) {
		itemList.add(item);
	}
	public Item getItem(int index) {
		return itemList.get(index);
	}
	
	
}
