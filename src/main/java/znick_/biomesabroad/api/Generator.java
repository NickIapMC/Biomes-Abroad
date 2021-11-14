package znick_.biomesabroad.api;

import net.minecraft.world.World;

public interface Generator {
	public abstract void generate(World world, int x, int y, int z);
}
