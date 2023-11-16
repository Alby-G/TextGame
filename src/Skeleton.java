
public class Skeleton extends NPC{

	public Skeleton() {
		super("skeleton", "The deceased owner of the house has risen from the dead.");
	}
	
	public void talk() {
		if(Game.getConditions().contains("sTalked1")) {
			say("Is there anything you need from me?");
			String[] options = {
					"The front gate is locked for me to leave. I was hoping you knew something about it.",
					"Well I need to leave now. Do you know how to do that buster!"
			};
			getResponse(options);
		} else {
			say("Wow! What happened, I don't feel too great.");
			String[] options = {
					"Your grave had been desecrated and I was able to find all of your missing bones to grant you peace.",
					"You've been dead for some time and unable to rest without your completed skeleton. Thanks to my help."
			};
			getResponse(options);
	
		}
	}
	
	public void response(int option) {
		if(Game.getConditions().contains("sTalked1")) {
			switch(option) {
				case 1:
					say("Hmm, the front gate eh.");
					Game.print("He does a few hand twirls and a key magically appears in his hands. He hands you the key. You assume this opens the lock on the exit gate.");
					Game.getInventory().add(new MasterKey());
					break;
					
				case 2:
					say("Hey, you do not call me buster! But just this once for helping me out the way you did");
					Game.print("He does a few hand twirls and a key magically appears in his hands. He hands you the key. You assume this opens the lock on the exit gate.");
					Game.getInventory().add(new MasterKey());
					break;
			}
		} else	{
			switch(option) {
				case 1:
					say("Thank you kind person for your deed.");
					Game.print("The skeleton man seems to give you a smile of gratitude through his bony jaws.");
					Game.getConditions().add("sTalked1");
					break;
			
				case 2:
					say("Well, I do need my beauty rest. Don't get so overjoyed by your own actions.");
					Game.print("The skeleton man begins to lie back down into his grave.");
					Game.getConditions().add("sTalked1");
					break;
			}
		}
	}
}
