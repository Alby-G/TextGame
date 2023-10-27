
public class SmallKey extends Item{
	
	public SmallKey() {
		super("smallkey", "Should fit into a super, duper, tiny place somehwere.");
	}
	
	public void use() {
		if(Game.getCurrentRoom().getName().equals("Hall")) {
			System.out.println("You were able to unlock the master bedroom with the small key.");
			Room exit = Game.getCurrentRoom().getExit("w");
			exit.setLocked(false);
		} else {
			System.out.println("The small key is not of use here.");
		}
	}
}
