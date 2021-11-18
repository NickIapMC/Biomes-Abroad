package znick_.biomesabroad.biome.winterwonderland.deco;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import znick_.biomesabroad.world.gen.Structure;

public class IceTreeGenerator implements Structure {

	@Override
	public void generate(World world, int x, int y, int z) {
		for (int i = 0; i < 5; i++) {
			world.setBlock(x, y + i, z, Blocks.packed_ice, 0, 3);
		}
		
		for (int i = -2; i <= 2; i++) {
			for (int j = -2; j <= 2; j++) {
				if (!(i == 0 && j == 0))  {
					world.setBlock(x + i, y + 3, z + j, Blocks.ice, 0, 3);
					world.setBlock(x + i, y + 4, z + j, Blocks.ice, 0, 3);
				}
			}
		}
		
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				world.setBlock(x + i, y + 5, z + j, Blocks.ice, 0, 3);
			}
		}
		
		world.setBlock(x, y + 6, z, Blocks.ice, 0, 3);
		world.setBlock(x + 1, y + 6, z, Blocks.ice, 0, 3);
		world.setBlock(x - 1, y + 6, z, Blocks.ice, 0, 3);
		world.setBlock(x, y + 6, z + 1, Blocks.ice, 0, 3);
		world.setBlock(x, y + 6, z - 1, Blocks.ice, 0, 3);
	}

	@Override
	public boolean canGenerateAt(World world, int x, int y, int z) {
		if (world.getBlock(x, y - 1, z) == null) return false;
		if (!Blocks.ice.canPlaceBlockAt(world, x, y, z)) return false;
		if (world.getBlock(x, y - 1, z) != Blocks.snow) return false;
		return true;
	}

}
