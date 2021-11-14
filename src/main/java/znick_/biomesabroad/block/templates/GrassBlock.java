package znick_.biomesabroad.block.templates;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import znick_.biomesabroad.block.BasicBlock;

public class GrassBlock extends BasicBlock implements IGrowable {
	
	private final Block dirt;
	private final boolean spreadable;
	
	public GrassBlock(String name, String category, Block dirt) {
		super(name, category, 0.6F, Material.grass, Block.soundTypeGrass, 0, true, true);
		this.dirt = dirt;
		this.setTickRandomly(true);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.spreadable = true;
	}
	
	public GrassBlock(String name, String category) {
		super(name, category, 0.6F, Material.grass, Block.soundTypeGrass, 0, true, true);
		this.setTickRandomly(true);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.spreadable = false;
		this.dirt = null;
	}

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
						world.getBlockLightOpacity(i1, j1 + 1, k1) <= 2) {
						world.setBlock(i1, j1, k1, this);
					}
				}
			}
		}
	}

	@Override
	public boolean func_149851_a(World world, int x, int y, int z, boolean bool) {
		return this.spreadable;
	}

	@Override
	public boolean func_149852_a(World world, Random rand, int x, int y, int z) {
		return this.spreadable;
	}

	@Override
	public void func_149853_b(World world, Random rand, int x, int y, int z) {

	}
}
