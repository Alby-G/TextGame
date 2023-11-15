
public class Grave extends Item{

	public Grave(){
		super("grave", "The grave sight that has been desecrated for some unknown reason.");
		super.setHeavy(true);
		super.setLocked(true);
	}
	
	public void use() {
		if(Game.getCurrentRoom().getName().equals("Tomb")) {
			if(isUsed()) {
				Game.print("You have already reconstructed the skeleton you freak.");
			} else {
				Game.print("You have successfully recreated the skeleton. He stands up on his own and give you a puzzling look. You explain what has happened to him and that you are stuck in the property. The skeleton nods in understanding and seems to thank you for your good deed. He does a few hand twirls and a key magically appears in his hands. He hands you the key still without mentioning a word. You can only assume this opens the lock on the exit gate.");
				Game.getInventory().add(new MasterKey());
			}
		} else {
			Game.print("There is no grave here.");
		}
	}
	
}
