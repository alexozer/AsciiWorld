package grid;

public class Location {
	private int row, col;
	
	public static final int NORTH = 0, NORTHEAST = 1, EAST = 2, SOUTHEAST = 3,
			SOUTH = 4, SOUTHWEST = 5, WEST = 6, NORTHWEST = 7;
	
	public Location(int r, int c) {
		row = r;
		col = c;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}
	
	public Location getAdjacentLocation(int direction) {		
		switch(direction) {
		case NORTH: return new Location(getRow() - 1, getCol());
		case NORTHEAST: return new Location(getRow() - 1, getCol() + 1);
		case EAST: return new Location(getRow(), getCol() + 1);
		case SOUTHEAST: return new Location(getRow() + 1, getCol() + 1);
		case SOUTH: return new Location(getRow() + 1, getCol());
		case SOUTHWEST: return new Location(getRow() + 1, getCol() - 1);
		case WEST: return new Location(getRow(), getCol() - 1);
		case NORTHWEST: return new Location(getRow() - 1, getCol() - 1);
		default: return null;
		}
	}
}
