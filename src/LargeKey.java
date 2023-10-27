
public class LargeKey extends Item{
	
	public LargeKey() {
		super("largekey", "It's a massive key.");
	}
	
	public void use() {
		if(Game.getCurrentRoom().getName().equals("Path Two")) {
			System.out.println("You are able to unlock the lock on the shed doors.");
			Room shed = Game.getCurrentRoom().getExit("e");
			shed.setLocked(false);
		} else {
			System.out.println("The large key is not of use here.");
		}
		
	}
}
