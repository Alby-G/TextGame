
public class MasterKey extends Item{

	public MasterKey() {
		super("masterkey", "The key that finally and hopefully lets you escape this property.");
	}
	
	public void use() {
		if(Game.getCurrentRoom().getName().equals("Path One")) {
			Game.print("You fit the key into the lock on the gate and to your relief it turns without much force. The gate swings open, allowing you to leave.");
			Room front = Game.getCurrentRoom().getExit("s");
			front.setLocked(false);
			Game.getCurrentRoom().setID("FRONT_YARD_PATH_B");
		} else {
			Game.print("The master key is not of use here.");
		}
	}
}
