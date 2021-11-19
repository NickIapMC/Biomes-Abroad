package znick_.biomesabroad.block.templates;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import znick_.biomesabroad.block.BasicBlock;

/**
 * Class for creating custom grass blocks. Grass blocks can be bonemealed to grow grass or flowers, and spreads.
 * Both of these features can be disabled. Grass blocks are multitextured and opaque, and give off no light.
 * They have a hardness of 0.6 and use the vanilla grass material and sound.
 * 
 * @author zNick_
 */
public class GrassBlock extends BasicBlock implements IGrowable {
	
	/**The dirt block that this grass block can spread and grow over*/
	private final Block dirt;
	/**Whether or not this grass can spread and be bonemealed*/
	private final boolean spreadable;
	/**The flowers that this grass block will grow when bonemealed*/
	private final Block[] flowers;
	
	/**
	 * Creates a new grass block with the specified properties. The grass is spreadable and can be bonemealed.
	 * 
	 * @param name The name of the block; also used to set its texture
	 * @param category The folder that contains the texture
	 * @param dirt The dirt block that the grass can spread over
	 * @param flowers The flowers that can be grown from bonemeal
	 */
	public GrassBlock(String name, String category, Block dirt, Block... flowers) {
		super(name, category, 0.6F, Material.grass, Block.soundTypeGrass, 0, true, true);
		this.setTickRandomly(true);
		this.spreadable = true;
		this.dirt = dirt;
		this.flowers = flowers != null? flowers : new Block[0];
	}
	

	/**
	 * Creates a new grass block with the specified properties. The grass is not spreadable and cannoot be bonemealed.
	 * 
	 * @param name The name of the block; also used to set its texture
	 * @param category The folder that contains the texture
	 */
	public GrassBlock(String name, String category) {
		super(name, category, 0.6F, Material.grass, Block.soundTypeGrass, 0, true, true);
		this.setTickRandomly(true);
		this.spreadable = false;
		this.dirt = null;
		this.flowers = null;
	}

	/**
	 * Ticks the block if it's been scheduled. Checks blocks around it for dirt to attempt to spread and grow
	 * grass over it.
	 * 
	 * @param world The world the block is in
	 * @param x The x-coordinate of the grass block
	 * @param y The y-coordinate of the grass block
	 * @param z The z-coordinate of the grass block
	 * @param rand The random instance to use
	 */
	@Override
	public void updateTick(World world, int x, int y, int z, Random rand) {
		if (!this.spreadable) return;
		if (!world.isRemote) {
			if (world.getBlockLightValue(x, y + 1, z) < 4 && world.getBlockLightOpacity(x, y + 1, z) > 2) {
				world.setBlock(x, y, z, this.dirt);
			} else if (world.getBlockLightValue(x, y + 1, z) >= 9) {
				for (int l = 0; l < 4; ++l) {
					int i1 = x + rand.nextInt(3) - 1;
					int j1 = y + rand.nextInt(5) - 3;
					int k1 = z + rand.nextInt(3) - 1;
					Block block = world.getBlock(i1, j1 + 1, k1);

					if (world.getBlock(i1, j1, k1) == this.dirt && 
						world.getBlockMetadata(i1, j1, k1) == 0 && 
						world.getBlockLightValue(i1, j1 + 1, k1) >= 4 && 
						world.getBlockLightOpacity(i1, j1 + 1, k1) <= 2 &&
						world.getBlock(i1, j1 + 1, k1) == Blocks.air) {
						world.setBlock(i1, j1, k1, this);
					}
				}
			}
		}
	}
	
	@Override
	public Item getItemDropped(int meta, Random rand, int side) {
        if (!this.spreadable) return super.getItemDropped(meta, rand, side);
        return this.dirt.getItemDropped(0, rand, side);
    }

	@Override //canBonemeal()
	public boolean func_149851_a(World world, int x, int y, int z, boolean bool) {
		return this.spreadable;
	}

	@Override //shouldGrow()
	public boolean func_149852_a(World world, Random rand, int x, int y, int z) {
		return this.spreadable;
	}

	@Override //growGrass()
	public void func_149853_b(World world, Random rand, int x, int y, int z) {
		for (int i = x - 2; i <= x + 2; i++) {
			for (int j = z - 2; j <= z + 2; j++) {
				for (int k = y - 2; k <= y + 2; k++) {
					if (world.getBlock(i, k - 1, j) == this && world.getBlock(i, k, j) == Blocks.air) {
						world.setBlock(i, k, j, this.flowers[rand.nextInt(this.flowers.length)]);
						break;
					}
				}
			}
		}
	}
}
