package znick_.biomesabroad.biome.lushgarden.deco;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import znick_.biomesabroad.world.gen.Structure;

public class TorchGenerator implements Structure {

	@Override
	public void generate(World world, int x, int y, int z) {
		world.setBlock(x, y, z, Blocks.fence, 0, 3);
		world.setBlock(x, y + 1, z, Blocks.torch, 0, 3);
	}

	@Override
	public boolean canGenerateAt(World world, int x, int y, int z) {
		if (world.getBlock(x, y - 1, z) == null) return false;
		if (!Blocks.fence.canPlaceBlockAt(world, x, y, z)) return false;
		if (world.getBlock(x, y - 1, z) != Blocks.grass) return false;
		return true;
	}

}
