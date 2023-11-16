import java.util.HashMap;

public class World {
	// Builds the game world.
	// Returns the room the player starts in.
	
	public static HashMap<String, Room> rooms = new HashMap<String, Room>();
	
	public static Room buildWorld() {
		Room livingRoom = new Room("Living Room", "LIVING_ROOM_A");
		Room kitchen = new Room("Kitchen", "KITCHEN");
		Room gameRoom = new Room("Game Room", "GAMEROOM_A");
		Room basement = new Room("Basement", "BASEMENT");
		Room hall = new Room("Hall", "UPSTAIRS_HALLWAY_A");
		Room path1 = new Room("Path One", "FRONT_YARD_PATH_A");
		Room exit = new Room("Exit", "EXIT");
		Room path2 = new Room("Path Two", "BACK_YARD_PATH_A");
		Room tomb = new Room("Tomb", "TOMB_A");
		Room shed = new Room("Shed", "SHED");
		Room masterBedroom = new Room("Master Bedroom", "MASTER_BEDROOM");
		Room bathroom = new Room("Bathroom", "BATHROOM");
		Room closet = new Room("Closet", "CLOSET_A");
		
		livingRoom.addExit(kitchen, 'w');
		livingRoom.addExit(gameRoom, 'n');
		livingRoom.addExit(hall, 'u');
		livingRoom.addExit(path1, 's');
		kitchen.addExit(livingRoom, 'e');
		kitchen.addExit(basement, 'd');
		kitchen.addExit(path2, 'n');
		basement.addExit(kitchen,  'u');
		gameRoom.addExit(livingRoom, 's');
		hall.addExit(livingRoom, 'd');
		hall.addExit(masterBedroom,  'w');
		hall.addExit(closet, 'e');
		hall.addExit(bathroom, 'n');
		path1.addExit(livingRoom,  'n');
		path1.addExit(exit, 's');
		closet.addExit(hall, 'w');
		bathroom.addExit(hall,  's');
		masterBedroom.addExit(hall, 'e');
		path2.addExit(kitchen,  's');
		path2.addExit(shed, 'e');
		path2.addExit(tomb,  'w');
		tomb.addExit(path2,  'e');
		shed.addExit(path2, 'w');
		
		shed.setLocked(true);
		exit.setLocked(true);
		masterBedroom.setLocked(true);
		
		gameRoom.addItem(new Chain());
		
		basement.addItem(new Chest());
		
		bathroom.addItem(new Shower());
		
		shed.addItem(new WorkBench());
		
		livingRoom.addItem(new LargeKey());
		shed.addItem(new Boltcutters());
		gameRoom.addItem(new Wand());
		shed.addItem(new Hammer());
		bathroom.addItem(new Mirror());
		closet.addItem(new Clothes());
		tomb.addItem(new LeftLeg());
		tomb.addItem(new Grave());
		livingRoom.addItem(new PiggyBank());
		masterBedroom.addItem(new Dresser());
		kitchen.addItem(new Fridge());
		kitchen.addItem(new Freezer());
		
		livingRoom.addNPC(new Puppy());
		
		return livingRoom;
	}
}
