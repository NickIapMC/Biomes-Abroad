package znick_.biomesabroad.biome.mushroomforest.deco;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import znick_.biomesabroad.block.BiomesAbroadBlocks;
import znick_.biomesabroad.world.gen.Structure;

public class MiniRedMushroomGenerator implements Structure {

	@Override
	public void generate(World world, int x, int y, int z) {
		world.setBlock(x, y, z, BiomesAbroadBlocks.MUSHROOM_STEM);
		world.setBlock(x, y + 1, z, BiomesAbroadBlocks.MUSHROOM_STEM);

		world.setBlock(x, y + 2, z, BiomesAbroadBlocks.RED_MUSHROOM_BLOCK);
		world.setBlock(x + 1, y + 1, z, BiomesAbroadBlocks.RED_MUSHROOM_BLOCK);
		world.setBlock(x - 1, y + 1, z, BiomesAbroadBlocks.RED_MUSHROOM_BLOCK);
		world.setBlock(x, y + 1, z + 1, BiomesAbroadBlocks.RED_MUSHROOM_BLOCK);
		world.setBlock(x, y + 1, z - 1, BiomesAbroadBlocks.RED_MUSHROOM_BLOCK);
	}

	@Override
	public boolean canGenerateAt(World world, int x, int y, int z) {
		if (world.getBlock(x, y - 1, z) == null) return false;
		if (!BiomesAbroadBlocks.MUSHROOM_STEM.canPlaceBlockAt(world, x, y, z)) return false;
		if (world.getBlock(x, y - 1, z) != Blocks.grass) return false;
		return true;
	}

}
