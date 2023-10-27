
public class World {
	// Builds the game world.
	// Returns the room the player starts in.
	public static Room buildWorld() {
		Room livingRoom = new Room("Living Room", "You are in the living room.");
		Room kitchen = new Room("Kitchen", "You are in the kitchen.");
		Room gameRoom = new Room("Game Room", "You are in the game room.");
		Room basement = new Room("Basement", "You are in the basement.");
		Room hall = new Room("Hall", "You are in the upstairs hallway.");
		Room path1 = new Room("Path One", "You are in the front yard pathway.");
		Room exit = new Room("Exit", "You are at the exit.");
		Room path2 = new Room("Path Two", "You are in back yard pathway.");
		Room tomb = new Room("Tomb", "You are in the tomb.");
		Room shed = new Room("Shed", "You are in the shed.");
		Room masterBedroom = new Room("Master Bedroom", "You are in the master bedroom.");
		Room bathroom = new Room("Bathroom", "You are in the upstairs bathroom");
		Room closet = new Room("Closet", "You are in the upstairs closet");
		
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
		
		livingRoom.addItem(new LargeKey());
		shed.addItem(new Item("boltcutters", "Rusty boltcutters, should be able to break something."));
		livingRoom.addItem(new Wand());
		kitchen.addItem(new Item("knife", "A sharp metal knife, could be useful for something."));
		closet.addItem(new SmallKey());
		
		return livingRoom;
	}
}
