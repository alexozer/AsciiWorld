package actor;

import grid.Location;
import resources.Color;

public class Bug extends Actor {
	public Bug() {
		setColor(Color.lightRed);
		setImage(new String[]{
				" -[.]-- ",
				" /[@]\\ ",
		});
	}
	
	public void act() {
		if(canMove()) {
			move();
		} else {
			turn();
		}
	}
	
	public boolean canMove() {
		Location moveLoc = getLocation().getAdjacentLocation(getDirection());
		if(!getGrid().isValid(moveLoc)) return false;
		
		Actor currActor = getGrid().get(moveLoc);
		return (currActor == null || currActor instanceof Flower);
	}
	
	public void move() {
		Location oldLoc = getLocation();
		Location moveLoc = oldLoc.getAdjacentLocation(getDirection());
		moveTo(moveLoc);
		new Flower().putSelfInGrid(getGrid(), oldLoc);
	}
	
	public void turn() {
		setDirection((getDirection() + 1) % 8);
	}
}
