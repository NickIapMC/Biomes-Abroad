package znick_.biomesabroad.biome.pirateshores.deco;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import znick_.biomesabroad.world.gen.Structure;

public class SandstoneSlabGenerator implements Structure {

	@Override
	public void generate(World world, int x, int y, int z) {
		world.setBlock(x, y, z, Blocks.stone_slab, 1, 3); 
	}

	@Override
	public boolean canGenerateAt(World world, int x, int y, int z) {
		if (world.getBlock(x, y - 1, z) == null) return false;
		if (!Blocks.stone_slab.canPlaceBlockAt(world, x, y, z)) return false;
		if (world.getBlock(x, y - 1, z) != Blocks.sand) return false;
		if (world.getBlock(x + 1, y, z) != Blocks.sand && world.getBlock(x - 1, y, z) != Blocks.sand && world.getBlock(x, y, z + 1) != Blocks.sand && world.getBlock(x, y, z - 1) != Blocks.sand) return false;
		return true;
	}
	
}
