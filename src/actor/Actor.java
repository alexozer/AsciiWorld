package actor;

import resources.Color;
import grid.Grid;
import grid.Location;

public class Actor {
	public Actor() {
		setColor(Color.lightBlue);
	}
	private Grid<Actor> grid;
	
	public Grid<Actor> getGrid() {
		return grid;
	}
		
	private Location location;
	
	public Location getLocation() {
		return location;
	}
	
	// image is a 2 by 7 character representation of the actor
	private String[] image = new String[] {
		"(*) (*)",
		"  <o>  ",
	};
	
	public String[] getImage() {
		return image;
	}
	
	public void setImage(String[] img) {
		image = img;
	}
	
	private int direction = Location.NORTH;
	
	public int getDirection() {
		return direction;
	}
	
	public void setDirection(int dir) {
		direction = dir;
	}
	
	private int color;
	
	public int getColor() {
		return color;
	}
	
	public void setColor(int col) {
		color = col;
	}
	
	public void act() {
		direction = (direction + 4) % 8;
	}
	
	public void putSelfInGrid(Grid<Actor> gr, Location loc) {
		if(!gr.isValid(loc)) return;
		
		if(grid != null) removeSelfFromGrid();
		
		gr.put(loc, this);
		grid = gr;
		location = loc;
	}
	
	public void removeSelfFromGrid() {
		if(getGrid() == null || getLocation() == null) return;
		grid.remove(location);
		location = null;
	}
	
	public void moveTo(Location newLocation) {
		removeSelfFromGrid();
		
		putSelfInGrid(grid, newLocation);
	}
}
