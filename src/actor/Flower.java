package actor;

import resources.Color;

public class Flower extends Actor {
	public Flower() {
		setColor(Color.lightPurple);
		setImage(new String[]{
				"  ~O~  ",
				"  /|\\  ",
		});
	}
	
	private int runs = 0;
	public void act() {
		runs++;
		if(runs == 5) {
			setColor(Color.grey);
		}
	};
}
