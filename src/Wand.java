
public class Wand extends Item{
	
	public Wand() {
		super("wand", "may be magical but probably not");
	}
	
	public void use() {
		if(Game.getCurrentRoom().getName().equals("Basement")) {
			if(isUsed()) {
				System.out.println("The chest is already open.");
			} else {
				System.out.println("You wave the magical wand around. It opens the chest and find a shiny diamond inside.");
				Item diamond = new Item("diamond", "Sparkly!");
				Game.getCurrentRoom().addItem(diamond);
				setUsed(true);
			}
		} else {
			System.out.println("You wave the wand around and proceed to look like a fool.");
		}
		
	}
}
