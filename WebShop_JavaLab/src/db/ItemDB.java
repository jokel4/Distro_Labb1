package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bo.Item;
import bo.User;
/**
 * 
 * @author jonatankelati & gergotarchech
 *
 */
public class ItemDB {
	static Connection connection = null;
	static Statement statement = null;
	static ResultSet resultSet = null;
	
	
	public ArrayList<Item> getItems() throws SQLException, ClassNotFoundException {
		Item item;
		ArrayList<Item> items = new ArrayList<>();
		try {
			connection = DBManager.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from item");
			while(resultSet.next()) {
				int itemId = resultSet.getInt("id");
				String itemName = resultSet.getString("item_name");
				String itemDescription = resultSet.getString("item_description");
				String itemCategory = resultSet.getString("item_category");
				int itemCount = resultSet.getInt("item_count");
				
				item = new Item(itemId, itemName,itemDescription,itemCategory,itemCount);
				items.add(item);
				
			}
		}catch(SQLException s) {
			s.printStackTrace();
		}
		finally {
			resultSet.close();
			statement.close();
			connection.close();
		}
		
		return items;
	}


	public Item getItem(int itemId) throws SQLException {
		Item item = new Item();
		try {
			connection = DBManager.getConnection();
			PreparedStatement statement = connection.prepareStatement("select * from item WHERE id=?");
			statement.setInt(1,itemId);
			resultSet = statement.executeQuery();
			
			
			if(resultSet.next()) {
				int itemIdd = resultSet.getInt("id");
				String itemName = resultSet.getString("item_name");
				String itemDescription = resultSet.getString("item_description");
				String itemCategory = resultSet.getString("item_category");
				int itemCount = resultSet.getInt("item_count");
				item.setId(itemIdd);
				item.setName(itemName);
				item.setDescription(itemDescription);
				item.setCategory(itemCategory);
				item.setCount(itemCount);
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
		return item;
	}


	public void upddateItem(int itemId, int newCount) throws SQLException {
		Item item = new Item();
		try {
			connection = DBManager.getConnection();
			PreparedStatement statement = connection.prepareStatement("UPDATE ITEM SET item_count=? WHERE id=?");
			statement.setInt(1,newCount);
			statement.setInt(2,itemId);
			statement.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			statement.close();
			connection.close();
		}
		
	}


	

}
