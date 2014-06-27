package world;

import java.util.ArrayList;
import java.util.Random;

import grid.BoundedGrid;
import grid.Grid;
import grid.Location;

public abstract class World<T> {
	private static final int DEFAULT_ROWS = 10;
	private static final int DEFAULT_COLS = 10;
	
	private static Random rand = new Random();
	
	private Grid<T> grid;
	
	public World() {
		this(new BoundedGrid<T>(DEFAULT_ROWS, DEFAULT_COLS));
	};
	
	public World(Grid<T> g) {
		grid = g;
	}
	
	public Grid<T> getGrid() {
		return grid;
	}
	
	public void remove(Location loc) {
		grid.remove(loc);
	}
	
	public void add(T obj) {
		ArrayList<Location> emptyLocs = grid.getEmptyLocations();
		if(emptyLocs.size() == 0) return;
		Location randomLoc = emptyLocs.get(rand.nextInt(emptyLocs.size()));
		add(randomLoc, obj);
	}
	
	public void add(Location loc, T obj) {
		grid.put(loc, obj);
	}
	
	public abstract void show();
	public abstract void step();
}
