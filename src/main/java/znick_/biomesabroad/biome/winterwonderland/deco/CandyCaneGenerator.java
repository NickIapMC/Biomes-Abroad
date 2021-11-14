package znick_.biomesabroad.biome.winterwonderland.deco;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import znick_.biomesabroad.block.BiomesAbroadBlocks;

public class CandyCaneGenerator extends WorldGenerator {

	@Override
	public boolean generate(World world, Random rand, int x, int y, int z) {
		if (world.getBlock(x, y - 1, z) != null) {
			if (BiomesAbroadBlocks.CANDY_CANE_BLOCK.canPlaceBlockAt(world, x, y, z) && world.getBlock(x, y - 1, z) == Blocks.snow) {
				for (int i = 0; i < 5; i++) world.setBlock(x, y + i, z, BiomesAbroadBlocks.CANDY_CANE_BLOCK, 0, 3);		
			}
		}

		return true;
	}

}
