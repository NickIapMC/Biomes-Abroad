package znick_.biomesabroad.biome.pirateshores.deco;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import znick_.biomesabroad.registry.BiomesAbroadBlocks;

public class SandstoneSlabGenerator extends WorldGenerator {

	public boolean generate(World world, Random rand, int x, int y, int z) {

		if (world.getBlock(x, y - 1, z) != null) {
			if (Blocks.stone_slab.canPlaceBlockAt(world, x, y, z) && world.getBlock(x, y - 1, z) == Blocks.sand) {
				if (world.getBlock(x + 1, y, z) == Blocks.sand || world.getBlock(x - 1, y, z) == Blocks.sand || world.getBlock(x, y, z + 1) == Blocks.sand || world.getBlock(x, y, z - 1) == Blocks.sand) {
					world.setBlock(x, y, z, Blocks.stone_slab, 1, 3); 
				}
			}
		}
 
		return true;
	}
	
}
