
public class Item {

	private String name;
	private String desc;
	private boolean heavy;
	private boolean used;
		
	public Item(String n, String d) {
		name = n;
		desc = d;
		heavy = false;
		used = false;
	}
	
	public boolean isHeavy() {
		return heavy;
	}
	
	public void setHeavy(boolean b) {
		heavy = b;
	}
	
	public void setDesc(String d) {
		desc = d;
	}
	
	public boolean isUsed() {
		return used;
	}
	
	public void setUsed(boolean b) {
		used = b;
	}
	
	public String getName() {
		return name;
	}
	
	public String toString() {
		return name;
	}
	
	public void look() {
		System.out.println(desc);
	}
	
	public void use() {
		System.out.println("You cannot use this.");
	}
}
