
public class Shower extends Item{

	public Shower(){
		super("shower", "You can use it if you want.");
	}
	
	public void use() {
		Item item = null;
		if(Game.getCurrentRoom().getName().equals("Bathroom")) {
			if(isUsed()) {
				Game.print("You have already washed the goo off yourself");
			} else {
				for(Item i : Game.getInventory()) {
					if(i.getName().equals("Goo")) {
						Game.print("You have washed the goo off and smell some what better.");
						item = i;
					}
				}
				if(item!=null) {
					Game.getInventory().remove(item);
				} else {
					Game.print("You are not currently dirty enough to warrant a shower.");
				}
			}
		} else {
			Game.print("You can't do that!");
		}
	}
	
}
