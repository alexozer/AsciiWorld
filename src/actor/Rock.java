package actor;

import resources.Color;

public class Rock extends Actor {	
	public Rock() {
		setColor(Color.darkYellow);
		setImage(new String[]{
				" /###\\ ",
				" |###| ",
		});
		setDirection(-1);
	}
	
	public void act() {};
}
