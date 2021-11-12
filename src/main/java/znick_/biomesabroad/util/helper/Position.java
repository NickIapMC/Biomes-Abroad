package znick_.biomesabroad.util.helper;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;

public class Position {

	public int x;
	public int y;
	public int z;
	
	public Block block;
	public int metadata;
	
	public Position(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
		
		this.block = Minecraft.getMinecraft().theWorld.getBlock(x, y, z);
		this.metadata = Minecraft.getMinecraft().theWorld.getBlockMetadata(x, y, z);
	}
	
}
