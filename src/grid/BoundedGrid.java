package grid;

import java.util.ArrayList;

public class BoundedGrid<E> implements Grid<E> {
	private Object[][] grid;
	
	public BoundedGrid(int rows, int cols) {
		grid = new Object[rows][cols];
	}

	public int getNumRows() {
		return grid.length;
	}

	
	public int getNumCols() {
		return grid[0].length;
	}

	
	public boolean isValid(Location loc) {
		return loc != null &&
				loc.getRow() < getNumRows() && loc.getRow() >= 0 &&
				loc.getCol() < getNumCols() && loc.getCol() >= 0;
	}

	
	@SuppressWarnings("unchecked")
	public E get(Location loc) {
		if(!isValid(loc)) {
			return null;
		}
		
		return (E)grid[loc.getRow()][loc.getCol()];
	}

	
	public E put(Location loc, E obj) {
		if(!isValid(loc)) {
			return null;
		}
		
		E oldObj = get(loc);
		grid[loc.getRow()][loc.getCol()] = obj;
		
		return oldObj;
	}

	public E remove(Location loc) {
		return put(loc, null);
	}

	
	public ArrayList<Location> getOccupiedLocations() {
		return getLocations(true);
	}
	
	public ArrayList<Location> getEmptyLocations() {
		return getLocations(false);
	}
	
	private ArrayList<Location> getLocations(boolean wantOccupied) {
		ArrayList<Location> locs = new ArrayList<Location>();
		for(int row = 0; row < getNumRows(); row++) {
			for(int col = 0; col < getNumCols(); col++) {
				Location loc = new Location(row, col);
				if((get(loc) != null) == wantOccupied) {
					locs.add(loc);
				}
			}
		}
		
		return locs;
	}
}
