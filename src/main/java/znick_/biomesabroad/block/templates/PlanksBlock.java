package znick_.biomesabroad.block.templates;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import znick_.biomesabroad.block.BasicBlock;

public class PlanksBlock extends BasicBlock {

	public PlanksBlock(String name, String category) {
		super(name, category, 2, Material.wood, Block.soundTypeWood, 0, true, false);
	}

}
