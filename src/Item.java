import java.io.Serializable;

public class Item implements Serializable {

	private String name;
	private String desc;
	private boolean heavy;
	private boolean used;
	private boolean locked;
		
	public Item(String n, String d) {
		name = n;
		desc = d;
		heavy = false;
		used = false;
		locked = false;
	}
	
	public boolean isLocked() {
		return locked;
	}
	
	public void setLocked(boolean b) {
		locked = b;
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
	
	public void take() {
		if(isHeavy()) {
			Game.print("That's too heavy to carry around!");
		} else {
			Game.getInventory().add(Game.getCurrentRoom().removeItem(name));
			System.out.println();
			Game.print("You pick up the " + name + ".");
		}
	}
	
	public void look() {
		Game.print(desc);
	}
	
	public void use() {
		Game.print("You cannot use this.");
	}
}
