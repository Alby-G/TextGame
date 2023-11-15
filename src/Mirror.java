
public class Mirror extends Item{
	
	public Mirror() {
		super("mirror", "A funky looking mirror, it appear you may be able to open it");
		super.setHeavy(true);
	}

	public void use() {
		if(Game.getCurrentRoom().getName().equals("Bathroom")) {
			if(isUsed()) {
				Game.print("The mirror is already opened.");
			} else {
				System.out.println("You open the mirror and a small key falls out onto the floor");
				setUsed(true);
				Game.getCurrentRoom().addItem(new SmallKey());
			}
		} else {
			Game.print("You cannot do that.");
		}
	}
}
