import java.io.Serializable;
import java.util.HashMap;

public class Room implements Serializable {
	//private String description;
	private Room east;
	private Room west;
	private Room north;
	private Room south;
	private Room up;
	private Room down;
	private boolean locked;
	private String name;
	private String id;
	
	private HashMap<String, Item> roomItems;
	private HashMap<String, NPC> roomNPCs;
	
	public Room(String n, String d) {
		name = n;
		//description = d;
		id = d;
		locked = false;
		roomItems = new HashMap<String, Item>();
		roomNPCs = new HashMap<String, NPC>();
		World.rooms.put(name, this); //Room objects places itself in the map
	}
	
	public void addNPC(NPC npc) {
		roomNPCs.put(npc.getName(), npc);
	}
	
	public NPC getNPC(String name) {
		return roomNPCs.get(name);
	}
	
	public boolean hasNPC(String name) {
		return roomNPCs.containsKey(name);
	}
	
	public NPC removeNPC(String name) {
		return roomNPCs.remove(name);
	}
	
	public void setID(String s) {
		id = s;
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
	
	public String getDesc() {
		return Game.roomDescriptions.get(id);
	}
	
	public String toString() {
		return Game.roomDescriptions.get(id);
	}

}
