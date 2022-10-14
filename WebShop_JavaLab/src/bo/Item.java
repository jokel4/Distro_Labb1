package bo;

/**
 * Represent a Item in the system. This is a representations of the Item tabel that exist in DB.
 * 
 * @author jonatanKelati & gergoTarchech
 *
 */
public class Item {
	
	private int id;
	private String name;
	private String description;
	private String category;
	private int count;
	private int minCount;
	
	public Item(int id,String name, String description, String category, int count) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.category = category;
		this.count = count;
		this.minCount = 0;
	}
	public Item(String name, String description, String category, int count) {
		this.name = name;
		this.description = description;
		this.category = category;
		this.count = count;
		this.minCount = 0;
	}
	
	public Item() {
	
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	public int getMinCount() {
		return minCount;
	}
	public void setMinCount(int minCount) {
		this.minCount = minCount;
	}
	
	
}
