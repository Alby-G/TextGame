
public class Boltcutters extends Item{

	public Boltcutters() {
		super("boltcutters", "Rusty boltcutters, should be able to break a chain if needed.");
	}
	
	public void use() {
		if(Game.getCurrentRoom().getName().equals("Master Bedroom")) {
			if(isUsed()) {
				Game.print("The dresser has already been unlocked.");
			} else {
				Game.getCurrentRoom().getItem("dresser").setLocked(false);
				Game.print("You use the boltcutters to cut the chains off the dresser. You are now able to open the drawers of the dresser.");
				
			}
		} else {
			Game.print("The boltcutters are not of use here.");
		}
	}
	
}
