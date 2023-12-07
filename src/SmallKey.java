
public class SmallKey extends Item{
	
	public SmallKey() {
		super("smallkey", "Should fit into a super, duper, tiny place somehwere.");
	}
	
	public void use() {
		if(Game.getCurrentRoom().getName().equals("Hall")) {
			if(isUsed()) {
				Game.print("You have already used the small key");
			} else {
				Game.print("You were able to unlock the master bedroom with the small key.");
				Room exit = Game.getCurrentRoom().getExit("w");
				exit.setLocked(false);
				Game.getCurrentRoom().setID("UPSTAIRS_HALLWAY_B");
			}
		} else {
			Game.print("The small key is not of use here.");
		}
	}
}
