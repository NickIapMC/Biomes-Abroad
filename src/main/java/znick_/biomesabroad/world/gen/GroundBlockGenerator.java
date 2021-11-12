package znick_.biomesabroad.world.gen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class GroundBlockGenerator extends WorldGenerator {

	private final Block ground;
	private final Block toPlace;
	
	public GroundBlockGenerator(Block ground, Block toPlace) {
		this.ground = ground;
		this.toPlace = toPlace;
	}
	
	@Override
	public boolean generate(World world, Random rand, int x, int y, int z) {
		if (world.getBlock(x, y, z) != null) {
			Block above = world.getBlock(x, y + 1, z);
			if ((above == null || above.isAir(world, x, y + 1, z)) && world.getBlock(x, y, z) == ground) {
				world.setBlock(x, y, z, this.toPlace, 0, 3);
				return true;
			}
		}
		return false;
	}

}
