
public class Puppy extends NPC{

	public Puppy() {
		super("puppy", "A hideous puppy wags his tail.");
	}
	
	@Override
	public void talk() {
		if(Game.getConditions().contains("pTalked1") && Game.getConditions().contains("pTalked2")) {
			say("Yip!");
			Game.print("The puppy wags his tail.");
		}
		
		else if(Game.getConditions().contains("pTalked1")) {
			say("Hey! Wanna play fetch? Say yes! Say yes!");
			String[] options = {
				"Yes! I love fetch!",
				"No. I am a horrible person and don't like playing with puppies."
			};
			getResponse(options);
		}
		else {
			say("Hi! I'm an adorable puppy!");
			String[] options = {
				"Yes you are! Who's a good boy?",
				"Ew, no. You're actually kinda hideous."
			};
			getResponse(options);
		}
	}
	
	@Override
	public void response(int option) {
		if(Game.getConditions().contains("pTalked1")) {
			switch(option) {
				case 1:
					say("Yay! Fetch!");
					Game.print("The puppy runs off and returns with a ball.");
					Item ball = new Item("ball", "A bright red ball the puppy retrieved for you.");
					Game.getInventory().add(ball);
					Game.getConditions().add("pTalked2");
					break;
				case 2:
					say("You're a bad person! I don't like you!");
					Game.print("The puppy runs away and doesn't come back.");
					Game.getCurrentRoom().removeNPC("puppy");
					Game.getConditions().add("pTalked2");
					break;
			}
		}
		
		else if(Game.getConditions().contains("pTalked1") && Game.getConditions().contains("pTalked2")) {
			
		}
		else {
			switch(option) {
				case 1:
					say("I am! I'm a good boy!");
					Game.getConditions().add("pTalked1");
					break;
				case 2:
					say("I am to adorable! Why are you so mean?");
					Game.print("The puppy bites you. You deserve it.");
					Game.getConditions().add("pTalked1");
					break;
			}
		}
	}
}
