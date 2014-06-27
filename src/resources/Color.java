package resources;

public class Color {
	public static final int
			lightRed = 91, darkRed = 31,
			lightYellow = 93, darkYellow = 33,
			lightBlue = 94, darkBlue = 34,
			lightPurple = 95, darkPurple = 35,
			lightGreen = 92, darkGreen = 32,
			lightCyan = 96, darkCyan = 36,
			grey = 37;
	
	public static String colorize(String str, int color) {
		return "\u001b[1;" + color + "m" + str + "\u001b[0m";
	}
}
