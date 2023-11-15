
public class RightArm extends Item{
	
	public RightArm() {
		super("rightarm", "The right arm bone of the house's previous owner.");
	}
	
	public void use() {
		Item item = null;
		if(Game.getCurrentRoom().getName().equals("Tomb")) {
			for(Item i : Game.getInventory()) {
				if(i.getName().equals("rightarm")) {
					item = i;
				}
			}
			if(item!= null) {
				Game.getInventory().remove(item);
			}
			Game.getConditions().add("rightarmPlaced");
			
			if(Game.getConditions().contains("rightarmPlaced") && Game.getConditions().contains("rightlegPlaced") && Game.getConditions().contains("leftlegPlaced") && Game.getConditions().contains("leftarmPlaced") && Game.getConditions().contains("skullPlaced") && Game.getConditions().contains("torsoPlaced")) {
				Game.print("You have placed the right arm bone, which was the final bone to collect. You are now able to use the grave to recreate the skeleton.");
				Item i  = Game.getCurrentRoom().getItem("grave");
				i.setLocked(false);
			} else {
				Game.print("You have placed the right arm bone into the open grave, but there are still more bones to collect.");
			}
		} else {
			Game.print("You can't do this right now.");
		}
	}

}
