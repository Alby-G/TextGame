
public class Dresser extends Item{
	
	public Dresser() {
		super("dresser", "A plain dresser with a few drawers, you are unable to open them because it is entirely wrapped with metal chains.");
		super.setHeavy(true);
		super.setLocked(true);
	}
	
	public void use() {
		if(Game.getCurrentRoom().getName().equals("Master Bedroom")) {
			if(isUsed()) {
				Game.print("You have already opened the dresser.");
			} else if(isLocked()) {
				Game.print("The dresser is locked and unable to be opened at the moment.");
			} else {
				Game.print("You search through the dresser and you stumble upon the right arm bone of the home's previous owner. You grab the bone.");
				Game.getInventory().add(new RightArm());
				setUsed(true);
			}
		} else {
			Game.print("You cannot do that right now.");
		}
	}

}
