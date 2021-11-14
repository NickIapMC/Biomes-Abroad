package znick_.biomesabroad.block.templates;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import znick_.biomesabroad.block.BasicBlock;

public class DirtBlock extends BasicBlock {

	public DirtBlock(String name, String category) {
		super(name, category, 0.6F, Material.grass, Block.soundTypeGrass, 0, true, false);
	}

}
