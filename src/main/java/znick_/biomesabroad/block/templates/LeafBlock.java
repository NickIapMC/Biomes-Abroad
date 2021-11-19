package znick_.biomesabroad.block.templates;

import java.util.Random;

import javax.annotation.Nonnull;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import znick_.biomesabroad.block.BasicBlock;

/**
 * Class for creating leaf blocks. Leaf blocks have with a hardness of 0.2 and use the vanilla leaves material.
 * They have 0 break time and use the grass sound. If a leaf block is not nearby its wood, it will decay, if it is
 * set to do so.
 * 
 * @author zNick_
 */
public class LeafBlock extends BasicBlock {

	private final double saplingChance;
	private final Item saplingItem;
	private final Block log;
	
	/**
	 * Creates a new leaf block with the given properties. The leaf block will decay if it is too far from any
	 * log blocks.
	 * 
	 * @param name The name of the block; also used to set its texture
	 * @param category The folder where the texture is located
	 * @param saplingItem The sapling item to drop
	 * @param wood The type of wood the leaf is connected to
	 * @param saplingChance The percent chance that a sapling will drop when a leaf block decays
	 */
	public LeafBlock(String name, String category, Item saplingItem, @Nonnull Block wood, double saplingChance) {
		super(name, category, 0.2F, Material.leaves, Block.soundTypeGrass, 0, false, false);
		this.setTickRandomly(true);
		this.saplingChance = saplingChance;
		this.saplingItem = saplingItem;
		this.log = wood;
	}
	
	/**
	 * Creates a new leaf block with the given properties. it will not decay.
	 * 
	 * @param name The name of the block; also used to set its texture
	 * @param category The folder where the texture is located
	 */
	public LeafBlock(String name, String category) {
		super(name, category, 0.2F, Material.leaves, Block.soundTypeGrass, 0, false, false);
		this.setTickRandomly(false);
		this.log = null;
		this.saplingItem = null;
		this.saplingChance = 0;
		this.setCreativeTab(null);
	}
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random rand) {
		if (this.log == null) return;
		if (!this.hasWoodInRadius(world, x, y, z, 5)) this.decay(world, x, y, z, rand, false);
	}
	
	/**
	 * Decays the leaf block, with a chance to drop a sapling.
	 * 
	 * @param world The world the leaf block is in
	 * @param x The x-coordinate of the block
	 * @param y The y-coordinate of the block
	 * @param z The z-coordiante of the block
	 * @param rand The random instance to use
	 */
	public void decay(World world, int x, int y, int z, Random rand, boolean force) {
		if (this.log == null) return;
		world.setBlockToAir(x, y, z);
		if (rand.nextDouble() < this.saplingChance) world.spawnEntityInWorld(new EntityItem(world, x, y, z, new ItemStack(this.saplingItem)));
	}
	
	/**
	 * Checks whether or not the leaf has a log block nearby. Used to determine if it should decay.
	 * 
	 * @param world The world the leaf block is in
	 * @param x The x-coordinate of the block
	 * @param y The y-coordinate of the block
	 * @param z The z-coordiante of the block
	 * @param r The radius around the leaf block to check for logs
	 * 
	 * @return {@code true} if there is a log in the {@code (2r + 1) x (2r + 1)} cube around the block, {@code false}
	 * otherwise.
	 */
	private boolean hasWoodInRadius(World world, int x, int y, int z, int r) {
		for (int i = x - r; i <= x + r; i++) {
			for (int j = y - r; j <= y + r; j++) {
				for (int k = z - r; k <= z + r; k++) {
					if (world.getBlock(i, j, k) == this.log) return true;
				}
			}
		}
		return false;
	}

}
