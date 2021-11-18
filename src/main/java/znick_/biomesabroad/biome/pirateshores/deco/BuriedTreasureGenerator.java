package znick_.biomesabroad.biome.pirateshores.deco;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import znick_.biomesabroad.world.gen.Structure;

public class BuriedTreasureGenerator implements Structure {

	@Override
	public void generate(World world, int x, int y, int z) {
		world.setBlock(x, y, z, Blocks.wool, 14, 3);
		
		world.setBlock(x + 1, y, z + 1, Blocks.wool, 14, 3);
		world.setBlock(x - 1, y, z + 1, Blocks.wool, 14, 3);
		world.setBlock(x + 1, y, z - 1, Blocks.wool, 14, 3);
		world.setBlock(x - 1, y, z - 1, Blocks.wool, 14, 3);
		
		world.setBlock(x + 2, y, z + 2, Blocks.wool, 14, 3);
		world.setBlock(x - 2, y, z + 2, Blocks.wool, 14, 3);
		world.setBlock(x + 2, y, z - 2, Blocks.wool, 14, 3);
		world.setBlock(x - 2, y, z - 2, Blocks.wool, 14, 3);
		
		world.setBlock(x, y - 1, z, Blocks.gold_block, 0, 3);
		world.setBlock(x + 1, y - 1, z, Blocks.gold_block, 0, 3);
		world.setBlock(x - 1, y - 1, z, Blocks.gold_block, 0, 3);
		world.setBlock(x, y - 1, z + 1, Blocks.gold_block, 0, 3);
		world.setBlock(x, y - 1, z - 1, Blocks.gold_block, 0, 3);
	}

	@Override
	public boolean canGenerateAt(World world, int x, int y, int z) {
		if (world.getBlock(x, y - 1, z) == null) return false;
		if (!Blocks.wool.canPlaceBlockAt(world, x, y, z)) return false;
		if (world.getBlock(x, y - 1, z) != Blocks.sand) return false;
		return true;
	}

}