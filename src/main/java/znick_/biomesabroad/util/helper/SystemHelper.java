package znick_.biomesabroad.util.helper;

import java.io.IOException;
import java.net.JarURLConnection;

import znick_.biomesabroad.BiomesAbroad;

public class SystemHelper {

	/**
	 * Returns whether or not the game is running in a development environment as opposed to being run as a jar file
	 * in-game.
	 */
	public static boolean isRunningInIDE() {
		return !BiomesAbroad.class.getResource("BiomesAbroad.class").toString().startsWith("jar");
	}
}
