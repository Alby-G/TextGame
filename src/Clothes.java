
public class Clothes extends Item{

	public Clothes() {
		super("clothes", "a dirty pile of laundry scattered in the middle of the closet.");
	}
	
	public void use() {
		if(Game.getCurrentRoom().getName().equals("Closet")) {
			if(isUsed()) {
				Game.print("You have already thrown the clothes around the closet, only a sicko would commit such an act again.");
			} else {
				setUsed(true);
				Game.print("You dig through the dirty pile of clothes and you feel something a bit hard. You grab it and to your surprise there is a complete torso bone now in your hands.");
				Game.getCurrentRoom().setID("CLOSET_B");
				Game.getInventory().add(new Torso());
			}
		} else {
			Game.print("There are no clothes here.");
		}
	}
	
}
