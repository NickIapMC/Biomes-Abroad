package znick_.biomesabroad.biome.cartoonhills.deco;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import znick_.biomesabroad.biome.wasteland.Wasteland;
import znick_.biomesabroad.registry.BiomesAbroadBlocks;

public class CartoonGrassGenerator extends WorldGenerator {
	
	public boolean generate(World world, Random rand, int x, int y, int z) {

		if (world.getBlock(x, y - 1, z) != null) {
			if (BiomesAbroadBlocks.plantCartoonGrass.canPlaceBlockAt(world, x, y, z) && world.getBlock(x, y - 1, z) == BiomesAbroadBlocks.blockCartoonGrass) {
				world.setBlock(x, y, z, BiomesAbroadBlocks.plantCartoonGrass, 0, 3);
			}
		}

		return true;
	}

}