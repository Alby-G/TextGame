
public class LargeKey extends Item{
	
	public LargeKey() {
		super("largekey", "It's a massive key.");
	}
	
	public void take() {
		super.take();
		Game.getCurrentRoom().setID("LIVING_ROOM_B");
	}
	
	public void use() {
		if(Game.getCurrentRoom().getName().equals("Path Two")) {
			if(!isUsed()) {
				Game.print("You are able to unlock the lock on the shed doors.");
				Room shed = Game.getCurrentRoom().getExit("e");
				shed.setLocked(false);
				Game.getCurrentRoom().setID("BACK_YARD_PATH_B");
			} else {
				Game.print("You have already used the large key");
			}
		} else {
			Game.print("The large key is not of use here.");
		}
		
	}
}
