package grid;

import java.util.ArrayList;

public interface Grid<E> {
	int getNumRows();
	int getNumCols();
	
	boolean isValid(Location loc);
	E get(Location loc);
	E put(Location loc, E obj);
	E remove(Location loc);
	
	ArrayList<Location> getOccupiedLocations();
	ArrayList<Location> getEmptyLocations();
}
