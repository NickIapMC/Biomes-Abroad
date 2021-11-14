package znick_.biomesabroad.block.templates;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import znick_.biomesabroad.block.BasicBlock;

public class LeafBlock extends BasicBlock {

	public LeafBlock(String name, String category) {
		super(name, category, 0.2F, Material.leaves, Block.soundTypeGrass, 0, false, false);
	}

}
