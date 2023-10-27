import java.util.ArrayList;
import java.util.Scanner;
public class Game {

	private static Room currentRoom;
	private static ArrayList<Item> inventory = new ArrayList<Item>();
	
	public static Room getCurrentRoom() {
		return currentRoom;
	}
	
	public static ArrayList<Item> getInventory(){
		return inventory;
	}
	
	public static void print(String message) {
		System.out.println(message+"\n");
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String playerCommand;
		String itemName;
		Item i2;
		currentRoom = World.buildWorld();
		System.out.println(currentRoom);
		do {
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
							System.out.println("The room is locked.");
						} else {
							currentRoom = nextRoom;
							System.out.println(currentRoom);
						}
					} else {
						System.out.println("You can't travel that way!");
					}
					break;
					
				case "i":
					if(inventory.isEmpty()) {
						System.out.println("You are carrying nothing.");
					} else {
						for(Item i: inventory) {
							System.out.println(i);
						}
					}
					break;
					
				case "x":
					System.out.println("Okay. Bye!");
					break;
					
				case "take":
					//System.out.println("Take what? ");
					//itemName = scan.nextLine();
					itemName = a[1];
					if(currentRoom.hasItem(itemName)) {
						Item item = currentRoom.getItem(itemName);
						if(item.isHeavy()) {
							System.out.println("That's too heavy to carry!");
						} else {
							inventory.add(currentRoom.removeItem(a[1]));
							System.out.println("You pick up the " +a[1]+".");
						}
					} else {
						System.out.println("There is no "+ a[1] + "!");
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
							System.out.println("There is no " + a[1] + "!");
						}
					}	
					break;
					
				case "use":
					itemName=a[1];
					boolean found2 = false;
					for(Item i : inventory) {
						if(itemName.equals(i.getName())) {
							i.use();
							found2 = true;
						}
					}
					i2 = currentRoom.getItem(a[1]);
					if(currentRoom.hasItem(a[1])) {
						i2.use();
						found2 = true;
					}
					
					if(!found2) {
						System.out.println("You can't do that.");
					}
					
					
					break;
					
				default:
					System.out.println("Invalid command.");
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


