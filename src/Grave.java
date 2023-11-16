
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
				Game.print("You have successfully recreated the skeleton. He stands up on his own and gives you a puzzling look.");
				Game.getCurrentRoom().addNPC(new Skeleton());
			}
		} else {
			Game.print("There is no grave here.");
		}
	}
	
}
