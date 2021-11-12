package znick_.biomesabroad.biome.wasteland.deco;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import znick_.biomesabroad.biome.wasteland.Wasteland;
import znick_.biomesabroad.registry.BiomesAbroadBlocks;

public class DeadTreeGenerator extends WorldGenerator {

	public boolean generate(World world, Random rand, int x, int y, int z) {

		if (BiomesAbroadBlocks.blockDeadLog.canPlaceBlockAt(world, x, y, z) && world.getBlock(x, y - 1, z) == BiomesAbroadBlocks.blockDeadGrass) {
			this.makeTree(world, x, y, z);
		}

		return true;
	}

	public void makeTree(World world, int x, int y, int z) {

		for (int i = 0; i < 5; i++) {
			world.setBlock(x, y + i, z, BiomesAbroadBlocks.blockDeadLog, 0, 3);
		}

		world.setBlock(x, y + 5, z, BiomesAbroadBlocks.blockDeadLeaves, 0, 3);
		world.setBlock(x, y + 6, z, BiomesAbroadBlocks.blockDeadLeaves, 0, 3);

		world.setBlock(x + 1, y + 3, z, BiomesAbroadBlocks.blockDeadLeaves, 0, 3);
		world.setBlock(x + 1, y + 4, z, BiomesAbroadBlocks.blockDeadLeaves, 0, 3);

		world.setBlock(x - 1, y + 3, z, BiomesAbroadBlocks.blockDeadLeaves, 0, 3);
		world.setBlock(x - 1, y + 4, z, BiomesAbroadBlocks.blockDeadLeaves, 0, 3);

		world.setBlock(x, y + 3, z + 1, BiomesAbroadBlocks.blockDeadLeaves, 0, 3);
		world.setBlock(x, y + 4, z + 1, BiomesAbroadBlocks.blockDeadLeaves, 0, 3);

		world.setBlock(x, y + 3, z - 1, BiomesAbroadBlocks.blockDeadLeaves, 0, 3);
		world.setBlock(x, y + 4, z - 1, BiomesAbroadBlocks.blockDeadLeaves, 0, 3);
	}

}