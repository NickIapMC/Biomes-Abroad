package znick_.biomesabroad.block.templates;

import java.util.Random;

import net.minecraft.block.IGrowable;
import net.minecraft.world.World;
import znick_.biomesabroad.world.gen.Structure;

/**
 * Class for creating basic sapling blocks that can grow into trees.
 * 
 * @author zNick_
 */
public class SaplingBlock extends FlowerBlock implements IGrowable {

	/**The tree generator*/
	private final Structure treeGenerator;
	
	/**
	 * Creates a new sapling with the given properties.
	 * 
	 * @param name The name of the sapling block
	 * @param folder The location of the texture of the sapling
	 * @param treeGenerator The {@code Structure} to generate the tree
	 */
	public SaplingBlock(String name, String folder, Structure treeGenerator) {
		super(name, folder);
		this.treeGenerator = treeGenerator;
	}

	/**
	 * Returns whether or not this sapling can be bonemealed.
	 * 
	 * @param world The world the sapling is in
	 * @param x The x-coordinate of the sapling
	 * @param y The y-coordinate of the sapling
	 * @param z The z-coordinate of the sapling
	 * @param bool yeah i have no idea
	 */
	@Override //canBonemeal()
	public boolean func_149851_a(World world, int x, int y, int z, boolean bool) {
		return true;
	}
	
	/**
	 * Returns whether or not the sapling should grow into the tree at the given moment. Each time bonemeal is used
	 * there is a 25% chance by default to grow the tree.
	 * 
	 * @param world The world the sapling is in
	 * @param rand The random instance to use
	 * @param x The x-coordinate of the sapling
	 * @param y The y-coordinate of the sapling
	 * @param z The z-coordinate of the sapling
	 */
	@Override //shouldGrow()
	public boolean func_149852_a(World world, Random rand, int x, int y, int z) {
		return rand.nextFloat() < 0.25;
	}

	/**
	 * Grows the tree.
	 * 
	 * @param world The world the sapling is in
	 * @param rand The random instance to use
	 * @param x The x-coordinate of the sapling
	 * @param y The y-coordinate of the sapling
	 * @param z The z-coordinate of the sapling
	 */
	@Override //growTree()
	public void func_149853_b(World world, Random rand, int x, int y, int z) {
		this.treeGenerator.generate(world, x, y, z);
	}
}
