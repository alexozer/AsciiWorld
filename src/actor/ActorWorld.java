package actor;

import java.util.ArrayList;

import grid.Location;
import resources.Color;
import world.World;

public class ActorWorld extends World<Actor> {
	
	private static final int DEFAULT_COLOR = Color.darkCyan;
	
	public void add(Location loc, Actor actor) {
		actor.putSelfInGrid(getGrid(), loc);
	}

	public void show() {
		printGridHorizLine('╔', '═', '╤', '╗');
		printGridRows();
		printGridHorizLine('╚', '═', '╧', '╝');
	}
	
	private void printGridRows() {
		for(int row = 0; row < getGrid().getNumRows();  row++) {
			
			// Print first text row
			// Needs some mad cleanup, aka just check if there's an actor there once
			String charRow = "║";
			for(int col = 0; col < getGrid().getNumCols(); col++) {
				Actor currActor = getGrid().get(new Location(row, col));
				if(currActor != null) {
					 if(currActor.getDirection() == Location.NORTH) {
						 charRow += "    ▲";
					 } else if(currActor.getDirection() == Location.NORTHWEST) {
						 charRow += "◤    ";
					 } else charRow += "     ";
				} else charRow += "     ";
				charRow += "   ";
				
				if(currActor != null && currActor.getDirection() == Location.NORTHEAST) {
					charRow += '◥';
				} else charRow += ' ';
				
				if(col != getGrid().getNumCols() - 1) {
					charRow += '│';
				} else charRow += '║';	
			}
			System.out.println(Color.colorize(charRow, DEFAULT_COLOR));
			
			// Print second text row
			charRow = Color.colorize("║", DEFAULT_COLOR);
			for(int col = 0; col < getGrid().getNumCols(); col++) {
				String part1 = " ", part2 = "", part3 = "";
				
				Actor currActor = getGrid().get(new Location(row, col));
				if(currActor != null) {
					String imagePt1 = currActor.getImage()[0].substring(0, 7);
					part2 = Color.colorize(imagePt1, currActor.getColor());
					if(currActor.getDirection() == Location.EAST) {
						part3 += '▶';
					} else part3 += ' ';
				} else part1 += "        ";
								
				if(col != getGrid().getNumCols() - 1) {
					part3 += '│';
				} else part3 += '║';
				
				charRow += Color.colorize(part1, DEFAULT_COLOR) + 
						part2 +
						Color.colorize(part3, DEFAULT_COLOR);
			}
			System.out.println(charRow);

			// Print third text row
			charRow = Color.colorize("║", DEFAULT_COLOR);
			
			for(int col = 0; col < getGrid().getNumCols(); col++) {
				String part1 = "", part2 = "", part3 = "";
				Actor currActor = getGrid().get(new Location(row, col));
				if(currActor != null) {
					if(currActor.getDirection() == Location.WEST) {
						part1 += '◀';
					} else part1 += ' ';
					part2 += currActor.getImage()[1].substring(0, 7) + ' ';
					part2 = Color.colorize(part2, currActor.getColor());
				} else part1 += "         ";
								
				if(col != getGrid().getNumCols() - 1) {
					part3 += '│';
				} else part3 += '║';
				
				charRow += Color.colorize(part1, DEFAULT_COLOR) + 
						part2 +
						Color.colorize(part3, DEFAULT_COLOR);
			}
			System.out.println(charRow);
			
			// Print fourth text row
			charRow = "║";
			for(int col = 0; col < getGrid().getNumCols(); col++) {
				Actor currActor = getGrid().get(new Location(row, col));
				if(currActor != null) {
					 if(currActor.getDirection() == Location.SOUTH) {
						 charRow += "    ▼";
					 } else if(currActor.getDirection() == Location.SOUTHWEST) {
						 charRow += "◣    ";
					 } else charRow += "     ";
				} else charRow += "     ";
				charRow += "   ";
				
				if(currActor != null && currActor.getDirection() == Location.SOUTHEAST) {
					charRow += '◢';
				} else charRow += ' ';
				
				if(col != getGrid().getNumCols() - 1) {
					charRow += '│';
				} else charRow += '║';	
			}
			System.out.println(Color.colorize(charRow, DEFAULT_COLOR));
			
			if(row != getGrid().getNumRows() - 1) {
				printGridHorizLine('╟', '─', '┼', '╢');
			}
		}
	}
	
	private void printGridHorizLine(char first, char straight, char separator, char last) {
		String line = "" + first;
		for(int col = 0; col < getGrid().getNumCols(); col++) {
			for(int i = 0; i < 9; i++) line += straight;
			if(col != getGrid().getNumCols() - 1) {
				line += separator;
			}
		}
		line += last;
		System.out.println(Color.colorize(line, DEFAULT_COLOR));
	}

	public void step() {
		for(int row = 0; row < getGrid().getNumRows(); row++) {
			for(int col = 0; col < getGrid().getNumCols(); col++) {
				Actor currActor = getGrid().get(new Location(row, col));
				if(currActor != null) {
					currActor.act();
				}
			}
		}
	}

}
