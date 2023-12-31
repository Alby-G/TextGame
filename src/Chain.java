
public class Chain extends Item{

	public Chain() {
		super("chain", "A weird chain hanging from the ceiling, you wonder what it does.");	
		super.setHeavy(true);
	}
	
	
	
	public void use() {
		if(Game.getCurrentRoom().getName().equals("Game Room")) {
			if(isUsed()) {
				Game.print("There is no more goo left to be poured on you. Why would you want more?");
			} else {
				Game.print("You have been completely drenched in goo!");
				Item goo = new Item("Goo","It's green and you smell very bad.");
				Game.getInventory().add(goo);
				super.setUsed(true);
				if(Game.getCurrentRoom().hasItem("wand")) {
					Game.getCurrentRoom().setID("GAMEROOM_D");
				} else {
					Game.getCurrentRoom().setID("GAMEROOM_C");
				}
			}
		} else {
			Game.print("You can't do that!");
		}
	}
	
}
