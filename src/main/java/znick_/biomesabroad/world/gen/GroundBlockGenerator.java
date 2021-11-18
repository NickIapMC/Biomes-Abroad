package znick_.biomesabroad.world.gen;

import net.minecraft.block.Block;
import net.minecraft.world.World;

public class GroundBlockGenerator implements Structure {

	private final Block ground;
	private final Block toPlace;
	
	public GroundBlockGenerator(Block ground, Block toPlace) {
		this.ground = ground;
		this.toPlace = toPlace;
	}
	
	@Override
	public void generate(World world, int x, int y, int z) {
		world.setBlock(x, y, z, this.toPlace, 0, 3);
	}

	@Override
	public boolean canGenerateAt(World world, int x, int y, int z) {
		if (world.getBlock(x, y, z) == null) return false;
		Block above = world.getBlock(x, y + 1, z);
		if (above != null && !above.isAir(world, x, y + 1, z)) return false;
		if (world.getBlock(x, y, z) != ground) return false;
		return true;
	}

}
