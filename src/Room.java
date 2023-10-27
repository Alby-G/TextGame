import java.util.HashMap;

public class Room {
	private String description;
	private Room east;
	private Room west;
	private Room north;
	private Room south;
	private Room up;
	private Room down;
	private boolean locked;
	private String name;
	
	private HashMap<String, Item> roomItems;
	
	public Room(String n, String d) {
		name = n;
		description = d;
		roomItems = new HashMap<String, Item>();
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isLocked() {
		return locked;
	}
	
	public void setLocked(boolean b) {
		locked = b;
	}
	
	public Item getItem(String name) {
		return roomItems.get(name);
	}
	
	public Item removeItem(String name) {
		return roomItems.remove(name);
	}
	
	public void addItem(Item i) {
		roomItems.put(i.getName(), i);
	}
	
	public boolean hasItem(String name) {
		return roomItems.containsKey(name);
	}
	
	public Room getExit(String move) {
		if(move.equals("e")) {
			return east;
		} else if(move.equals("w")) {
			return west;
		} else if(move.equals("n")) {
			return north;
		} else if(move.equals("s")) {
			return south;
		} else if(move.equals("u")) {
			return up;
		} else if(move.equals("d")) {
			return down;
		} else {
			return null;
		}
	}
	
	public void addExit(Room r, char move) {
		if(move == 'e') {
			east = r;
		} else if(move == 'w') {
			west = r;
		} else if(move == 'n') {
			north = r;
		} else if(move == 's') {
			south = r;
		} else if(move == 'u') {
			up = r;
		} else if(move == 'd') {
			down = r;
		}
	}
		
	public String toString() {
		return description;
	}
}
