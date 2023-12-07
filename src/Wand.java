
public class Wand extends Item{
	
	public Wand() {
		super("wand", "may be magical but probably not");
	}
	
	public void take() {
		super.take();
		Game.getCurrentRoom().setID("GAMEROOM_E");
	}
		
	public void use() {
		if(Game.getCurrentRoom().getName().equals("Basement")) {
			if(isUsed()) {
				Game.print("The chest is already open.");
			} else {
				Game.print("You wave the magical wand around. It opens the chest and you find the missing skull of the owner inside.");
				Game.getCurrentRoom().addItem(new Skull());
				setUsed(true);
			}
		} else {
			Game.print("You wave the wand around and proceed to look like a fool.");
		}
		
	}
}