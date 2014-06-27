import java.util.Random;
import java.util.Scanner;

import grid.Location;
import actor.*;

public class Runner {
	private static Random rand = new Random();
	
	public static void main(String[] args) {		
		new Runner();
	}
	
	public Runner() {
		ActorWorld world = new ActorWorld();
		
		for(int i = 0; i < 20; i++) {
			world.add(new Rock());
		}
		
		for(int i = 0; i < 10; i++) {
			Actor newActor = new Actor();
			newActor.setDirection(rand.nextInt(8));
			world.add(newActor);
			world.add(new Bug());
		}
		
		Scanner scan = new Scanner(System.in);
		while(true) {
			scan.nextLine();
			world.step();
			world.show();
		}
	}
}
