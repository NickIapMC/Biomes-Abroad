package znick_.biomesabroad.world.gen;

import net.minecraft.world.World;

public interface Structure {

	/**
	 * Attempts to generate the structure.
	 * 
	 * @param world The world to generate the structure in
	 * @param x The x-coordinate of the structure
	 * @param y The y-coordinate of the structure
	 * @param z The z-coordinate of the structure
	 */
	public abstract void generate(World world, int x, int y, int z);
	
	/**
	 * Returns whether or not the structure can validly generate at the given position in the given world.
	 * 
	 * @param world The world to generate the structure in
	 * @param x The x-coordinate of the structure
	 * @param y The y-coordinate of the structure
	 * @param z The z-coordinate of the structure
	 * @return
	 */
	public abstract boolean canGenerateAt(World world, int x, int y, int z);
}
