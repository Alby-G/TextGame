
public class Fridge extends Item{
	
	public Fridge(){
		super("fridge", "A nice size fridge, there might be food inside.");
		super.setHeavy(true);
	}
	
	public void use() {
		if(Game.getCurrentRoom().getName().equals("Kitchen")) {
			Game.print("You open the fridge and there is absolutely nothing inside, this is to the dismay of your stomach.");
		} else {
			Game.print("You can't do that right now");
		}
	}

}
