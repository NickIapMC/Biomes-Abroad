package znick_.biomesabroad.biome.lushgarden.deco;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import znick_.biomesabroad.util.registry.BiomesAbroadBlocks;

public class TorchGenerator extends WorldGenerator {

	@Override
	public boolean generate(World world, Random rand, int x, int y, int z) {
		if (world.getBlock(x, y - 1, z) != null) {
			if (Blocks.fence.canPlaceBlockAt(world, x, y, z) && world.getBlock(x, y - 1, z) == Blocks.grass) {
				world.setBlock(x, y, z, Blocks.fence, 0, 3);
				return true;
			}
		}

		return false;
	}

}
