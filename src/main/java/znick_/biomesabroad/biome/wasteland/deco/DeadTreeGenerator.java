package znick_.biomesabroad.biome.wasteland.deco;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import znick_.biomesabroad.biome.wasteland.WastelandBiome;
import znick_.biomesabroad.block.BiomesAbroadBlocks;
import znick_.biomesabroad.world.gen.Structure;

public class DeadTreeGenerator implements Structure {

	@Override
	public void generate(World world, int x, int y, int z) {
		for (int i = 0; i < 5; i++) {
			world.setBlock(x, y + i, z, BiomesAbroadBlocks.DEAD_LOG, 0, 3);
		}

		world.setBlock(x, y + 5, z, BiomesAbroadBlocks.DEAD_LEAVES, 0, 3);
		world.setBlock(x, y + 6, z, BiomesAbroadBlocks.DEAD_LEAVES, 0, 3);

		world.setBlock(x + 1, y + 3, z, BiomesAbroadBlocks.DEAD_LEAVES, 0, 3);
		world.setBlock(x + 1, y + 4, z, BiomesAbroadBlocks.DEAD_LEAVES, 0, 3);

		world.setBlock(x - 1, y + 3, z, BiomesAbroadBlocks.DEAD_LEAVES, 0, 3);
		world.setBlock(x - 1, y + 4, z, BiomesAbroadBlocks.DEAD_LEAVES, 0, 3);

		world.setBlock(x, y + 3, z + 1, BiomesAbroadBlocks.DEAD_LEAVES, 0, 3);
		world.setBlock(x, y + 4, z + 1, BiomesAbroadBlocks.DEAD_LEAVES, 0, 3);

		world.setBlock(x, y + 3, z - 1, BiomesAbroadBlocks.DEAD_LEAVES, 0, 3);
		world.setBlock(x, y + 4, z - 1, BiomesAbroadBlocks.DEAD_LEAVES, 0, 3);
	}

	@Override
	public boolean canGenerateAt(World world, int x, int y, int z) {
		if (world.getBlock(x, y, z) == null) return false;
		if (!BiomesAbroadBlocks.DEAD_LOG.canPlaceBlockAt(world, x, y, z)) return false;
		if (world.getBlock(x, y - 1, z) != BiomesAbroadBlocks.DEAD_GRASS) return false;
		return true;
	}

}