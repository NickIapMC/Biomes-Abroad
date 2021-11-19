package znick_.biomesabroad.block.templates;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import znick_.biomesabroad.block.BasicBlock;

/**
 * Class for creating custom dirt blocks. Dirt blocks have a hardness of 0.6, and use the vanilla grass material and sound.
 * They give off no light and are opaque and not multitextured.
 * 
 * @author zNick_
 */
public class DirtBlock extends BasicBlock {

	/**
	 * Creates a new dirt block with the specified properties
	 * 
	 * @param name The name of the block; Also used to set its texture
	 * @param category The folder where the texture is located
	 */
	public DirtBlock(String name, String category) {
		super(name, category, 0.6F, Material.grass, Block.soundTypeGrass, 0, true, false);
	}

}
