
public class Freezer extends Item{
	
	public Freezer() {
		super("freezer", "Connected to the fridge, who knows whats inside of it.");
		super.setHeavy(true);
	}

	public void use() {
		if(Game.getCurrentRoom().getName().equals("Kitchen")) {
			Game.print("You open the freezer and when you take a look inside you find a cold right leg bone.");
			Game.getCurrentRoom().addItem(new RightLeg());
		} else {
			Game.print("You can't do that right now.");
		}
	}
	
}
