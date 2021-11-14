package znick_.biomesabroad.biome.cypresscliffs.deco;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import znick_.biomesabroad.util.registry.BiomesAbroadBlocks;

public class CypressTreeGenerator extends WorldGenerator {

	@Override
	public boolean generate(World world, Random rand, int x, int y, int z) {
		if (world.getBlock(x, y - 1, z) != null) {
			if (Blocks.grass.canPlaceBlockAt(world, x, y, z) && world.getBlock(x, y - 1, z) == Blocks.grass) {
				int height = 50 + rand.nextInt(25);
				y += 20;
				
				for (int i = x - 3; i <= x + 3; i++) {
					for (int j = z - 3; j <= z + 3; j++) {
						for (int k = y; k < y + height/3; k++) {
							world.setBlock(i, k, j, Blocks.leaves, 0, 3);
						}
					}
				}
				
				for (int i = x - 2; i <= x + 2; i++) {
					for (int j = z - 2; j <= z + 2; j++) {
						for (int k = y + height/3; k < y + 2 * height/3; k++) {
							world.setBlock(i, k, j, Blocks.leaves, 0, 3);
						}
					}
				}
				
				for (int i = x - 1; i <= x + 1; i++) {
					for (int j = z - 1; j <= z + 1; j++) {
						for (int k = y + 2 * height/3; k < y + height; k++) {
							world.setBlock(i, k, j, Blocks.leaves, 0, 3);
						}
					}
				}
				
				for (int i = y - 50; i < y + height; i++) world.setBlock(x, i, z, Blocks.log, 0, 3);
				return true;
			}
		}

		return false;
	}

}
