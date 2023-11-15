
public class Hammer extends Item{
	
	public Hammer(){
		super("hammer", "Could smash something small.");
	}
	
	public void use() {
		if(Game.getCurrentRoom().getName().equals("Living Room")) {
			if(isUsed()) {
				Game.print("The piggy bank has already been broken open.");
			} else {
				Game.print("You smash open the piggy bank with the hammer. As the piggy bank breaks a left arm bone jumps out from it.");
				Game.getCurrentRoom().addItem(new LeftArm());
				Game.getCurrentRoom().removeItem("piggybank");
				Game.getCurrentRoom().setID("LIVING_ROOM_C");
			}
		} else {
			Game.print("The hammer is not of use here.");
		}
	}

}
