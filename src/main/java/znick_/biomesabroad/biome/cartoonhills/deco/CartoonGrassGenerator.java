package znick_.biomesabroad.biome.cartoonhills.deco;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import znick_.biomesabroad.biome.wasteland.Wasteland;
import znick_.biomesabroad.util.registry.BiomesAbroadBlocks;

public class CartoonGrassGenerator extends WorldGenerator {
	
	public boolean generate(World world, Random rand, int x, int y, int z) {

		if (world.getBlock(x, y - 1, z) != null) {
			if (BiomesAbroadBlocks.CARTOON_GRASS_PLANT.canPlaceBlockAt(world, x, y, z) && world.getBlock(x, y - 1, z) == BiomesAbroadBlocks.CARTOON_GRASS) {
				world.setBlock(x, y, z, BiomesAbroadBlocks.CARTOON_GRASS_PLANT, 0, 3);
			}
		}

		return true;
	}

}