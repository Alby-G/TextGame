import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
public class Game {

	private static Room currentRoom;
	private static ArrayList<Item> inventory = new ArrayList<Item>();
	public static HashMap<String, String> roomDescriptions = new HashMap<String, String>();
	public static HashSet<String> conditions = new HashSet<String>();
	public static Scanner scan = new Scanner(System.in);
	
	public static void populateMap(String fileName) {
		Scanner scan;
		try {
			scan = new Scanner(new File(fileName));
			String id;
			String desc;
			while(scan.hasNextLine()) {
				id = scan.nextLine();
				desc = scan.nextLine();
				roomDescriptions.put(id, desc);
				scan.nextLine();
			}
		} catch (FileNotFoundException e) {
			print("ERROR: Cannot read file.");
			e.printStackTrace();
		}
	}
	
	public static void saveGame() {
		File saveFile = new File("save");
		try {
			saveFile.createNewFile();
			ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(saveFile));
			stream.writeObject(currentRoom);
			stream.writeObject(inventory);
			stream.writeObject(World.rooms);
			stream.close();
			print("Game Saved");
		} catch (IOException e) {
			print("ERROR: Cannot save File.");
			e.printStackTrace();
		}
	}
	
	public static void loadGame() {
		try {
			ObjectInputStream stream = new ObjectInputStream(new FileInputStream(new File("save")));
			try {
				currentRoom = (Room) stream.readObject();
			} catch (ClassNotFoundException e) {
				print("Could not load the current room.");
				e.printStackTrace();
			}
			try {
				inventory = (ArrayList<Item>) stream.readObject();
			} catch (ClassNotFoundException e) {
				print("Could not load the inventory");
				e.printStackTrace();
			}
			try {
				World.rooms = (HashMap<String, Room>) stream.readObject();
			} catch (ClassNotFoundException e) {
				print("Could not load rooms");
				e.printStackTrace();
			}
			print("Game Loaded");
			stream.close();
		} catch (FileNotFoundException e) {
			print("File not Found,");
			e.printStackTrace();
		} catch (IOException e) {
			print("ERROR: Cannot load File.");
			e.printStackTrace();
		}
	}
	
	public static Room getCurrentRoom() {
		return currentRoom;
	}
	
	public static ArrayList<Item> getInventory(){
		return inventory;
	}
	
	public static HashSet<String> getConditions(){
		return conditions;
	}
	
	public static void print(String message) {
		System.out.println(message+"\n");
	}
	
	public static void main(String[] args) {
		print("You have been sent on a mission to a manision. Your goal is to recollect and return the missing skeleton parts of the houses owner and return them to the tomb. It is said that his skeleton has been scattered around the mansion. Once you entered through the front gate is appears to have slammed shut, so if you want to make it out of here you better complete what you came here to do. You proceed to enter the front door of the house.");
		populateMap("roomDescriptions.txt");
		String playerCommand;
		String itemName;
		Item i2;
		NPC npc;
		currentRoom = World.buildWorld();
		System.out.println(currentRoom);
		do {
			System.out.println();
			System.out.print("What do you want to do? ");
			playerCommand = scan.nextLine();
			String[] a;
			a = playerCommand.split(" ");
			switch(a[0]) {
				case "e":
				case "w":
				case "n":
				case "s":
				case "u":
				case "d":
					Room nextRoom = currentRoom.getExit(a[0]);
					if(nextRoom != null) {
						if(nextRoom.isLocked()) {
							print("The room is locked.");
						} else {
							currentRoom = nextRoom;
							System.out.println();
							System.out.println(currentRoom);
						}
					} else {
						print("You can't travel that way!");
					}
					
					if(getCurrentRoom().getName().equals("Exit")) {
						System.exit(0);
					}
					break;
				
				case "save":
					saveGame();
					break;
					
				case "load":
					loadGame();
					System.out.println();
					System.out.println(currentRoom);
					break;
					
				case "i":
					if(inventory.isEmpty()) {
						print("You are carrying nothing.");
					} else {
						for(Item i: inventory) {
							System.out.println(i);
						}
					}
					break;
					
				case "x":
					print("Okay. Bye!");
					break;
					
				case "take":
					//System.out.println("Take what? ");
					//itemName = scan.nextLine();
					itemName = a[1];
					if(currentRoom.hasItem(itemName)) {
						Item item = currentRoom.getItem(itemName);
						item.take();
					} else {
						print("There is no "+ a[1] + "!");
					}
					break;
					
				case "look":
					itemName = a[1];
					i2 = currentRoom.getItem(a[1]);
					boolean found = false;
					if(currentRoom.hasItem(a[1])) {
						i2.look();
						found = true;
					} else {
						for(Item i : inventory) {
							if(itemName.equals(i.getName())) {
								i.look();
								found = true;
							}
						}
						
						if(!found) {
							print("There is no " + a[1] + "!");
						}
					}	
					break;
					
				case "use":
					System.out.println();
					itemName=a[1];
					boolean found2 = false;
					Item i = Game.getItem(a[1]);
					if(i != null) {
						found2 = true;
						i.use();
					}
					i2 = currentRoom.getItem(a[1]);
					if(currentRoom.hasItem(a[1])) {
						i2.use();
						found2 = true;
					}
					if(!found2) {
						print("You can't do that.");
					}
					
					
					break;
					
				case "talk":
					npc = currentRoom.getNPC(a[1]);
					npc.talk();
					break;
					
				default:
					print("Invalid command.");
			}
		} while(!playerCommand.equals("x"));
		scan.close();
	} //close main
	
	public static Item getItem(String name) {
		for(Item i : inventory) {
			if(i.getName().equals(name)) {
				return i;
			}
		}
		return null;
	}
} //close class

//	public static void main(String[] args) {
//		Room currentRoom = World.buildWorld();
//		System.out.println(currentRoom);
//		System.out.println("\nNow we'll move west!");
//		currentRoom = currentRoom.getExit('w');
//		System.out.println(currentRoom);
//		System.out.println("\nNow we'll move down!");
//		currentRoom = currentRoom.getExit('d');
//		System.out.println(currentRoom);
//		System.out.println("\nNow we'll move up!");
//		currentRoom = currentRoom.getExit('u');
//		System.out.println(currentRoom);
//		System.out.println("\nNow we'll move east!");
//		currentRoom = currentRoom.getExit('e');
//		System.out.println(currentRoom);
//		System.out.println("\nNow we'll move north!");
//		currentRoom = currentRoom.getExit('n');
//		System.out.println(currentRoom);
//		System.out.println("\nNow we'll move south!");
//		currentRoom = currentRoom.getExit('s');
//		System.out.println(currentRoom);
//		System.out.println("\nNow we'll move south!");
//		currentRoom = currentRoom.getExit('s');
//		System.out.println(currentRoom);
//		System.out.println("\nNow we'll move north!");
//		currentRoom = currentRoom.getExit('n');
//		System.out.println(currentRoom);
//		System.out.println("\nNow we'll move up!");
//		currentRoom = currentRoom.getExit('u');
//		System.out.println(currentRoom);
//		System.out.println("\nNow we'll move down!");
//		currentRoom = currentRoom.getExit('d');
//		System.out.println(currentRoom);
//		}


