package znick_.biomesabroad.biome.cartoonhills.deco;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import znick_.biomesabroad.biome.wasteland.WastelandBiome;
import znick_.biomesabroad.block.BiomesAbroadBlocks;
import znick_.biomesabroad.world.gen.Structure;

public class CartoonTreeGenerator implements Structure {

	@Override
	public void generate(World world, int x, int y, int z) {	
		for (int i = 0; i < 5; i++) world.setBlock(x, y + i, z, BiomesAbroadBlocks.CARTOON_LOG, 0, 3);

		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				world.setBlock(x + i, y + 5, z + j, BiomesAbroadBlocks.CARTOON_LEAVES, 0, 3);
			}
		}

		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				if (!(i == 0 && j == 0))
					world.setBlock(x + i, y + 4, z + j, BiomesAbroadBlocks.CARTOON_LEAVES, 0, 3);
			}
		}

		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				if (!(i == 0 && j == 0))
					world.setBlock(x + i, y + 3, z + j, BiomesAbroadBlocks.CARTOON_LEAVES, 0, 3);
			}
		}
	}

	@Override
	public boolean canGenerateAt(World world, int x, int y, int z) {
		if (world.getBlock(x, y - 1, z) == null) return false;
		if (!BiomesAbroadBlocks.CARTOON_LOG.canPlaceBlockAt(world, x, y, z)) return false;
		if (world.getBlock(x, y - 1, z) != BiomesAbroadBlocks.CARTOON_GRASS) return false;
		return true;
	}

}