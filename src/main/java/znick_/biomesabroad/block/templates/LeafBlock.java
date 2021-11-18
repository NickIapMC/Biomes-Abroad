package znick_.biomesabroad.block.templates;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import znick_.biomesabroad.block.BasicBlock;

public class LeafBlock extends BasicBlock {

	private final double saplingChance;
	private final Item saplingItem;
	
	/**
	 * Creates a new leaf block with the given properties.
	 * 
	 * @param name The name of the block; also used to set its texture
	 * @param category The folder where the texture is located
	 * @param saplingItem The sapling item to drop
	 * @param wood The type of wood the leaf is connected to
	 * @param saplingChance The percent chance that a sapling will drop when a leaf block decays
	 */
	public LeafBlock(String name, String category, Item saplingItem, Block wood, double saplingChance) {
		super(name, category, 0.2F, Material.leaves, Block.soundTypeGrass, 0, false, false);
		this.setTickRandomly(true);
		this.saplingChance = saplingChance;
		this.saplingItem = saplingItem;
	}
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random rand) {
		if (!this.hasWoodInRadius(x, y, z, 10)) {
			world.setBlockToAir(x, y, z);
			if (rand.nextDouble() < this.saplingChance) world.spawnEntityInWorld(new EntityItem(world, x, y, z, new ItemStack(this.saplingItem)));
		}
	}
	
	private boolean hasWoodInRadius(int x, int y, int z, int radius) {
		return true; //TODO: Wood Check
	}

}
