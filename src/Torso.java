
public class Torso extends Item{
	
	public Torso() {
		super("torso", "The complete and intact torso bone of the house's previous owner.");
	}
	
	public void use() {
		Item item = null;
		if(Game.getCurrentRoom().getName().equals("Tomb")) {
			for(Item i : Game.getInventory()) {
				if(i.getName().equals("torso")) {
					item = i;
				}
			}
			if(item!= null) {
				Game.getInventory().remove(item);
			}
			Game.getConditions().add("torsoPlaced");
			
			if(Game.getConditions().contains("rightarmPlaced") && Game.getConditions().contains("rightlegPlaced") && Game.getConditions().contains("leftlegPlaced") && Game.getConditions().contains("leftarmPlaced") && Game.getConditions().contains("skullPlaced") && Game.getConditions().contains("torsoPlaced")) {
				Game.print("You have placed the torso bone, which was the final bone to collect. You are now able to use the grave to recreate the skeleton.");
				Item i  = Game.getCurrentRoom().getItem("grave");
				i.setLocked(false);
			} else {
				Game.print("You have placed the torso into the open grave, but there are still more bones to collect.");
			}
		} else {
			Game.print("You can't do this right now.");
		}
	}

}
