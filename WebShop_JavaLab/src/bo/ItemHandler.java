package bo;

import java.sql.SQLException;
import java.util.ArrayList;

import db.ItemDB;
import ui.ItemInfo;
/**
 * 
 * @author jonatankelati & gergotarchech
 *
 */
public class ItemHandler {
	
	private ItemHandler(Item item) {
		
	}
	private Item item;
	private static ItemDB itemDB;
	
	/**
	 * 
	 * @return a list of items that is going to be listed in UI
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static ArrayList<ItemInfo> getItems() throws ClassNotFoundException, SQLException {
		itemDB= new ItemDB();
		ArrayList<Item> items = itemDB.getItems();
		ArrayList<ItemInfo> itemInfos = new ArrayList<>();
		ItemInfo itemInfo;
		for(Item i:items) {
			itemInfo = new ItemInfo(i.getId(),i.getName(),i.getDescription(),i.getCategory(),i.getCount());
			itemInfos.add(itemInfo);
		}
		
		return itemInfos;
	}
	
	/**
	 * 
	 * @param itemId
	 * @return a item
	 * @throws SQLException
	 */
	public static ItemInfo getItem(int itemId) throws SQLException {
		itemDB=new ItemDB();
		Item item = itemDB.getItem(itemId);
		ItemInfo itemInfo = new ItemInfo(item.getId(),item.getName(),item.getDescription(),item.getCategory(),item.getCount());
		return itemInfo;
		
	}
	
	/**
	 * updates item in database
	 */

	public static void updateItem(int id, int newCount) throws SQLException {
		itemDB = new ItemDB();
		itemDB.upddateItem(id,newCount);
		
	}
}
